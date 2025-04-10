package com.unicesumar.igor.rpg.service;

import com.unicesumar.igor.rpg.domain.Personagem;
import com.unicesumar.igor.rpg.repository.PersonagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonagemService {

    private final PersonagemRepository repository;

    public List<Personagem> findAll() {
        return repository.findAll();
    }

    public Personagem findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado para o Id solicitado"));
    }

    public Personagem save(Personagem personagem) {
        return repository.save(personagem);
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

        return repository.save(personagem);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
