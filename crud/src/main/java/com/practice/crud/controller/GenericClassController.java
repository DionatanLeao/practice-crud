package com.practice.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.crud.GenericClassService;
import com.practice.crud.entities.GenericClass;

@RestController
@RequestMapping("/endpoint")
public class GenericClassController {
	
	@Autowired
	private GenericClassService service;
	
	@GetMapping
	public List<GenericClass> findAll() {
		return service.findAll();
	}
}
