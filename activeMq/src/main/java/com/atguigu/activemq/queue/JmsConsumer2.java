package com.atguigu.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息消费者
 */
public class JmsConsumer2 {
    public static final String ACTIVEMQ_URL = "tcp://192.168.49.129:61616";
    private static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws Exception{
        System.out.println("我是二号消费者！");
        //1、创建连接工厂
        ActiveMQConnectionFactory mqConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //获取连接
        Connection connection = mqConnectionFactory.createConnection();
        connection.start();
        //创建回话session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地（具体的队列还是主题）
        Queue queue = session.createQueue(QUEUE_NAME);
        //消费者接受消息
        MessageConsumer messageConsumer = session.createConsumer(queue);
        /*while(true){
            TextMessage textMessage = (TextMessage)messageConsumer.receive(4000l);
            if(textMessage != null){
                System.out.printf("***消费者接受到消息："+textMessage.getText());
            }else{
                break;
            }
        }
        messageConsumer.close();
        session.close();
        connection.close();*/
        //通过坚挺的方式来获取消息
        ((javax.jms.MessageConsumer) messageConsumer).setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
               if(message != null && message instanceof TextMessage){
                   TextMessage textMessage = (TextMessage)message;
                   try {
                       System.out.println("消息接受**"+textMessage.getText());
                   } catch (JMSException e) {
                       e.printStackTrace();
                   }
               }
            }
        });
        System.in.read();
        messageConsumer.close();
        session.close();
    }
}
