package com.github.guisofiati.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.guisofiati.dscatalog.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	// buscar user no banco por email
	User findByEmail(String email);
}
