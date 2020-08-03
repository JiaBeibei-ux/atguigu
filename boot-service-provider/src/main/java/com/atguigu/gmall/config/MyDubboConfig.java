package com.atguigu.gmall.config;

import com.alibaba.dubbo.config.*;
import com.atguigu.gmall.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * boot配置类
 */
@Configuration
public class MyDubboConfig {
      @Bean
      public ApplicationConfig applicationConfig(){
          ApplicationConfig applicationConfig = new ApplicationConfig();
          applicationConfig.setName("boot-service-provider");
          return applicationConfig;
      }
      @Bean
      public RegistryConfig registryConfig(){
          RegistryConfig registryConfig = new RegistryConfig();
          registryConfig.setProtocol("zookeeper");
          registryConfig.setAddress("127.0.0.1:2181");
          return registryConfig;
      }
      @Bean
      public ProtocolConfig protocolConfig(){
          ProtocolConfig protocolConfig = new ProtocolConfig();
          protocolConfig.setName("dubbo");
          protocolConfig.setPort(20881);
          return protocolConfig;
      }
/*<dubbo:service interface="com.atguigu.gmall.service.UserService" ref="userServiceImpl01" timeout="1000" version="1.0.0">
        <dubbo:method name="getUserAddressList" timeout="1000"></dubbo:method>
    </dubbo:service>*/
      @Bean
      public ServiceConfig<UserService> userServiceConfig(UserService userService){
          ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
          serviceConfig.setInterface(UserService.class);
          serviceConfig.setRef(userService);
          serviceConfig.setVersion("1.0.0");
          //配置每一个method的信息
          MethodConfig methodConfig = new MethodConfig();
          methodConfig.setName("getUserAddressList");
          methodConfig.setTimeout(1000);
          //间method的设置关联到service中
          List<MethodConfig> methods = new ArrayList<>();
          methods.add(methodConfig);
          serviceConfig.setMethods(methods);
          return serviceConfig;

      }
}
