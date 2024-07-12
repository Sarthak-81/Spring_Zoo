package com.sarthak.zoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sarthak.zoo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	User findByNameAndPassword(String name, String password);
}
 