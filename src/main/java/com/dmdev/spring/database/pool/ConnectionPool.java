package com.dmdev.spring.database.pool;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;

@Component("pool1")
public class ConnectionPool {
    private final String userName;

    @Getter
    private final Integer poolSize;
    public ConnectionPool(@Value("${db.username}") String userName,
                          @Value("${db.pool.size}") Integer poolSize) {
        this.userName = userName;
        this.poolSize = poolSize;
    }
    @PostConstruct
    private void init() {
        System.out.println("Init connection pool");
    }
    @PreDestroy
    private void destroy() {
        System.out.println("Clean connection pool");
    }
}
