package com.atguigu.cache;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootCacheApplicationTests {
    @Resource
    EmployeeMapper employeeMapper;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    RedisTemplate<Object, Employee> empRedisTemplate;

    @Test
    void contextLoads() {
        Employee employee = employeeMapper.getEmployeeId(1);
        System.out.println(employee);
    }

    @Test
    void test(){
        //stringRedisTemplate.opsForValue().append("msg","hello");
        /*String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);*/
        //stringRedisTemplate.opsForList().leftPush("mylist","1");
        //stringRedisTemplate.opsForList().leftPush("mylist","2");
        //测试保存对象
        Employee employee = employeeMapper.getEmployeeId(1);
        //redisTemplate.opsForValue().set("emp-01",employee);
        empRedisTemplate.opsForValue().set("emp-01",employee);

    }

    /*void test3(){
        empRedisTemplate
    }*/

}
