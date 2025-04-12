package com.unicesumar.igor.rpg.controller;


import com.unicesumar.igor.rpg.adapter.ItemMagicoAdapter;
import com.unicesumar.igor.rpg.dto.ItemMagicoDTO;
import com.unicesumar.igor.rpg.service.ItemMagicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;

@RestController
@RequestMapping("/api/item-magico")
@AllArgsConstructor
public class ItemMagicoController {

    private final ItemMagicoService service;
    private final ItemMagicoAdapter adapter;

    @GetMapping()
    public ResponseEntity findAll() {
        try {
            return ResponseEntity.ok(service.findAll().stream().map(adapter::toDto));
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(adapter.toDto(service.findById(id)));
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/personagem/{idPersonagem}")
    public ResponseEntity findByPersonagemId(@PathVariable("idPersonagem") Long idPersonagem) {
        try {
            return ResponseEntity.ok(service.findByPersonagemId(idPersonagem).stream().map(adapter::toDto));
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/amuleto/personagem/{idPersonagem}")
    public ResponseEntity findAmuteloByPersonagemId(@PathVariable("idPersonagem") Long idPersonagem) {
        try {
            return ResponseEntity.ok(adapter.toDto(service.findAmuletoByPersonagemId(idPersonagem)));
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody ItemMagicoDTO itemMagico) {
        try {
            return ResponseEntity.status(201).body(adapter.toDto(service.save(adapter.toEntity(itemMagico))));
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ItemMagicoDTO itemMagico) {
        try {
            return ResponseEntity.ok(adapter.toDto(service.updateById(id, adapter.toEntity(itemMagico))));
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
