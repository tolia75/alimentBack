package com.example.demo.service;

import com.example.demo.model.Aliment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface AlimentService {

    public Optional<Aliment> getAlimentById(Long id);

    public List<Aliment> getAlimentsByIds(List<Long> ids);

    public List<Aliment> getAliments();

    public Optional<Aliment> updateAlimentById(Aliment aliment);

    public List<Aliment> updateAlimentsByIds(List<Aliment> aliments);

    public Optional<Aliment> saveAliment(Aliment aliment);

    public void deleteAlimentById(Long id);

    public void deleteAlimentsByIds(List<Aliment> aliments);

}
