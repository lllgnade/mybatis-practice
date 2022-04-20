package com.spring.hello.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // for Jackson
@JsonInclude(JsonInclude.Include.NON_EMPTY)       // 값이 비어있는 필드는 제외하고 JSON 매핑
public class UserVo {
    private int id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phone;
    private String website;
    private String company;

    // 권한
    private String role = "ROLE_USER";

    public UserVo(String email, String password, String name) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
