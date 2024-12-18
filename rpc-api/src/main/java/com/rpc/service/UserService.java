package com.rpc.service;

import com.rpc.entity.User;

/**
 * 用户服务接口
 */
public interface UserService {
    /**
     * 保存用户
     * @param user
     * @return
     */
    String saveUser(User user);
}
