package com.atguigu.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageConsumer2 {
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
        //创建消费者
        javax.jms.MessageConsumer consumer = session.createConsumer(queue);
        /*while(true){
            TextMessage textMessage = (TextMessage) consumer.receive();
            if(textMessage != null){
                System.out.println("message..."+textMessage.getText());
            }else{
                break;
            }
        }
        consumer.close();
        session.close();
        connection.close();*/
        //监听器
        /**
         * message 代表消费者拿到的消息
         */
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if(message != null && message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("Message**"+textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.in.read();
        session.close();
        connection.close();
    }
}
