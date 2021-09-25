package br.edu.infnet.venturaHR_web.model.service;

import br.edu.infnet.venturaHR_web.model.domain.Erro;
import br.edu.infnet.venturaHR_web.model.domain.ErroValidacao;
import br.edu.infnet.venturaHR_web.model.domain.Vaga;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroAutenticacaoException;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroBuscaVagasException;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroCadastroException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class VagaListaService {
    private final String URL = "http://localhost:8083/api/vagas"; //System.getProperty("URL_AUTENTICACAO");
    private final Client client = ClientBuilder.newClient();

    public List<Vaga> buscarVagas() throws ErroAutenticacaoException {
        Response response = client
                .target(URL)
                .request().get();

        if (response.getStatus() == 200) {
            return response.readEntity(new GenericType<List<Vaga>>() {

            });
        }
        else {
            throw new ErroAutenticacaoException("Usuário ou senha inválidos.");
        }
    }

}
