package com.initgrep.compaigner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CompaignerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompaignerApplication.class, args);
	}

}
