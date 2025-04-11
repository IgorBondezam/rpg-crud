package com.unicesumar.igor.rpg.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.unicesumar.igor.rpg.domain.enums.TipoItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemMagico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoItem tipoItem;
    @Builder.Default
    private Integer forca = 0;
    @Builder.Default
    private Integer defesa = 0;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private Personagem personagem;
}
