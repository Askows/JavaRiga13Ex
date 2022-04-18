package com.strannikov.javariga13ex.security.repository;

import com.strannikov.javariga13ex.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {

}
