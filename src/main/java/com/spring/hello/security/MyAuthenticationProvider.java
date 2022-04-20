package com.spring.hello.security;

import com.spring.hello.mapper.UserMapper;
import com.spring.hello.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MyPasswordEncoder bCryptPasswordEncoder;

    // 로그인 완료 후, 인증 정보는 세션 저장소인 SecurityContextHolder에 세션 - 쿠키 방식으로 저장됨 (키값 : Security ContextHolder)
    // 시큐리티 session <= Authentication 객체 (Token) <= UserDetails 객체 또는 OAuth2User 객체
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String insertedEmail = (String) authentication.getPrincipal();
        String insertedPwd = (String) authentication.getCredentials();
        UserVo userVo = null;

        // DB 접근 + 예외 처리
        try {
            userVo = userMapper.selectUser("email", insertedEmail);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationServiceException(insertedEmail);
        }

        // 이메일, 패스워드 관련 예외 처리
        if (userVo == null) {                                   // 이메일 존재 여부 (가입 여부)
            throw new UsernameNotFoundException(insertedEmail);
        }
        else if (!bCryptPasswordEncoder.matches(insertedPwd,userVo.getPassword())) {   // 패스워드 일치 여부
            throw new BadCredentialsException(insertedEmail);
        }

        // 사용자 권한 생성
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userVo.getRole()));

        // 세션에 저장하지 않을 유저 정보 초기화
        userVo.setPassword(null);
        userVo.setAddress(null);
        userVo.setPhone(null);
        userVo.setWebsite(null);
        userVo.setCompany(null);

        // 계정이 인증됐다면 Token 에 userVo와 권한을 담아서 리턴. (Authentication 의 구현체)
        return new UsernamePasswordAuthenticationToken(userVo, null, authorities);
    }

    // AuthenticationManager 가 Provider 의 토큰 지원 여부에 따라 Provider 를 선택하여 사용한다.
    @Override
    public boolean supports(Class<?> authentication) {
        return true;    // 인자로 받은 Token의 타입 체크 ex) instance of. 현재는 하나의 토큰 타입만 있으므로 true.
    }

}
