package com.atguigu.gmall.service.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import com.atguigu.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 将服务提供者注册到注册中心
 *      导入依赖 dubbo 和操作zookeeper的客户端
 *        暴露服务
 * 让消费者取注册中心订阅服务提供者的服务地址
 */
//@Service("orderService")
@Service
public class OrderServiceImpl implements OrderService {
    //@Autowired
    @Reference
    UserService userService;
    @HystrixCommand(fallbackMethod ="hello")
    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id:"+userId);
        //查询用户的收货地址
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        for (UserAddress address : userAddressList) {
            System.out.println(address);
        }
        return userAddressList;
    }

    public List<UserAddress> hello(String userId) {
        System.out.println("Hystrix");
        //查询用户的收货地址
        return Arrays.asList(new UserAddress(10,"测试地址","!","测试","测试","Y"));
    }
}
