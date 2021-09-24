package br.edu.infnet.venturaHR_web.model.service;
import br.edu.infnet.venturaHR_web.model.domain.Usuario;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroAutenticacaoException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class LoginService {
    private final String URL = "http://localhost:8082/api/login"; //System.getProperty("URL_AUTENTICACAO");
    private final Client client = ClientBuilder.newClient();

    public Usuario login(Usuario usuario) throws ErroAutenticacaoException {
            Response response = client
                    .target(URL)
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(usuario, MediaType.APPLICATION_JSON));

            if (response.getStatus() == 200) {
                return response.readEntity(Usuario.class);
            }
            throw new ErroAutenticacaoException("Usuário ou senha inválidos.");
    }
}
