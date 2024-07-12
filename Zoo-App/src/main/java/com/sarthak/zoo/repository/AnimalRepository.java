package com.sarthak.zoo.repository;

import org.springframework.data.repository.CrudRepository;

import com.sarthak.zoo.entity.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

}
