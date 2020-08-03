package com.atguigu;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitClient {
    public static Connection getConnection(){
        ConnectionFactory factory = new ConnectionFactory();
        //指定一下主机和端口
        factory.setHost("192.168.49.129");
        factory.setPort(5672);
        factory.setUsername("test");
        factory.setPassword("test");
        factory.setVirtualHost("/test");
        //创建connection
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        //返回connection
        return connection;
    }
}
