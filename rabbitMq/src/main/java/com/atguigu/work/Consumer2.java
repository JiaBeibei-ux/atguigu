package com.atguigu.work;

import com.atguigu.RabbitClient;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer2 {
    public static void main(String[] args) throws Exception{
        Connection connection = RabbitClient.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("Work",true,false,false,null);
        channel.basicQos(1);
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1号接受message: "+new String(body,"UTF-8"));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume("Work",false,defaultConsumer);
        System.out.println("消费者开始监听消息了");
        System.in.read();
        channel.close();
        connection.close();
    }
}
