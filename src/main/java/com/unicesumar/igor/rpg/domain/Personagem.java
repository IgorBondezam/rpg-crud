package com.unicesumar.igor.rpg.domain;

import com.unicesumar.igor.rpg.domain.enums.Classe;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String nomeAventureiro;
    @Enumerated(EnumType.STRING)
    private Classe classe;
    private Integer level;
    @Builder.Default
    private Integer forca = 0;
    @Builder.Default
    private Integer defesa = 0;

    @Builder.Default
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ItemMagico> itensMagicos = new ArrayList<>();

    public Integer getFullForca() {
        return forca + itensMagicos.stream().mapToInt(ItemMagico::getForca).sum();
    }

    public Integer getFullDefesa() {
        return defesa + itensMagicos.stream().mapToInt(ItemMagico::getDefesa).sum();
    }
}
