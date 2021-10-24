package com.practice.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<List<GenericClass>> findAll() {
		List<GenericClass> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<GenericClass>> findById(@PathVariable Integer id) {
		Optional<GenericClass> obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
