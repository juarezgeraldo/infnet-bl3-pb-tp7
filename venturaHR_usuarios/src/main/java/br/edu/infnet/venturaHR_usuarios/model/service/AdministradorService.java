package br.edu.infnet.venturaHR_usuarios.model.service;

import br.edu.infnet.venturaHR_usuarios.model.domain.Administrador;
import br.edu.infnet.venturaHR_usuarios.model.domain.enumerations.StatusUsuario;
import br.edu.infnet.venturaHR_usuarios.model.domain.enumerations.TipoConta;
import br.edu.infnet.venturaHR_usuarios.model.exception.CpfCnpjJaExiste;
import br.edu.infnet.venturaHR_usuarios.model.exception.UsuarioNaoExiste;
import br.edu.infnet.venturaHR_usuarios.model.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private AdministradorRepository administradorRepository;

    public Administrador incluir(Administrador administrador){
        usuarioService.validarUsuario(administrador);
        validaCpf(administrador.getCpf());
        administrador.setTipoConta(TipoConta.ADMIN);
        administrador.setStatusUsuario(StatusUsuario.ATIVO);
        return administradorRepository.save(administrador);
    }

    private void validaCpf(String cpf){
        if (administradorRepository.existsByCpf(cpf)){
            throw new CpfCnpjJaExiste("Já existe um administrador com o CPF informado: " + cpf);
        }
    }

    public List<Administrador> obterLista() {
        return (List<Administrador>) administradorRepository.findAll();
    }

    public Administrador findById(Long id){
        return administradorRepository.findById(id).orElseThrow(() -> new UsuarioNaoExiste("Não existe um administrador com o ID informado: " + id));
    }
    public Administrador findByCpf(String cpf){
        return administradorRepository.findByCpf(cpf).orElseThrow(() -> new UsuarioNaoExiste("Não existe um administrador com o CPF informado: " + cpf));
    }
}
