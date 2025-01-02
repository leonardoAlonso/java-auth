package com.example.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.auth.common.entities.UserModel;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserModel, Long> {

  Optional<UserModel> findByEmail(String email);

}
