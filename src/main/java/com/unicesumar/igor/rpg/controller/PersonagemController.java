package com.unicesumar.igor.rpg.controller;


import com.unicesumar.igor.rpg.adapter.PersonagemAdapter;
import com.unicesumar.igor.rpg.domain.Personagem;
import com.unicesumar.igor.rpg.dto.PersonagemDTO;
import com.unicesumar.igor.rpg.service.PersonagemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;

@RestController
@RequestMapping("/api/personagem")
@AllArgsConstructor
public class PersonagemController {

    private final PersonagemService service;
    private final PersonagemAdapter adapter;

    @GetMapping("/internal/entity")
    public ResponseEntity findAllEntity() {
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

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

    @PostMapping()
    public ResponseEntity save(@RequestBody PersonagemDTO personagem) {
        try {
            return ResponseEntity.status(201).body(adapter.toDto(service.save(adapter.toEntity(personagem))));
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping("/{id}/nome-aventureiro/{nomeAventureiro}")
    public ResponseEntity update(@PathVariable("id") Long id, @PathVariable("nomeAventureiro") String nomeAventureiro) {
        try {
            return ResponseEntity.ok(adapter.toDto(service.updateNomeAventureiroId(id, nomeAventureiro)));
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping("/{id}/adicionar-item/{itemMagicoId}")
    public ResponseEntity adicionarItemMagicoById(@PathVariable("id") Long id, @PathVariable("itemMagicoId") Long itemMagicoId) {
        try {
            service.adicionarItemMagico(id, itemMagicoId);
            return ResponseEntity.ok().build();
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping("/{id}/remover-item/{itemMagicoId}")
    public ResponseEntity removerItemMagicoById(@PathVariable("id") Long id, @PathVariable("itemMagicoId") Long itemMagicoId) {
        try {
            service.removerItemMagico(id, itemMagicoId);
            return ResponseEntity.ok().build();
        } catch (InvalidParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody PersonagemDTO personagem) {
        try {
            return ResponseEntity.ok(adapter.toDto(service.updateById(id, adapter.toEntity(personagem))));
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
