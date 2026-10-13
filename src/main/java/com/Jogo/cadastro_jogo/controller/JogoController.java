package com.Jogo.cadastro_jogo.controller;

import com.Jogo.cadastro_jogo.business.JogoService;
import com.Jogo.cadastro_jogo.infrastructure.entitys.Jogo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jogo")
@RequiredArgsConstructor
public class JogoController {

    private final JogoService jogoService;

    @PostMapping
    public ResponseEntity<Jogo> salvarJogo(@RequestBody Jogo jogo) {
        Jogo jogoSalvo = jogoService.salvarJogo(jogo);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Jogo>> listarJogos() {
        return ResponseEntity.ok(jogoService.listarJogos());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Jogo>> buscarJogosPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(jogoService.buscarJogosPorNome(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> buscarJogoPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(jogoService.buscarJogoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizarJogoPorId(@PathVariable Integer id,
                                                   @RequestBody Jogo jogo) {
        return ResponseEntity.ok(jogoService.atualizarJogoPorId(id, jogo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarJogoPorId(@PathVariable Integer id) {
        jogoService.deletarJogoPorId(id);
        return ResponseEntity.noContent().build();
    }
}
