package com.example.demo.dao;

import com.example.demo.model.Toto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TotoDao extends JpaRepository<Toto, Long> {

    public List<Toto> findAllByIdIn(List<Long> ids);

}
