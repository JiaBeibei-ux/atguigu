package com.atguigu.springboot.service;

import com.atguigu.springboot.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book){
        System.out.println("Receive message!"+book);
    }
    @RabbitListener(queues = "atguigu")
    public void receive2(Message message){
        System.out.println(message.getMessageProperties());
        System.out.println(message.getBody());
        System.out.println("Receive message!"+message);
    }
}
