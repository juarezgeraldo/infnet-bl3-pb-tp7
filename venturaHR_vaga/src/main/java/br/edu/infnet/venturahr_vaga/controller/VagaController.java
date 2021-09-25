package br.edu.infnet.venturahr_vaga.controller;

import br.edu.infnet.venturahr_vaga.model.domain.Empresa;
import br.edu.infnet.venturahr_vaga.model.domain.Vaga;
import br.edu.infnet.venturahr_vaga.model.exception.StatusInvalidoException;
import br.edu.infnet.venturahr_vaga.model.exception.VagaNaoEncontradaException;
import br.edu.infnet.venturahr_vaga.model.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @PostMapping
    public Vaga cadastrar(@RequestBody Vaga vaga) {
        try {
            return vagaService.incluir(vaga);
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Vaga findById(@PathVariable Long id) {
        try {
            return vagaService.findById(id);
        }
        catch(VagaNaoEncontradaException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/tudo")
    public List<Vaga> listar(String titulo, Empresa usuarioEmpresa, String statusVaga) {
        try {
            return vagaService.listar(titulo, usuarioEmpresa, statusVaga);
        }
        catch(StatusInvalidoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping
    public List<Vaga> listarTudo() {
        try {
            return vagaService.listarTudo();
        }
        catch(StatusInvalidoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

}
