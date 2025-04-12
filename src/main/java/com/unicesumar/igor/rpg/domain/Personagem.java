package com.unicesumar.igor.rpg.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.unicesumar.igor.rpg.domain.enums.Classe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String nomeAventureiro;
    @Enumerated(EnumType.STRING)
    private Classe classe;
    private Integer level;
    @Builder.Default
    private Integer forca = 0;
    @Builder.Default
    private Integer defesa = 0;

    @Builder.Default
    @OneToMany(mappedBy = "personagem")
    @JsonManagedReference
    private List<ItemMagico> itensMagicos = new ArrayList<>();

    @JsonIgnore
    public Integer getFullForca() {
        return forca + itensMagicos.stream().mapToInt(ItemMagico::getForca).sum();
    }

    @JsonIgnore
    public Integer getFullDefesa() {
        return defesa + itensMagicos.stream().mapToInt(ItemMagico::getDefesa).sum();
    }

    public void adicionarItem(ItemMagico itemMagico) {
        itemMagico.setPersonagem(this);
        this.itensMagicos.add(itemMagico);
    }

    public void removeItem(ItemMagico itemMagico) {
        itemMagico.setPersonagem(null);
        this.itensMagicos.remove(itemMagico);
    }
}
