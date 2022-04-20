package com.spring.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * controller class
 */
@Controller
public class HomeController {

    /**
     * 이 함수는 index.jsp를 렌더링해서 보내준다.
     *
     * @param request 요청 객체
     * @return jsp view 이름.
     */
    @GetMapping("/")
    public String hello(HttpServletRequest request) {
        return "index"; //뷰네임 반환 (뷰 리졸버가 경로에 있는 뷰를 찾아감)
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request) {
        return "login";
    }


}
