package com.unicesumar.igor.rpg.dto;

import com.unicesumar.igor.rpg.domain.enums.TipoItem;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemMagicoDTO {

    private Long id;

    private String nome;
    private TipoItem tipoItem;
    @Builder.Default
    private Integer forca = 0;
    @Builder.Default
    private Integer defesa = 0;
}
