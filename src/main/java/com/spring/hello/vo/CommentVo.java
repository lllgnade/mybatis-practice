package com.spring.hello.vo;

import lombok.Data;

@Data
public class CommentVo {
    private int postId; //Post 외래키
    private int id;
    private String name;
    private String email;
    private String body;
}
