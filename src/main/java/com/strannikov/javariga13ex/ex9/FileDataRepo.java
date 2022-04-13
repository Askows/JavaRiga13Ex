package com.strannikov.javariga13ex.ex9;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.UUID;

public interface FileDataRepo extends JpaRepository<FileData, UUID> {



}
