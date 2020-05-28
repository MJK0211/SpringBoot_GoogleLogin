package com.bit.security.mapper;

import com.bit.security.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    UserVO readUser(String id);
    List<String> readAuth(String id);

}