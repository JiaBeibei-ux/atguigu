package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserAddress;

import java.util.List;

/**
 * 初始化订单
 */
public interface OrderService {
    public List<UserAddress> initOrder(String userId);
}
