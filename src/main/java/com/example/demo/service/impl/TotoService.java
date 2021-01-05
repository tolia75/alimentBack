package com.example.demo.service.impl;

import com.example.demo.dao.TotoDao;
import com.example.demo.model.Toto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TotoService implements com.example.demo.service.TotoService {

    @Autowired
    private TotoDao totoDao;

    @Override
    public List<Toto> findAllById(List<Long> ids) {
        return totoDao.findAllById(ids).stream().filter(toto -> toto.getId().equals(1L)).collect(Collectors.toList());
    }
}
