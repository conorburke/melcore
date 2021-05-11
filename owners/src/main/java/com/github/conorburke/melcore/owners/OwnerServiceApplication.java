package com.github.conorburke.melcore.owners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class OwnerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OwnerServiceApplication.class, args);
	}

}
