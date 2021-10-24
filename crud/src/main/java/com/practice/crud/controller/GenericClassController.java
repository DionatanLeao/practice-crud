package com.practice.crud.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practice.crud.GenericClassService;
import com.practice.crud.entities.GenericClass;

@RestController
@RequestMapping("/endpoint")
public class GenericClassController {
	
	@Autowired
	private GenericClassService service;
	
	@PostMapping
	public ResponseEntity<GenericClass> save(@RequestBody GenericClass obj) {
		GenericClass objSave = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(objSave);
	}
	
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
	
	@PutMapping("/{id}")
	public ResponseEntity<GenericClass> update(@RequestBody GenericClass objUpdate, @PathVariable Integer id) throws Exception {
		GenericClass obj = service.update(id, objUpdate);
		return ResponseEntity.ok().body(obj);
	}

}
