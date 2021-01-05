package com.example.demo.controller;

import com.example.demo.facade.TotoFacade;
import com.example.demo.model.Toto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private TotoFacade totoFacade;

    @GetMapping("byIds")
    public ResponseEntity<List<Toto>> getTotosByIds(@RequestParam(required = false) Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        List<Toto> totos = totoFacade.findAllById(List.of(id));
        if(CollectionUtils.isEmpty(totos)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(totos);
    }
}
