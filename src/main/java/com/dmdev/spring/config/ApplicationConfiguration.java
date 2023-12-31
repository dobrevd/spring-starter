package com.dmdev.spring.config;

import com.dmdev.spring.database.pool.ConnectionPool;
import com.dmdev.spring.database.repository.CrudRepository;
import com.dmdev.spring.database.repository.UserRepository;
import com.dmdev.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;

@Import(WebConfiguration.class)//импорт класса из другого пакета
@Configuration(proxyBeanMethods = true)
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.dmdev.spring",
    useDefaultFilters = false,
    includeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = Component.class),
        @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
        @Filter(type = FilterType.REGEX, pattern = "com\\..+Repository")
    })
public class ApplicationConfiguration {
    @Bean("pool2")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool pool2(@Value("${db.username}") String userName,
                                @Value("${db.pool.size}") Integer poolSize){
        return new ConnectionPool(userName, poolSize);
    }

    @Bean
    public ConnectionPool pool3(){
        return new ConnectionPool("test-pool",25);
    }
    @Bean
    public UserRepository userRepository(ConnectionPool pool2){
        return new UserRepository(pool2);
    }    @Bean
    public UserRepository userRepository3(){
        return new UserRepository(pool3());
    }
}
