package com.byungjun.auth.service;

import com.byungjun.repository.domain.User;

import java.util.List;

public interface AuthService {
    public List<User> users() throws Exception;
    public User getUserByUsername(String username) throws Exception;
    public List<User> getUsers() throws  Exception;

}
