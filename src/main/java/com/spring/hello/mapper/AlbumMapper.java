package com.spring.hello.mapper;

import com.spring.hello.vo.AlbumVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlbumMapper {

    // 매퍼 파일과 연결됨
    List<AlbumVo> allAlbums();
}
