package com.javatester.book.rest;

import com.javatester.book.dao.BookDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DBInitializer {
    private static final Logger log = LoggerFactory.getLogger(DBInitializer.class);

    @PostConstruct
    private void init() {
        log.info("DB starting..");
        BookDB.getInstance();
    }
}
