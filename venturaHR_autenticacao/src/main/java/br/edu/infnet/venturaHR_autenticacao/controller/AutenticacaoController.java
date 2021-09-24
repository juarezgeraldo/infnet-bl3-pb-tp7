package br.edu.infnet.venturaHR_autenticacao.controller;

import br.edu.infnet.venturaHR_autenticacao.model.domain.Usuario;
import br.edu.infnet.venturaHR_autenticacao.model.exception.LoginInvalido;
import br.edu.infnet.venturaHR_autenticacao.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/login")
public class AutenticacaoController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario login(@RequestBody Usuario usuario) {
        try {
            return usuarioService.login(usuario);
        }
        catch(LoginInvalido ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
