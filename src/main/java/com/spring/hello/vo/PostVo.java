package com.spring.hello.vo;

import lombok.Data;

@Data
public class PostVo {
    private int userId; //User 외래키
    private int id;
    private String title;
    private String body;
}
