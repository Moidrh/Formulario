package com.valid.formulario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valid.formulario.entity.User;

/**
 * User Repository
 * */
public interface UserRepository extends JpaRepository<User, Integer> {

}