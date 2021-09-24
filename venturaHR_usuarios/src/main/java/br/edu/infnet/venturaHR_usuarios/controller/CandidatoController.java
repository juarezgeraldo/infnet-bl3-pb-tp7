package br.edu.infnet.venturaHR_usuarios.controller;

import br.edu.infnet.venturaHR_usuarios.model.domain.Candidato;
import br.edu.infnet.venturaHR_usuarios.model.exception.CpfCnpjJaExiste;
import br.edu.infnet.venturaHR_usuarios.model.exception.UsuarioJaExiste;
import br.edu.infnet.venturaHR_usuarios.model.exception.UsuarioNaoExiste;
import br.edu.infnet.venturaHR_usuarios.model.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/candidato")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @PostMapping
    public Candidato incluir(@Validated @RequestBody Candidato candidato) {
        try {
            return candidatoService.incluir(candidato);
        } catch (UsuarioJaExiste ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        } catch (CpfCnpjJaExiste ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping
    public List<Candidato> obterLista() {
        try {
            return candidatoService.obterLista();
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Candidato findById(@PathVariable Long id) {
        try {
            return candidatoService.findById(id);
        }
        catch(UsuarioNaoExiste ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/cpf/{cpf}")
    public Candidato findByCpf(@PathVariable String cpf) {
        try {
            return candidatoService.findByCpf(cpf);
        }
        catch(UsuarioNaoExiste ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

}
