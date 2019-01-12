package com.byungjun.repository.mapper;

import com.byungjun.repository.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> users() throws Exception;
    public User getUserByUsernam(String username) throws Exception;
    public List<User> getUsers() throws  Exception;
}
