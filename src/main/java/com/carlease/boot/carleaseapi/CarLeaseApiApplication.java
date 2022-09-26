package com.carlease.boot.carleaseapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.carlease.boot.carleaseapi.Service.UserServiceImpl;

@SpringBootApplication
public class CarLeaseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarLeaseApiApplication.class, args);
	}

}
