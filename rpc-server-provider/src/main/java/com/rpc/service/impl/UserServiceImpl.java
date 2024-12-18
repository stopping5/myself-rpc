package com.rpc.service.impl;

import com.rpc.entity.User;
import com.rpc.service.UserService;

public class UserServiceImpl implements UserService {


    @Override
    public String saveUser(User user) {
        System.out.println(user.toString());
        return "SUCCESS";
    }
}
