package com.hubert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScans({ @ComponentScan("com.hubert.config"), @ComponentScan("com.hubert.controller") })
@EnableJpaRepositories("com.hubert.repository")
@EntityScan("com.hubert.model")
public class FullLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullLoginApplication.class, args);
	}

}
