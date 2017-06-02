package com.bofoy.queue;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bofoy.queue.dao.UserDAO;
import com.bofoy.queue.domain.UserDTO;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(UserDAO repository) {
		return (args) -> {
			for (UserDTO u : repository.getAllUsers()) {
				System.out.println(u.toString());
			}
			System.out.println("------LOOKUP USER BY USERNAME dshin------");
			System.out.println(repository.getUser("booboobear"));
		};
	}
	
}
