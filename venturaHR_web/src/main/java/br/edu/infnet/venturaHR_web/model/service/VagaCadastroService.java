package br.edu.infnet.venturaHR_web.model.service;

import br.edu.infnet.venturaHR_web.model.domain.Erro;
import br.edu.infnet.venturaHR_web.model.domain.ErroValidacao;
import br.edu.infnet.venturaHR_web.model.domain.Vaga;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroBuscaVagasException;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroCadastroException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class VagaCadastroService {
    private final String URL = "http://localhost:8083/api/vagas"; //System.getProperty("URL_AUTENTICACAO");
    private final Client client = ClientBuilder.newClient();

    public void cadastro(Vaga vaga) throws ErroCadastroException {
        StringBuilder mensagem = new StringBuilder();
        if (vaga.getTitulo().length() <= 0) {
            mensagem.append("Cadastro da vaga não realizado. Titulo da vaga está em branco");
        } else {
            if (vaga.getDescricao().length() <= 0) {
                mensagem.append("Cadastro da vaga não realizado. Descrição está em branco");
            }
//            else {
//                if (vaga.getFormaContratacao().getValor().length() < 3) {
//                    mensagem.append("Cadastro da vaga não realizado. Senha deve possuir pélo menos 3 caracteres");
//                } else {
//                    if (!ValidaCpfCnpj.isCPF(vaga.getCpf()) || vaga.getCpf().length() <= 0) {
//                        mensagem.append("Cadastro da vaga não realizado. CPF inválido");
//                    } else {
//                        if (vaga.getTelefone().length() <= 0) {
//                            mensagem.append("Cadastro da vaga não realizado. ´Falta informação de telefone");
//                        }
//                    }
//                }
//            }
        }

        if (mensagem.length() == 0) {
            Response response = client
                    .target(URL)
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(vaga, MediaType.APPLICATION_JSON));

            if (response.getStatus() != 200) {
                Erro erro = response.readEntity(Erro.class);
                if (erro.getErrors() != null && !erro.getErrors().isEmpty()) {
                    for (ErroValidacao erroValidacao : erro.getErrors()) {
                        mensagem.append(" | ").append(erroValidacao.getDefaultMessage());
                    }
                } else {
                    if (response.getStatus() == 400) {
                        mensagem.append("Cadastro do vaga não realizado. Há duplicidade de CPF ou E-mail");
                    } else {
                        mensagem.append(erro.getMessage());
                    }
                }
                throw new ErroCadastroException(mensagem.toString());
            }
        } else {
            throw new ErroCadastroException(mensagem.toString());
        }
    }

    public List<Vaga> buscarVagasTudo() throws ErroBuscaVagasException {
        Response response = client
                .target(URL + "/tudo")
                .request().get();

        StringBuilder mensagem = new StringBuilder();

        if (response.getStatus() == 200) {
            return response.readEntity(new GenericType<List<Vaga>>() {});
        }
        else {
            Erro erro = response.readEntity(Erro.class);

            mensagem.append(erro.getMessage()) ;
            throw new ErroBuscaVagasException(mensagem.toString());
        }
    }

}
