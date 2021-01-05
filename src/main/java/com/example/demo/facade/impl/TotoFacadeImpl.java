package com.example.demo.facade.impl;

import com.example.demo.facade.TotoFacade;
import com.example.demo.model.Toto;
import com.example.demo.service.TotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TotoFacadeImpl implements TotoFacade {

    @Autowired
    private TotoService totoService;

    @Override
    public List<Toto> findAllById(List<Long> ids) {
        return totoService.findAllById(ids);
    }
}
