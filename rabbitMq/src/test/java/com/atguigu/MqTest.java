package com.atguigu;

import com.rabbitmq.client.Connection;
import org.junit.Test;

public class MqTest {
    @Test
    public void test() throws Exception{
        Connection connection = RabbitClient.getConnection();
        connection.close();
    }
}
