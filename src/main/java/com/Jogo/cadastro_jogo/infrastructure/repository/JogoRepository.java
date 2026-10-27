package com.Jogo.cadastro_jogo.infrastructure.repository;

import com.Jogo.cadastro_jogo.infrastructure.entitys.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Integer> {

    List<Jogo> findByNomeContainingIgnoreCase(String nome);

    List<Jogo> findByGeneroContainingIgnoreCase(String genero);

    List<Jogo> findByPlataformaContainingIgnoreCase(String plataforma);

    List<Jogo> findByPrecoLessThanEqual(Double preco);
}