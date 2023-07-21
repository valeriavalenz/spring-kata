package com.ss.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SprintDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SprintDemoApplication.class, args);
  }

}
