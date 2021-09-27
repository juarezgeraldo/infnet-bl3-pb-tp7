package br.edu.infnet.venturaHR_web.model.service;

import br.edu.infnet.venturaHR_web.model.domain.Empresa;
import br.edu.infnet.venturaHR_web.model.domain.Erro;
import br.edu.infnet.venturaHR_web.model.domain.ErroValidacao;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroCadastroException;
import br.edu.infnet.venturaHR_web.model.utils.ValidaCpfCnpj;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CadastroEmpresaService {
    private final String URL = "http://localhost:8081/api"; //System.getProperty("URL_AUTENTICACAO");
    private final Client client = ClientBuilder.newClient();

    public void cadastro(Empresa empresa) throws ErroCadastroException {
        StringBuilder mensagem_NOK = new StringBuilder();
        if (empresa.getNome().length() <= 0) {
            mensagem_NOK.append("Cadastro da empresa não realizado. Nome do usuário da empresa está em branco");
        } else {
            if (empresa.getEmail().length() <= 0) {
                mensagem_NOK.append("Cadastro da empresa não realizado. E-mail está em branco");
            } else {
                if (empresa.getSenha().length() < 3) {
                    mensagem_NOK.append("Cadastro da empresa não realizado. Senha deve possuir pélo menos 3 caracteres");
                } else {
//                    if (!ValidaCpfCnpj.isCNPJ(empresa.getCnpj()) || empresa.getCnpj().length() <= 0) {
                        if (empresa.getCnpj().length() <= 0) {
                        mensagem_NOK.append("Cadastro da empresa não realizado. CNPJ inválido");
                    } else {
                        if (empresa.getRazaoSocial().length() <= 0) {
                            mensagem_NOK.append("Cadastro da empresa não realizado. ´Razão social está em branco");
                        }
                    }
                }
            }
        }
        if (mensagem_NOK.length() == 0) {
            Response response = client
                    .target(URL + "/empresa")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(empresa, MediaType.APPLICATION_JSON));

            if (response.getStatus() != 200) {
                Erro erro = response.readEntity(Erro.class);
                if (erro.getErrors() != null && !erro.getErrors().isEmpty()) {
                    for (ErroValidacao erroValidacao : erro.getErrors()) {
                        mensagem_NOK.append(" | ").append(erroValidacao.getDefaultMessage());
                    }
                } else {
                    if (response.getStatus() == 400) {
                        mensagem_NOK.append("Cadastro da empresa não realizado. Há duplicidade de CNPJ ou E-mail");
                    } else {
                        mensagem_NOK.append(erro.getMessage());
                    }
                }
                throw new ErroCadastroException(mensagem_NOK.toString());
            }
        } else {
            throw new ErroCadastroException(mensagem_NOK.toString());
        }
    }
}
