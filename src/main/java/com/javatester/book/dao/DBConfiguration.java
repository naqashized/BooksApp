package com.javatester.book.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;

@Configuration
public class DBConfiguration {

    @Bean
    public DataSource getDataSource(){
        return BookDB.getInstance().getDataSource();
    }

    @Bean
    public Connection getConnection(){
        return BookDB.getInstance().getConnection();
    }
}
