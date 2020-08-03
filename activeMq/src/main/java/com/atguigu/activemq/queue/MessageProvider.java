package com.atguigu.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageProvider {
    public static final String ACTIVEMQ_URL="tcp://192.168.49.129:61616";
    public static final String QUEUE_NAME = "queue01";
    public static void main(String[] args) throws Exception{
        //mq连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //创建会话
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageProducer producer = session.createProducer(queue);
        //创建消息生产者
        for(int i = 0; i < 3; i++){
            TextMessage textMessage = session.createTextMessage("msg--" + i);
            //通过生产者发送
            producer.send(textMessage);
        }
        //释放资源
        producer.close();
        session.close();
        connection.close();
        System.out.println("发布信息完成！");
    }
}
