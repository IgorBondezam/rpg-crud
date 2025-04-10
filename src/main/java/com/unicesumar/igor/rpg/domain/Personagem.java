package com.unicesumar.igor.rpg.domain;

import com.unicesumar.igor.rpg.domain.enums.Classe;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String nomeAventureiro;
    private Classe classe;
    private Integer level;
    private List<ItemMagico> itensMagicos = new ArrayList<>();
    private Integer força = 0;
    private Integer defesa = 0;
}
