package com.spring.hello.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)  //값이 비어있는 필드는 제외하고 JSON 데이터 매핑
public class DetailedPostVo {
    private int id;
    private String title;
    private String body;
    private UserVo user;
    private List<CommentVo> comments;
}
