package com.unicesumar.igor.rpg.controller;


import com.unicesumar.igor.rpg.domain.Personagem;
import com.unicesumar.igor.rpg.service.PersonagemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personagem")
@AllArgsConstructor
public class PersonagemController {

    private final PersonagemService service;

    @GetMapping()
    public List<ResponseEntity<Personagem>> findAll() {
    }

    @GetMapping()
    
    @PostMapping()

    @PutMapping()

    @DeleteMapping()
}
