package com.practice.crud.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.practice.crud.entities.GenericClass;
import com.practice.crud.repositories.GenericClassRepository;

@Configuration
public class MockConfig implements CommandLineRunner {

	@Autowired
	private GenericClassRepository repo;

	@Override
	public void run(String... args) throws Exception {

		GenericClass crud1 = new GenericClass(1, "Created");
		GenericClass crud2 = new GenericClass(2, "Read");
		GenericClass crud3 = new GenericClass(3, "Update");
		GenericClass crud4 = new GenericClass(4, "Delete");

		repo.saveAll(Arrays.asList(crud1, crud2, crud3, crud4));

	}
}
