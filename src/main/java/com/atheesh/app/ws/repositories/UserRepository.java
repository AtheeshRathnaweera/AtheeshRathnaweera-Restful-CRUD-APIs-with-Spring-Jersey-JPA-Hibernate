package com.atheesh.app.ws.repositories;

import com.atheesh.app.ws.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
