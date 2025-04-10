package com.unicesumar.igor.rpg.repository;

import com.unicesumar.igor.rpg.domain.ItemMagico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMagicoRepository extends JpaRepository<ItemMagico, Long> {
}
