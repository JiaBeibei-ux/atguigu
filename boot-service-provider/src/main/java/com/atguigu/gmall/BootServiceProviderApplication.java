package com.atguigu.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

/**
 *   1、导入依赖
 *    dubbo-starter,在application.properties配置属性，使用@Service\@Refenrce
 *   2、保留dubbo.xml配置文件
 *      导入dubbo-starter  使用@InportResoures导入dubbo的配置文件
 *   3、使用注解API的方式
 *       将每一个组件以bean的方式放到容器中
 */
@EnableDubbo(scanBasePackages ="com.atguigu.gmall")
//@ImportResource(locations = "classpath:provider.xml")
//@DubboComponentScan()
@EnableHystrix
@SpringBootApplication
public class BootServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootServiceProviderApplication.class, args);
    }

}
