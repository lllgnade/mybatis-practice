package com.spring.hello.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.hello.security.MyAuthenticationProvider;
import com.spring.hello.service.UserService;
import com.spring.hello.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

// @RestController = @Controller + @ResponseBody : Json
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MyAuthenticationProvider myAuthProvider;

    @GetMapping("/userlist")
    public String selectAll(Model model) throws JsonProcessingException {
        List<UserVo> userList = userService.allUsers();
        if(userList == null) {
            return "redirect:/";    // 실패 시 루트로 리다이렉트
        }
        model.addAttribute("userList", userList);

        //jackson 라이브러리 연습
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(userList);
            System.out.println(jsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        userList = objectMapper.readValue(jsonStr, new TypeReference<List<UserVo>>() {
        });
        // userList = Arrays.asList(objectMapper.readValue(jsonStr, UserVo[].class));
        System.out.println(userList);

        return "user/userlist";
    }

    /**
     * 사용자 정보를 조회
     * @param id   조회할 아이디
     */
    @GetMapping("/user")
    public String selectOne(@RequestParam int id, Model model) {
        UserVo userInfo = userService.selectUser("id", String.valueOf(id));
        model.addAttribute("userInfo", userInfo);
        return "user/userinfo";
    }

    /**
     * 내 정보 조회 :
     * 세션에 저장된 유저 id를 통해 DB에 접근해 전체 정보를 받아온다
     */
    @GetMapping("/myinfo")
    public String myInfo(Model model) {

        //세션에서 유저 정보 받아오기
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserVo userVo = (UserVo) authentication.getPrincipal();

        UserVo userInfo = userService.selectUser("id", String.valueOf(userVo.getId()));
        model.addAttribute("userInfo", userInfo);
        return "user/myinfo";
    }

    // 회원가입 뷰
    @GetMapping("/signup")
    public String signUp() {
        return "user/signup";
    }

    // 회원가입 로직 + 로그인
    @PostMapping("/signup")
    public String signUp(UserVo userVo, HttpServletRequest request) {
        String rawPassword = userVo.getPassword();

        try {
            int createdId = userService.createUser(userVo);
        } catch (Exception e) {
            return "redirect:/";
        }

        // 가입 성공시 바로 로그인
        try {
            Authentication authentication = myAuthProvider.authenticate(new UsernamePasswordAuthenticationToken(userVo.getEmail(), rawPassword));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch(Exception e) {
            e.printStackTrace();
            request.setAttribute("loginFailMsg", "가입에 성공했으나, 로그인에 실패하였습니다.");
            return "redirect:/login";
        }

        // 로그인 후 내 정보 페이지로 이동
        return "redirect:/myinfo";
        //return "redirect:/user?id=" + createdId;   // id 값을 이용해 등록된 사용자 정보를 보여준다.
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam int id) {

        int result = userService.deleteUser(id);
        if (result == -1) {
            return "redirect:/";    // 실패 시 루트로 리다이렉트
        }
        return "redirect:/userlist";
    }
}
