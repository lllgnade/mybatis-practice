package com.spring.hello.service;

import com.spring.hello.mapper.UserMapper;
import com.spring.hello.security.MyPasswordEncoder;
import com.spring.hello.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    private MyPasswordEncoder bCryptPasswordEncoder;

    /**
     * 사용자 생성
     *
     * @param userVo 생성할 사용자 정보를 UserVo에 담음
     * @return 생성된 id값 반환. DB 오류시 -1
     */
    public int createUser(UserVo userVo) {

        // 패스워드 인코딩
        String rawPassword = userVo.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        userVo.setPassword(encPassword);

        userMapper.createUser(userVo);    // 실행 결과, userInfo의 id 속성에 생성된 id 값이 담긴다.
        int createdId = userVo.getId();     //여기서부턴 없어도 됨. 최대한 간단하게 구성. 에러는 그냥 Exception 으로 컨트롤러에 던지자
        return createdId;
    }

    public UserVo selectUser(String column, String value) {
        UserVo userVo = userMapper.selectUser(column, value);
        return userVo;
    }

    public List<UserVo> allUsers() {
        List<UserVo> userList = userMapper.allUsers();
        return userList;
    }

    public int deleteUser(int id) {
        int result = userMapper.deleteUser(id);
        return result;
    }
}
