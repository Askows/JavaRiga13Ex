package com.strannikov.javariga13ex.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {

}
