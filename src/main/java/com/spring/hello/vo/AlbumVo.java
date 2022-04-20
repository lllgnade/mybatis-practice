package com.spring.hello.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AlbumVo implements Serializable {
    private int id;
    private int userId;
    private String title;

}
