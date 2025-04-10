package com.unicesumar.igor.rpg.adapter;

import com.unicesumar.igor.rpg.domain.Personagem;
import com.unicesumar.igor.rpg.dto.PersonagemDTO;

public class PersonagemAdapter implements DtoAdapter<Personagem, PersonagemDTO> {

    @Override
    public Personagem toEntity(PersonagemDTO personagemDTO) {
        Personagem personagem = Personagem.builder()
                .nome(personagemDTO.getNome())
                .nomeAventureiro(personagemDTO.getNomeAventureiro())
                .classe(personagemDTO.getClasse())
                .level(personagemDTO.getLevel())
                .forca(personagemDTO.getForca())
                .defesa(personagemDTO.getDefesa())
                .build();
        personagem
    }

    @Override
    public PersonagemDTO toDto(Personagem entity) {
        return PersonagemDTO.builder()
                .nome(entity.getNome())
                .nomeAventureiro(entity.getNomeAventureiro())
                .classe(entity.getClasse())
                .level(entity.getLevel())
                .forca(entity.getFullForca())
                .defesa(entity.getFullDefesa())
                .build();
    }
}
