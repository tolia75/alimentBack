package com.example.demo.service;

import com.example.demo.model.Toto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface TotoService {

    public List<Toto> findAllById(List<Long> ids);
}
