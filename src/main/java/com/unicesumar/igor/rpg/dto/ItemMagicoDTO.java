package com.unicesumar.igor.rpg.dto;

import com.unicesumar.igor.rpg.domain.enums.TipoItem;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Builder
@Data
public class ItemMagicoDTO {

    private Long id;

    private String nome;
    private TipoItem tipoItem;
    @Builder.Default
    private Integer forca = 0;
    @Builder.Default
    private Integer defesa = 0;

}
