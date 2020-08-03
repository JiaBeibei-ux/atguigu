package com.atguigu.helloworld;

import com.atguigu.RabbitClient;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Publisher {
    public static void main(String[] args) throws Exception{
        Connection connection = RabbitClient.getConnection();
        Channel channel = connection.createChannel();
        String msg = "Hello--World";
        //发布消息
        channel.basicPublish("","HelloWorld",null,msg.getBytes());

        System.out.println("消息发布成功！");
        channel.close();
        connection.close();

    }
}
