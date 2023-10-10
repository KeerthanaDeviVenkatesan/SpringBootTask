package com.FileUploadMultipart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class FileUploadMultipartApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadMultipartApplication.class, args);
	}

}
