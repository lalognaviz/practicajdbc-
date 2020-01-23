package com.projectodb.practicaJdbc.config;


import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


@Configuration
@ComponentScan("com.projectodb.practicaJdbc")
public class SpringJdbcConfig {



    @Bean
    public DataSource mysqlDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://85.10.205.173:3306/testjm");
        dataSource.setUsername("testjm");
        dataSource.setPassword("789456123");

        return dataSource;
    }


   /* public void setDataSource(String dataSource) {

    }*/
}