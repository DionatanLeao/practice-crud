package com.practice.crud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
	
	public GenericClass update(Integer id, GenericClass objUpdate) {		
		GenericClass obj = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found: " + id));
		updateData(obj, objUpdate);
		return repo.save(obj);			
	}

	private void updateData(GenericClass obj, GenericClass objUpdate) {
		obj.setName(objUpdate.getName());
	}
	
	public Map<String, Boolean> delete(Integer id) throws Exception {
		GenericClass genericClass = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found: " + id));
		repo.delete(genericClass);
			
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

	}
}
