package com.practice.crud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.crud.entities.GenericClass;
import com.practice.crud.repositories.GenericClassRepository;


@Service
public class GenericClassService {

	@Autowired
	private GenericClassRepository repo;

	public List<GenericClass> findAll() {
		return repo.findAll();
	}

	public Optional<GenericClass> findById(Integer id) {
		return repo.findById(id);
	}
	
	public GenericClass save(GenericClass obj) {
		return repo.save(obj);
	}
	
	public GenericClass update(GenericClass objUpdate, Integer id) throws Exception {
		GenericClass genericClass = repo.findById(id).orElseThrow(() -> new Exception("genericClass not found: " + id));
		genericClass.setId(objUpdate.getId());
		genericClass.setName(objUpdate.getName());
		return repo.save(genericClass);
	}
	
	public Map<String, Boolean> delete(Integer id) throws Exception {
		GenericClass genericClass = repo.findById(id).orElseThrow(() -> new Exception("Crud not found: " + id));
		repo.delete(genericClass);
			
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

	}
}
