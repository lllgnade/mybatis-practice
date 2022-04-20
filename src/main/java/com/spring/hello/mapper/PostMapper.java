package com.spring.hello.mapper;

import com.spring.hello.vo.DetailedPostVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    List<DetailedPostVo> allPosts();

}
