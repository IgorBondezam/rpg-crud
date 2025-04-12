package com.unicesumar.igor.rpg.adapter;

import com.unicesumar.igor.rpg.domain.ItemMagico;
import com.unicesumar.igor.rpg.domain.Personagem;
import com.unicesumar.igor.rpg.dto.PersonagemDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PersonagemAdapter implements DtoAdapter<Personagem, PersonagemDTO> {

    private final ItemMagicoAdapter itemMagicoAdapter;

    @Override
    public Personagem toEntity(PersonagemDTO personagemDTO) {
        Personagem personagem = Personagem.builder()
                .id(personagemDTO.getId())
                .nome(personagemDTO.getNome())
                .nomeAventureiro(personagemDTO.getNomeAventureiro())
                .classe(personagemDTO.getClasse())
                .level(personagemDTO.getLevel())
                .forca(personagemDTO.getForca())
                .defesa(personagemDTO.getDefesa())
                .build();
        return personagem;
    }

    @Override
    public PersonagemDTO toDto(Personagem entity) {
        return PersonagemDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .nomeAventureiro(entity.getNomeAventureiro())
                .classe(entity.getClasse())
                .level(entity.getLevel())
                .forca(entity.getFullForca())
                .defesa(entity.getFullDefesa())
                .build();
    }
}
