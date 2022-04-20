package com.spring.hello;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;


// 실패. 자동 주입 때문에?
public class MyBatisConnectionTest {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void connection_test() throws Exception {
        try(Connection con = sqlSessionFactory.openSession().getConnection()){
            System.out.println("커넥션 성공");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
