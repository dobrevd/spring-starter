package com.dmdev.spring;

import com.dmdev.spring.database.pool.ConnectionPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
@ConfigurationPropertiesScan
@SpringBootApplication
public class ApplicationRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);

        System.out.println(context.getBeanDefinitionCount());
        System.out.println(context.getBean("pool1"));
        System.out.println();
    }
}
