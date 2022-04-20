package com.spring.hello.mapper;

import com.spring.hello.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// MyBatis의 mappers를 위한 marker interface

@Mapper
public interface UserMapper {

    /**
     * 모든 사용자를 선택
     * @return 사용자 정보 vo의 리스트
     */
    List<UserVo> allUsers();

    /**
     * 한 사용자를 선택
     * @param column 검색할 컬럼명
     * @param value 검색할 컬럼의 값
     * @return 사용자 정보 vo
     */
    UserVo selectUser(@Param("column") String column, @Param("value") String value);

    /**
     * 사용자 추가
     * useGeneratedKeys 속성과 keyProperty 속성을 사용해, userInfo의 id 속성에 생성된 id 값이 세팅된다.
     * @param userInfo 추가할 사용자의 데이터를 담은 vo.
     * @return 영향받은 행의 개수
     */
    int createUser(UserVo userInfo);

    /**
     * 사용자 삭제
     * @param id 삭제할 사용자의 id
     * @return 영향받은 행의 개수
     */
    int deleteUser(int id);

}
