package com.atguigu.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


public class JmsTopic {
    public static final String ACTIVEMQ_URL = "tcp://192.168.49.129:61616";
    public static final String TOPIC_NAME = "topic-atguigu";
    public static void main(String[] args) throws Exception {
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
        //创建生产者
        MessageProducer producer = session.createProducer(topic);
        //生产信息
        for (int i = 0; i <3 ; i++) {
            TextMessage textMessage = session.createTextMessage("message**" + i);
            //发送信息
            producer.send(textMessage);
            MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("k1","v1");
            producer.send(mapMessage);
        }
        //释放资源
        producer.close();
        session.close();
        connection.close();
        System.out.println("消息发送！");
    }
}
