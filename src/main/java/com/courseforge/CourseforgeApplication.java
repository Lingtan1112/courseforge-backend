package com.courseforge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class})
@EnableFeignClients
@ComponentScan(basePackages = "com.courseforge")
@EnableMongoRepositories(basePackages = "com.courseforge")
public class CourseforgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseforgeApplication.class, args);
	}

}
