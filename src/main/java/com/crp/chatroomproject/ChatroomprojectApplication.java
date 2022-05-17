package com.crp.chatroomproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class ChatroomprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatroomprojectApplication.class, args);
	}

	@GetMapping("/error")
	public String error(){
		return "error";
	}
}
