package com.Jogo.cadastro_jogo.business;

import com.Jogo.cadastro_jogo.infrastructure.entitys.Jogo;
import com.Jogo.cadastro_jogo.infrastructure.repository.JogoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class JogoService {

    private final JogoRepository repository;

    public JogoService(JogoRepository repository) {
        this.repository = repository;
    }

    public Jogo salvarJogo(Jogo jogo) {
        return repository.saveAndFlush(jogo);
    }

    public List<Jogo> buscarComFiltros(String nome, String genero, String plataforma, Double preco) {
        Jogo filtro = Jogo.builder()
                .nome(nome)
                .genero(genero)
                .plataforma(plataforma)
                .preco(preco)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        return repository.findAll(Example.of(filtro, matcher));
    }

    public Jogo buscarJogoPorId(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado")
        );
    }

    public Jogo atualizarJogoPorId(Integer id, Jogo jogo) {
        Jogo jogoExistente = buscarJogoPorId(id);

        if (jogo.getNome() != null) {
            jogoExistente.setNome(jogo.getNome());
        }
        if (jogo.getGenero() != null) {
            jogoExistente.setGenero(jogo.getGenero());
        }
        if (jogo.getPreco() != null) {
            jogoExistente.setPreco(jogo.getPreco());
        }
        if (jogo.getPlataforma() != null) {
            jogoExistente.setPlataforma(jogo.getPlataforma());
        }

        return repository.saveAndFlush(jogoExistente);
    }

    public void deletarJogoPorId(Integer id) {
        Jogo jogo = buscarJogoPorId(id);
        repository.delete(jogo);
    }
}