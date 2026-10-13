package com.Jogo.cadastro_jogo.infrastructure.repository;

import com.Jogo.cadastro_jogo.infrastructure.entitys.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {
    List<Jogo> findByNomeContainingIgnoreCase(String nome);
}
