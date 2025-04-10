package com.unicesumar.igor.rpg.domain;

import com.unicesumar.igor.rpg.domain.enums.Classe;
import jakarta.persistence.*;
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
    private Integer força = 0;
    private Integer defesa = 0;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ItemMagico> itensMagicos = new ArrayList<>();
}
