package com.sarthak.zoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarthak.zoo.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
