package com.ossms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.ossms")
@EnableJpaRepositories("com.ossms.repository")
@EntityScan("com.ossms.model")
public class OssmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OssmsApplication.class, args);
	}

}
