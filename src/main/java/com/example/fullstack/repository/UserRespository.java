package com.example.fullstack.repository;

import com.example.fullstack.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<Users, Long> {

}
