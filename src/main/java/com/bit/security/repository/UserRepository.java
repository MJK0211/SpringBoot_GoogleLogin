package com.bit.security.repository;

import com.bit.security.domain.UserVO;
import com.bit.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    UserMapper userMapper;

    public UserVO findById(String username) {
        return userMapper.readUser(username);
    }

    public List<String>findauthoritiesbyid(String username){
        return (List<String>)userMapper.readAuth(username);
    }

}