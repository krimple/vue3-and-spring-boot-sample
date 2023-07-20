package com.chariot.demos.springboot.restfulserver;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

//  @Bean()
//  @ConfigurationProperties(prefix = "spring.datasource")
//  public DataSourceProperties getDataSourceProperties(DataSourceProperties props) {
//    return props;
//  }

  @Bean
  @Primary
  public DataSource getDataSource(DataSourceProperties properties) {
    return DataSourceBuilder.create()
        .driverClassName(properties.determineDriverClassName())
        .url(properties.getUrl())
        .username(properties.getUsername())
        .password(properties.getPassword())
        .build();
  }
}
