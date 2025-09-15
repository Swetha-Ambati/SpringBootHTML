package com.example.springBoothtml.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springBoothtml.Model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByusername(String username); 

}
