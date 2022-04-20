package com.spring.hello.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyAuthenticationProvider myAuthenticationProvider;
    @Autowired
    AuthFailHandler authFailHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http    .authorizeRequests()
                .antMatchers("/login").permitAll()      // 해주는 게 의미가 있음
                .antMatchers("/signup").permitAll()     // 로그인 없이 접근 가능한 URI
                .antMatchers("/js/**","/css/**","/static/img/**","/static/frontend/**").permitAll()
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")  //ADMIN ROLE이어야만 '/manage' 하위의 uri 에 접근 가능
                .anyRequest().authenticated();   //어떤 uri로 접근하든 인증이 필요함

        http    .formLogin()    // 폼 방식 로그인
                .loginPage("/login")        // '/'를 붙이지 않으면 에러가 남
                .loginProcessingUrl("/loginProc")   // 이 주소가 호출되면 시큐리티가 낚아채서 대신 로그인을 진행해 줌.
                .usernameParameter("email")
                .passwordParameter("password")
                .failureHandler(authFailHandler)
                .defaultSuccessUrl("/myinfo")
                .permitAll();

        http    .logout()      // 로그아웃 (기본값 : /logout)
                .logoutUrl("/logout");
                //.logoutRequestMatcher(new AntPathRequestMatcher("/logoutProc"))    //'/logoutProc'을 호출할 시 로그아웃이 됨
    }

    // 커스텀 AuthenticationProvider 설정
    // 복잡한 절차 없이 Provider 에서 DB 등의 작업을 다 처리하는 것이 좋다.
    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(myAuthenticationProvider);
    }
}
