package br.edu.infnet.venturaHR_usuarios.controller;

import br.edu.infnet.venturaHR_usuarios.model.domain.Administrador;
import br.edu.infnet.venturaHR_usuarios.model.exception.UsuarioJaExiste;
import br.edu.infnet.venturaHR_usuarios.model.exception.UsuarioNaoExiste;
import br.edu.infnet.venturaHR_usuarios.model.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @PostMapping
    public Administrador incluir(@Validated @RequestBody Administrador administrador) {
        try {
            return administradorService.incluir(administrador);
        } catch (UsuarioJaExiste ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping
    public List<Administrador> obterLista() {
        try {
            return administradorService.obterLista();
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Administrador findById(@PathVariable Long id) {
        try {
            return administradorService.findById(id);
        }
        catch(UsuarioNaoExiste ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/cpf/{cpf}")
    public Administrador findByCpf(@PathVariable String cpf) {
        try {
            return administradorService.findByCpf(cpf);
        }
        catch(UsuarioNaoExiste ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

}
