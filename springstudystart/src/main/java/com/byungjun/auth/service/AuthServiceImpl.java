package com.byungjun.auth.service;

import com.byungjun.repository.domain.User;
import com.byungjun.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AuthService")
public class AuthServiceImpl implements AuthService{

    @Autowired
    UserMapper mapper;

    @Override
    public List<User> users() throws Exception {
        return mapper.users();
    }

    @Override
    public User getUserByUsername(String username) throws  Exception{
        return mapper.getUserByUsernam(username);
    }

    @Override
    public List<User> getUsers() throws Exception {
        return mapper.getUsers();
    }
}
