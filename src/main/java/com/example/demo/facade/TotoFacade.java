package com.example.demo.facade;

import com.example.demo.model.Toto;
import com.example.demo.service.TotoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface TotoFacade {

    public List<Toto> findAllById(List<Long> ids);
}
