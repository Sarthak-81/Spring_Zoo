package com.sarthak.zoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarthak.zoo.entity.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long>
{

}
