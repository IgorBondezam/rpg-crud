package com.unicesumar.igor.rpg.domain;

import com.unicesumar.igor.rpg.domain.enums.TipoItem;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ItemMagico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoItem tipoItem;
    private Integer força = 0;
    private Integer defesa = 0;


}
