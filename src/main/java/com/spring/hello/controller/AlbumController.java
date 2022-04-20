package com.spring.hello.controller;

import com.spring.hello.vo.AlbumVo;
import com.spring.hello.mapper.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumController {

    @Autowired
    AlbumMapper albumMapper;

    @GetMapping("/albums")
    List<AlbumVo> selectAll() {
        return albumMapper.allAlbums();
    }
}
