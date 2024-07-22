package com.sarthak.zoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarthak.zoo.entity.Archive;

public interface ArchiveRepository extends JpaRepository<Archive, Long> {

}
