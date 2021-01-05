package com.example.demo.controller;

import com.example.demo.model.Aliment;
import com.example.demo.service.AlimentService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/aliment")
public class AlimentController {

    @Autowired
    private AlimentService alimentService;

    @GetMapping()
    public ResponseEntity<List<Aliment>> getAliments() {
        List<Aliment> aliments = alimentService.getAliments();

        if (CollectionUtils.isEmpty(aliments)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(aliments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aliment> getAlimentById (
            @PathVariable
            @NotNull
            Long id) {
        return alimentService.getAlimentById(id).map(aliment -> ResponseEntity.ok(aliment))
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("/{ids}")
    public ResponseEntity<List<Aliment>> getAlimentsByIds(
            @PathVariable
            @NotNull
            List<Long> ids) {
        List<Aliment> aliments = alimentService.getAlimentsByIds(ids);

        if (CollectionUtils.isEmpty(aliments)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(aliments);
    }

    @PostMapping()
    public ResponseEntity<Aliment> createAliment(
            @Valid
            @RequestBody
            Aliment aliment) {
        return alimentService.saveAliment(aliment).map(alimentCree -> ResponseEntity.ok(alimentCree))
                .orElse(ResponseEntity.noContent().build());
    }
}
