package com.practice.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.crud.entities.GenericClass;

public interface GenericClassRepository extends JpaRepository<GenericClass, Integer>{

}
