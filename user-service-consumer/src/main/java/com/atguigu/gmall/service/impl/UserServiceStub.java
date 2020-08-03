package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserService;
import org.springframework.util.StringUtils;

import java.util.List;

public class UserServiceStub implements UserService {

    private final UserService userService;

    /**
     * 传入的是userService代理对象
     * @param userService
     */
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("userservicestub....");
        if(!StringUtils.isEmpty(userId)){
            List<UserAddress> userAddressList = userService.getUserAddressList(userId);
            return userAddressList;
        }
        return null;
    }
}
