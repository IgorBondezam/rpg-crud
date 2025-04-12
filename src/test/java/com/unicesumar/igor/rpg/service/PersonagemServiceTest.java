package com.unicesumar.igor.rpg.service;

import com.unicesumar.igor.rpg.domain.Personagem;
import com.unicesumar.igor.rpg.domain.enums.Classe;
import com.unicesumar.igor.rpg.repository.PersonagemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.InvalidParameterException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonagemServiceTest {

    @InjectMocks
    private PersonagemService service;

    @Mock
    private PersonagemRepository repository;

    @Mock
    private ItemMagicoService itemMagicoService;

    @Test
    public void deveRetornarUmErroCasoNaoEncontreOPersonagemPeloId() {
        when(repository.findById(any())).thenReturn(Optional.empty());

        String message = assertThrows(InvalidParameterException.class, () -> service.findById(1L)).getMessage();
        assertEquals("Personagem não encontrado para o Id solicitado", message);
    }

    @Test
    public void deveRetornarUmErroCasoSalvarPersonagemComAtributosSomadosAcimaDe10Pontos() {
        Personagem personagem = personagemFixture(1L);
        personagem.setForca(9);
        personagem.setDefesa(6);

        String message = assertThrows(InvalidParameterException.class, () -> service.save(personagem)).getMessage();
        assertEquals("A quantidade máxima de pontos foi ultrapassada", message);
    }

    @Test
    public void deveRetornarUmErroCasoSalvarPersonagemComForcaAcimaDe10Pontos() {
        Personagem personagem = personagemFixture(1L);
        personagem.setForca(13);
        personagem.setDefesa(0);

        String message = assertThrows(InvalidParameterException.class, () -> service.save(personagem)).getMessage();
        assertEquals("A quantidade máxima de pontos foi ultrapassada", message);
    }

    @Test
    public void deveRetornarUmErroCasoSalvarPersonagemComDefesaAcimaDe10Pontos() {
        Personagem personagem = personagemFixture(1L);
        personagem.setForca(0);
        personagem.setDefesa(13);

        String message = assertThrows(InvalidParameterException.class, () -> service.save(personagem)).getMessage();
        assertEquals("A quantidade máxima de pontos foi ultrapassada", message);
    }

    @Test
    public void deveSalvarPersonagem() {
        Personagem personagem = personagemFixture(1L);
        personagem.setForca(4);
        personagem.setDefesa(5);

        service.save(personagem);
        verify(repository, times(1)).save(any());
    }

    private Personagem personagemFixture(Long id) {
        return Personagem.builder()
                .id(id)
                .nome("Teste")
                .nomeAventureiro("TesteAventureiro")
                .forca(5)
                .defesa(4)
                .level(1)
                .classe(Classe.ARQUEIRO)
                .build();
    }

}
