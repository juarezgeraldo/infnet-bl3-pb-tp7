package br.edu.infnet.venturaHR_web.model.service;

import br.edu.infnet.venturaHR_web.model.domain.Erro;
import br.edu.infnet.venturaHR_web.model.domain.ErroValidacao;
import br.edu.infnet.venturaHR_web.model.domain.Vaga;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroCadastroException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class VagaAlteraService {
    private final String URL = "http://localhost:8083/api/vagas/"; //System.getProperty("URL_AUTENTICACAO");
    private final Client client = ClientBuilder.newClient();

    public Vaga altera(Long id) throws ErroCadastroException {
        String mensagem = null;
            Response response = client
                    .target(URL)
                    .queryParam("id", id)
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(id, MediaType.APPLICATION_JSON));

            if (response.getStatus() != 200) {
                Erro erro = response.readEntity(Erro.class);
                if (erro.getErrors() != null && !erro.getErrors().isEmpty()) {
                    for (ErroValidacao erroValidacao : erro.getErrors()) {
                        mensagem = "Erro: " + erroValidacao.getDefaultMessage();
                    }
                } else {
                    if (response.getStatus() == 400) {
                        mensagem = "Erro: " + "Cadastro do vaga não realizado. Há duplicidade de CPF ou E-mail";
                    } else {
                        mensagem = "Erro: " + erro.getMessage();
                    }
                }
                throw new ErroCadastroException(mensagem);
            }else{
                return response.readEntity(Vaga.class);
            }
    }

}
