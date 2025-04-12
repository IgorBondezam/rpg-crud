package com.unicesumar.igor.rpg.service;

import com.unicesumar.igor.rpg.domain.ItemMagico;
import com.unicesumar.igor.rpg.domain.Personagem;
import com.unicesumar.igor.rpg.domain.enums.TipoItem;
import com.unicesumar.igor.rpg.repository.ItemMagicoRepository;
import com.unicesumar.igor.rpg.repository.PersonagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class PersonagemService {

    private final PersonagemRepository repository;
    private final ItemMagicoService itemMagicoService;

    public List<Personagem> findAll() {
        return repository.findAll();
    }

    public Personagem findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new InvalidParameterException("Personagem não encontrado para o Id solicitado"));
    }

    public Personagem save(Personagem personagem) {
        if(personagem.getForca() + personagem.getDefesa() > 10) {
            throw new InvalidParameterException("A quantidade máxima de pontos foi ultrapassada");
        }
        return repository.save(personagem);
    }

    public void adicionarItemMagico(Long id, Long itemMagicoId) {
        Personagem personagem = findById(id);
        ItemMagico itemMagico = itemMagicoService.findById(itemMagicoId);
        if(Objects.nonNull(itemMagico.getPersonagem())) {
            throw new InvalidParameterException("O Item Mágico já está vinculádo em um personagem");
        }
        if(TipoItem.AMULETO.equals(itemMagico.getTipoItem()) &&
                personagem.getItensMagicos().stream()
                        .anyMatch(i -> TipoItem.AMULETO.equals(i.getTipoItem()))) {
            throw new InvalidParameterException("O personagem já possui um AMULETO cadastrado");
        }
        personagem.adicionarItem(itemMagico);
        save(personagem);
    }

    public void removerItemMagico(Long id, Long itemMagicoId) {
        Personagem personagem = findById(id);
        ItemMagico itemMagico = personagem.getItensMagicos().stream().filter(i -> itemMagicoId.equals(i.getId()))
                .findFirst().orElseThrow(() ->  new InvalidParameterException("O personagem não possui o Item Mágico mencionado"));

        personagem.removeItem(itemMagico);
        save(personagem);
    }

    public Personagem updateNomeAventureiroId(Long id, String nomeAventureiro) {
        Personagem personagem = findById(id);
        personagem.setNomeAventureiro(nomeAventureiro);
        return save(personagem);
    }

    public Personagem updateById(Long id, Personagem personagemReq) {
        Personagem personagem = findById(id);

        personagem.setNome(personagemReq.getNome());
        personagem.setNomeAventureiro(personagemReq.getNomeAventureiro());
        personagem.setClasse(personagemReq.getClasse());
        personagem.setLevel(personagemReq.getLevel());
        personagem.setForca(personagemReq.getForca());
        personagem.setDefesa(personagemReq.getDefesa());

        personagem.getItensMagicos().clear();
        personagem.getItensMagicos().addAll(personagemReq.getItensMagicos());

        return save(personagem);
    }

    public void deleteById(Long id) {
        Personagem personagem = findById(id);
        personagem.getItensMagicos().forEach(i -> i.setPersonagem(null));
        repository.delete(personagem);
    }
}
