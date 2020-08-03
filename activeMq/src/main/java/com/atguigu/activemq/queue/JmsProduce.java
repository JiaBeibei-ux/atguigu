package com.atguigu.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce {
    public static final String ACTIVEMQ_URL = "tcp://192.168.49.129:61616";
    private static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws Exception{
        //1、创建连接工厂
        ActiveMQConnectionFactory mqConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //获取连接
        Connection connection = mqConnectionFactory.createConnection();
        connection.start();
        //创建回话session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地（具体的队列还是主题）
        Queue queue = session.createQueue(QUEUE_NAME);
        //创建消息生产者
        MessageProducer producer = session.createProducer(queue);
        //持久化
        //producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        //通过消息生产者生产3条消息发送到mq的队列里
        for (int i=1;i<=3;i++){
            //System.out.println();
            //创建消息
            TextMessage textMessage = session.createTextMessage("msg---" + i);
            //textMessage.setStringProperty("c01","vip");
            //通过生产者发送给mq
            producer.send(textMessage);
            /*MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("k1","v1");
            producer.send(mapMessage);*/
        }
        //9、关闭资源
        producer.close();
        session.close();
        connection.close();
        System.out.println("****消息发布到mq完成！");
    }
}
