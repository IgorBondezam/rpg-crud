package com.unicesumar.igor.rpg.adapter;

public interface DtoAdapter<E, DTO> {

    E toEntity(DTO dto);
    DTO toDto(E entity);
}
