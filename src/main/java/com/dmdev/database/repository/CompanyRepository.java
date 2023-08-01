package com.dmdev.database.repository;

import com.dmdev.database.pool.ConnectionPool;

public class CompanyRepository {

    private final ConnectionPool connectionPool;

    public CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    //статический метод инициализации, фабричный метод
    public static CompanyRepository of(ConnectionPool connectionPool){
        return new CompanyRepository(connectionPool);
    }
}
