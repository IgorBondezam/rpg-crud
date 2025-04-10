package com.unicesumar.igor.rpg.service;

import com.unicesumar.igor.rpg.domain.ItemMagico;
import com.unicesumar.igor.rpg.repository.ItemMagicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemMagicoService {

    private final ItemMagicoRepository repository;

    public List<ItemMagico> findAll() {
        return repository.findAll();
    }

    public ItemMagico findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item Mágico não encontrado para o Id solicitado"));
    }

    public ItemMagico save(ItemMagico itemMagico) {
        return repository.save(itemMagico);
    }

    public ItemMagico updateById(Long id, ItemMagico itemMagicoReq) {
        ItemMagico itemMagico = findById(id);

        itemMagico.setNome(itemMagicoReq.getNome());
        itemMagico.setTipoItem(itemMagicoReq.getTipoItem());
        itemMagico.setForça(itemMagicoReq.getForça());
        itemMagico.setDefesa(itemMagicoReq.getDefesa());

        return repository.save(itemMagico);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
