package com.example.demo.dao;

import com.example.demo.model.Aliment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentDao extends JpaRepository<Aliment, Long> {

}
