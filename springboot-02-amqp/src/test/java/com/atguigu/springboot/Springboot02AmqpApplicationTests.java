package com.atguigu.springboot;

import com.atguigu.springboot.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02AmqpApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    RabbitAdmin rabbitAdmin;
    @Test
    public void createExchange(){
        //rabbitAdmin.declareExchange(new DirectExchange("MyExchange"));
        //rabbitAdmin.declareQueue(new Queue("MyQueue",true));
        rabbitAdmin.declareBinding(new Binding("MyQueue",Binding.DestinationType.QUEUE,"MyExchange","haha",null ));
        System.out.println("创建完成");
    }
    /**
     * 1、单播 点对点
     */
    @Test
    public void contextLoads() {
        //message自定义的
     //rabbitTemplate.send(exchage,routeKey,message);
      Map<String,Object> map = new HashMap<>();
      map.put("msg","这是第一个消息");
      map.put("data", Arrays.asList("HelloWorld",123,true));
      rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("西游记","吴承恩"));
    }
    @Test
    public void receive(){
      Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
      System.out.println(o.getClass());
      System.out.println(o);
    }

    /**
     * 广播
     */
    @Test
    public void sendMessage(){
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("三国gdfg","luogfg"));
    }
}
