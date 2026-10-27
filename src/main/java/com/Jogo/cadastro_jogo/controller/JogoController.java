package com.Jogo.cadastro_jogo.controller;

import com.Jogo.cadastro_jogo.business.JogoService;
import com.Jogo.cadastro_jogo.infrastructure.entitys.Jogo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogo")
public class JogoController {

    private final JogoService service;

    public JogoController(JogoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jogo salvarJogo(@RequestBody Jogo jogo) {
        return service.salvarJogo(jogo);
    }

    @GetMapping
    public List<Jogo> listarOuFiltrar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) String plataforma,
            @RequestParam(required = false) Double preco
    ) {
        return service.buscarComFiltros(nome, genero, plataforma, preco);
    }

    @GetMapping("/{id}")
    public Jogo buscarJogoPorId(@PathVariable Integer id) {
        return service.buscarJogoPorId(id);
    }

    @PutMapping("/{id}")
    public Jogo atualizarJogoPorId(@PathVariable Integer id, @RequestBody Jogo jogo) {
        return service.atualizarJogoPorId(id, jogo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarJogoPorId(@PathVariable Integer id) {
        service.deletarJogoPorId(id);
    }
}