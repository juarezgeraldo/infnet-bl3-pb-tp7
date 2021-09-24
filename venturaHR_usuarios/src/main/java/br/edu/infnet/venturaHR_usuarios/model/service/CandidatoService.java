package br.edu.infnet.venturaHR_usuarios.model.service;

import br.edu.infnet.venturaHR_usuarios.model.domain.Candidato;
import br.edu.infnet.venturaHR_usuarios.model.domain.enumerations.StatusUsuario;
import br.edu.infnet.venturaHR_usuarios.model.domain.enumerations.TipoConta;
import br.edu.infnet.venturaHR_usuarios.model.exception.CpfCnpjJaExiste;
import br.edu.infnet.venturaHR_usuarios.model.exception.UsuarioJaExiste;
import br.edu.infnet.venturaHR_usuarios.model.exception.UsuarioNaoExiste;
import br.edu.infnet.venturaHR_usuarios.model.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CandidatoRepository candidatoRepository;

    public Candidato incluir(Candidato candidato){
        usuarioService.validarUsuario(candidato);
        validaCpf(candidato.getCpf());
        candidato.setTipoConta(TipoConta.CANDIDATO);
        candidato.setStatusUsuario(StatusUsuario.ATIVO);
        return candidatoRepository.save(candidato);
    }

    private void validaCpf(String cpf){
        if (candidatoRepository.existsByCpf(cpf)){
            throw new CpfCnpjJaExiste("Já existe um candidato com o CPF informado: " + cpf);
        }
    }

    public List<Candidato> obterLista() {
        return (List<Candidato>) candidatoRepository.findAll();
    }

    public Candidato findById(Long id){
        return candidatoRepository.findById(id).orElseThrow(() -> new UsuarioNaoExiste("Não existe um candidato com o ID informado: " + id));
    }
    public Candidato findByCpf(String cpf){
        return candidatoRepository.findByCpf(cpf).orElseThrow(() -> new UsuarioNaoExiste("Não existe um candidato com o CPF informado: " + cpf));
    }
}
