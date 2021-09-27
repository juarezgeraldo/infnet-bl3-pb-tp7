package br.edu.infnet.venturaHR_web.model.service;

import br.edu.infnet.venturaHR_web.model.domain.Candidato;
import br.edu.infnet.venturaHR_web.model.domain.Erro;
import br.edu.infnet.venturaHR_web.model.domain.ErroValidacao;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroCadastroException;
import br.edu.infnet.venturaHR_web.model.utils.ValidaCpfCnpj;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CadastroCandidatoService {
    private final String URL = "http://localhost:8081/api"; //System.getProperty("URL_AUTENTICACAO");
    private final Client client = ClientBuilder.newClient();

    public void cadastro(Candidato candidato) throws ErroCadastroException {
        StringBuilder mensagem_NOK = new StringBuilder();
        if (candidato.getNome().length() <= 0) {
            mensagem_NOK.append("Cadastro do candidato não realizado. Nome do candidato está em branco");
        } else {
            if (candidato.getEmail().length() <= 0) {
                mensagem_NOK.append("Cadastro do candidato não realizado. E-mail está em branco");
            } else {
                if (candidato.getSenha().length() < 3) {
                    mensagem_NOK.append("Cadastro do candidato não realizado. Senha deve possuir pélo menos 3 caracteres");
                } else {
//                    if (!ValidaCpfCnpj.isCPF(candidato.getCpf()) || candidato.getCpf().length() <= 0) {
                        if (candidato.getCpf().length() <= 0) {
                        mensagem_NOK.append("Cadastro do candidato não realizado. CPF inválido");
                    } else {
                        if (candidato.getTelefone().length() <= 0) {
                            mensagem_NOK.append("Cadastro do candidato não realizado. ´Falta informação de telefone");
                        }
                    }
                }
            }
        }

        if (mensagem_NOK.length() == 0) {
            Response response = client
                    .target(URL + "/candidato")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(candidato, MediaType.APPLICATION_JSON));

            if (response.getStatus() != 200) {
                Erro erro = response.readEntity(Erro.class);
                if (erro.getErrors() != null && !erro.getErrors().isEmpty()) {
                    for (ErroValidacao erroValidacao : erro.getErrors()) {
                        mensagem_NOK.append(" | ").append(erroValidacao.getDefaultMessage());
                    }
                } else {
                    if (response.getStatus() == 400) {
                        mensagem_NOK.append("Cadastro do candidato não realizado. Há duplicidade de CPF ou E-mail");
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
