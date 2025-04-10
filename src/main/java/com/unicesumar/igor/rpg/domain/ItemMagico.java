package com.unicesumar.igor.rpg.domain;

import com.unicesumar.igor.rpg.domain.enums.TipoItem;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
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


}
