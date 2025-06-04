package com.abhi.birthdaywish;

import com.abhi.birthdaywish.config.NotificationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableConfigurationProperties(NotificationProperties.class)
@EnableScheduling
public class BirthdaywishApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirthdaywishApplication.class, args);
		System.out.println("Hi Abhishek Starting you application.");
	}


}
