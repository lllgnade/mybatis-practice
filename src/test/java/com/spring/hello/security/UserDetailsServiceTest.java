package com.spring.hello.security;

import com.spring.hello.mapper.UserMapper;
import com.spring.hello.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Service
class UserDetailsServiceTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void loadUserByUsername() {
        UserVo user = userMapper.selectUser("email","dhlee@iotree.co.kr");
        if (user != null) {
            System.out.println(user.toString());
        }
    }
}