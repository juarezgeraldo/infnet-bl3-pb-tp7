package br.edu.infnet.venturaHR_usuarios.model.service;

import br.edu.infnet.venturaHR_usuarios.model.domain.Empresa;
import br.edu.infnet.venturaHR_usuarios.model.domain.enumerations.StatusUsuario;
import br.edu.infnet.venturaHR_usuarios.model.domain.enumerations.TipoConta;
import br.edu.infnet.venturaHR_usuarios.model.exception.CpfCnpjJaExiste;
import br.edu.infnet.venturaHR_usuarios.model.exception.UsuarioNaoExiste;
import br.edu.infnet.venturaHR_usuarios.model.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa incluir(Empresa empresa){
        usuarioService.validarUsuario(empresa);
        validaCnpj(empresa.getCnpj());
        empresa.setTipoConta(TipoConta.EMPRESA);
        empresa.setStatusUsuario(StatusUsuario.DESATIVADO);
        return empresaRepository.save(empresa);
    }

    private void validaCnpj(String cnpj){
        if (empresaRepository.existsByCnpj(cnpj)){
            throw new CpfCnpjJaExiste("Já existe uma empresa com o CNPJ informado: " + cnpj);
        }
    }

    public List<Empresa> obterLista() {
        return (List<Empresa>) empresaRepository.findAll();
    }

    public Empresa findById(Long id){
        return empresaRepository.findById(id).orElseThrow(() -> new UsuarioNaoExiste("Não existe uma empresa com o ID informado: " + id));
    }
    public Empresa findByCnpj(String cnpj){
        return empresaRepository.findByCnpj(cnpj).orElseThrow(() -> new UsuarioNaoExiste("Não existe uma empresa com o CNPJ informado: " + cnpj));
    }
}
