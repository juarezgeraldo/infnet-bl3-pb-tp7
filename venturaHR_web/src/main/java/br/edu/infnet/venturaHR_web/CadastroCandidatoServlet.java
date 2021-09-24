package br.edu.infnet.venturaHR_web;

import br.edu.infnet.venturaHR_web.model.domain.Candidato;
import br.edu.infnet.venturaHR_web.model.domain.enumerations.StatusUsuario;
import br.edu.infnet.venturaHR_web.model.domain.enumerations.TipoConta;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroCadastroException;
import br.edu.infnet.venturaHR_web.model.service.CadastroCandidatoService;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CadastroCandidatoServlet", value = "/cadastro-candidato")
public class CadastroCandidatoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Candidato candidato = criarCandidatoAPartirDaRequisicao(req);
        CadastroCandidatoService cadastroCandidatoService = new CadastroCandidatoService();

        try {
            cadastroCandidatoService.cadastro(candidato);
            req.setAttribute("mensagem_OK", "Candidato " + candidato.getNome() + " cadastrado com sucesso");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/index.jsp");
            requestDispatcher.forward(req, resp);
        }
        catch (ResponseStatusException | ErroCadastroException ex){
            req.setAttribute("mensagem_NOK", ex.getMessage());
            req.setAttribute("user", candidato);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/candidato/cadastro.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    private Candidato criarCandidatoAPartirDaRequisicao(HttpServletRequest req) {
        Candidato candidato = new Candidato();
        candidato.setCpf(req.getParameter("cpf"));
        candidato.setNome(req.getParameter("nome"));
        candidato.setEmail(req.getParameter("email"));
        candidato.setSenha(req.getParameter("senha"));
        candidato.setTelefone(req.getParameter("telefone"));
        candidato.setStatusUsuario(StatusUsuario.ATIVO);
        candidato.setTipoConta(TipoConta.CANDIDATO);
        return candidato;
    }

    public void destroy() {
    }
}