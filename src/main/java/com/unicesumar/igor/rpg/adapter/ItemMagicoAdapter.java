package com.unicesumar.igor.rpg.adapter;

import com.unicesumar.igor.rpg.domain.ItemMagico;
import com.unicesumar.igor.rpg.dto.ItemMagicoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ItemMagicoAdapter implements DtoAdapter<ItemMagico, ItemMagicoDTO> {

    @Override
    public ItemMagico toEntity(ItemMagicoDTO itemMagicoDTO) {
        return ItemMagico.builder()
                .id(itemMagicoDTO.getId())
                .nome(itemMagicoDTO.getNome())
                .tipoItem(itemMagicoDTO.getTipoItem())
                .forca(itemMagicoDTO.getForca())
                .defesa(itemMagicoDTO.getDefesa())
                .build();
    }

    @Override
    public ItemMagicoDTO toDto(ItemMagico entity) {
        return ItemMagicoDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .tipoItem(entity.getTipoItem())
                .forca(entity.getForca())
                .defesa(entity.getDefesa())
                .build();
    }
}
