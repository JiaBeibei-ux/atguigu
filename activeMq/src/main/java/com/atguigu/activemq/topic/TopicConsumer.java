package com.atguigu.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.rmi.server.ExportException;

public class TopicConsumer {
    public static final String ACTIVEMQ_URL = "tcp://192.168.49.129:61616";
    public static final String TOPIC_NAME = "topic-atguigu";

    public static void main(String[] args) throws Exception {
        System.out.println("1号订阅者");
        //创建连接工厂
        ActiveMQConnectionFactory mqConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //创建连接
        Connection connection = mqConnectionFactory.createConnection();
        //开启连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地
        Topic topic = session.createTopic(TOPIC_NAME);
        //创建消费之
        MessageConsumer consumer = session.createConsumer(topic);
        //使用监听器
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if(message != null && message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("message"+textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.in.read();
        //释放资源
        consumer.close();
        session.close();
        connection.close();
    }
}
