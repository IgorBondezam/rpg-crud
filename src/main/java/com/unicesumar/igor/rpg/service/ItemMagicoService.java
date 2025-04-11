package com.unicesumar.igor.rpg.service;

import com.unicesumar.igor.rpg.domain.ItemMagico;
import com.unicesumar.igor.rpg.domain.enums.TipoItem;
import com.unicesumar.igor.rpg.repository.ItemMagicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
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
                .orElseThrow(() -> new InvalidParameterException("Item Mágico não encontrado para o Id solicitado"));
    }

    public List<ItemMagico> findByPersonagemId(Long personagemId) {
        return repository.findItemMagicoByPersonagemId(personagemId);
    }

    public ItemMagico save(ItemMagico itemMagico) {
        if(TipoItem.ARMA.equals(itemMagico.getTipoItem())) {
            itemMagico.setDefesa(0);
        }
        if(TipoItem.ARMADURA.equals(itemMagico.getTipoItem())) {
            itemMagico.setForca(0);
        }
        if(itemMagico.getForca() + itemMagico.getDefesa() == 0) {
            throw new InvalidParameterException("A quantidade mínima de pontos não foi utilizada");
        }
        if(itemMagico.getForca() + itemMagico.getDefesa() > 10) {
            throw new InvalidParameterException("A quantidade máxima de pontos foi ultrapassada");
        }
        return repository.save(itemMagico);
    }

    public ItemMagico updateById(Long id, ItemMagico itemMagicoReq) {
        ItemMagico itemMagico = findById(id);

        itemMagico.setNome(itemMagicoReq.getNome());
        itemMagico.setTipoItem(itemMagicoReq.getTipoItem());
        itemMagico.setForca(itemMagicoReq.getForca());
        itemMagico.setDefesa(itemMagicoReq.getDefesa());

        return repository.save(itemMagico);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
