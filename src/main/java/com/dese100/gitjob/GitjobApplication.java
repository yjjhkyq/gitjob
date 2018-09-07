package com.dese100.gitjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class GitjobApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitjobApplication.class, args);
	}
}
