package com.unicesumar.igor.rpg.controller;


import com.unicesumar.igor.rpg.domain.ItemMagico;
import com.unicesumar.igor.rpg.service.ItemMagicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;

@RestController
@RequestMapping("item-magico")
@AllArgsConstructor
public class ItemMagicoController {

    private final ItemMagicoService service;

    @GetMapping()
    public ResponseEntity findAll() {
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/personagem/{idPersonagem}")
    public ResponseEntity findByPersonagemId(@PathVariable("idPersonagem") Long idPersonagem) {
        try {
            return ResponseEntity.ok(service.findByPersonagemId(idPersonagem));
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/amuleto/personagem/{idPersonagem}")
    public ResponseEntity findAmuteloByPersonagemId(@PathVariable("idPersonagem") Long idPersonagem) {
        try {
            return ResponseEntity.ok(service.findAmuletoByPersonagemId(idPersonagem));
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody ItemMagico personagem) {
        try {
            return ResponseEntity.status(201).body(service.save(personagem));
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ItemMagico personagem) {
        try {
            return ResponseEntity.ok(service.updateById(id, personagem));
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
