package com.unicesumar.igor.rpg.repository;

import com.unicesumar.igor.rpg.domain.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}
