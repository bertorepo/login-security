package com.hubert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans({@ComponentScan("com.hubert.config"), @ComponentScan("com.hubert.controller")})
public class FullLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullLoginApplication.class, args);
	}

}
