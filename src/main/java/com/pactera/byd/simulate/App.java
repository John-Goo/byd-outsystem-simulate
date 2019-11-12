package com.pactera.byd.simulate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
// exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("Hello World!");
    }
}