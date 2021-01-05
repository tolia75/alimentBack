package com.example.demo.service.impl;

import com.example.demo.dao.AlimentDao;
import com.example.demo.model.Aliment;
import com.example.demo.service.AlimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AlimentServiceImpl implements AlimentService {

    @Autowired
    private AlimentDao alimentDao;

    @Override
    public Optional<Aliment> getAlimentById(Long id) {
        return alimentDao.findById(id);
    }

    @Override
    public List<Aliment> getAlimentsByIds(List<Long> ids) {
        return alimentDao.findAllById(ids);
    }

    @Override
    public List<Aliment> getAliments() {
        return alimentDao.findAll();
    }

    @Override
    public Optional<Aliment> updateAlimentById(Aliment aliment) {
        return Optional.ofNullable(alimentDao.save(aliment));
    }

    @Override
    public List<Aliment> updateAlimentsByIds(List<Aliment> aliments) {
        return aliments;
    }

    @Override
    public Optional<Aliment> saveAliment(Aliment aliment) {
        return Optional.ofNullable(alimentDao.save(aliment));
    }

    @Override
    public void deleteAlimentById(Long id) {
        alimentDao.deleteById(id);
    }

    @Override
    public void deleteAlimentsByIds(List<Aliment> aliments) {
        alimentDao.deleteAll(aliments);
    }
}
