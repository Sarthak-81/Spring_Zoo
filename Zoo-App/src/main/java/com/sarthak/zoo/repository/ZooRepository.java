package com.sarthak.zoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarthak.zoo.entity.Zoo;

public interface ZooRepository extends JpaRepository<Zoo, Long>
{

}
