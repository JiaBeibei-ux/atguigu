package com.atguigu.helloworld;

import com.atguigu.RabbitClient;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer {
    public static void main(String[] args) throws Exception{
        Connection connection = RabbitClient.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("HelloWorld",true,false,false,null);
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(java.lang.String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("message: "+new String(body,"UTF-8"));
            }
        };
        channel.basicConsume("HelloWorld",true,defaultConsumer);
        System.out.println("消费者开始监听消息了");
        System.in.read();
        channel.close();
        connection.close();
    }
}
