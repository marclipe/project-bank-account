package com.bankaccount.projectbankaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bankaccount")
public class ProjectBankAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectBankAccountApplication.class, args);
	}
}
