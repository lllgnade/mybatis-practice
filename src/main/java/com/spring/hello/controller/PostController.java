package com.spring.hello.controller;

import com.spring.hello.mapper.PostMapper;
import com.spring.hello.vo.DetailedPostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PostController {


    @Autowired
    PostMapper postMapper;

    @GetMapping("/posts")
    @ResponseBody
    public List<DetailedPostVo> allPost(){
        List<DetailedPostVo> detailPost = postMapper.allPosts();
        return detailPost;
    }

}
