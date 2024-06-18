package com.sistema.ciao.sistema_ciao_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.ciao.sistema_ciao_backend.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findUserByName(String username);

    Optional<UserEntity> findUserByEmail(String email);
}
