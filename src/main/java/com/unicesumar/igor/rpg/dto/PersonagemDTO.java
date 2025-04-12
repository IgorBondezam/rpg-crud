package com.unicesumar.igor.rpg.dto;

import com.unicesumar.igor.rpg.domain.enums.Classe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonagemDTO {

    private Long id;

    private String nome;
    private String nomeAventureiro;
    private Classe classe;
    private Integer level;
    @Builder.Default
    private Integer forca = 0;
    @Builder.Default
    private Integer defesa = 0;
}
