package com.sarthak.zoo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarthak.zoo.entity.Zoo;

public interface ZooRepository extends JpaRepository<Zoo, Long>
{
	Optional<Zoo> findByName(String name);
}
