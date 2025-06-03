package com.abhi.birthdaywish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BirthdaywishApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirthdaywishApplication.class, args);
		System.out.println("Hi Abhishek Starting you application.");
	}


}
