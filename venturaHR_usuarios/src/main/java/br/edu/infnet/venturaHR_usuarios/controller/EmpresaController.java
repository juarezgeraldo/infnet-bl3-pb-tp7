package br.edu.infnet.venturaHR_usuarios.controller;

import br.edu.infnet.venturaHR_usuarios.model.domain.Empresa;
import br.edu.infnet.venturaHR_usuarios.model.exception.UsuarioJaExiste;
import br.edu.infnet.venturaHR_usuarios.model.exception.UsuarioNaoExiste;
import br.edu.infnet.venturaHR_usuarios.model.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public Empresa incluir(@Validated @RequestBody Empresa empresa) {
        try {
            return empresaService.incluir(empresa);
        } catch (UsuarioJaExiste ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping
    public List<Empresa> obterLista() {
        try {
            return empresaService.obterLista();
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Empresa findById(@PathVariable Long id) {
        try {
            return empresaService.findById(id);
        }
        catch(UsuarioNaoExiste ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/cnpj/{cnpj}")
    public Empresa findByCpf(@PathVariable String cnpj) {
        try {
            return empresaService.findByCnpj(cnpj);
        }
        catch(UsuarioNaoExiste ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

}
