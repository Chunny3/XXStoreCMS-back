package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.ProductRepository;
import com.example.demo.model.*
;

@SpringBootApplication
public class Testspringboot0617Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Testspringboot0617Application.class, args);
	}

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Product p1 = new Product((int)101, "phone", 100.0, "It's a phone");
		productRepository.save(p1);
	}
}
