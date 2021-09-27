package br.edu.infnet.venturaHR_web;

import br.edu.infnet.venturaHR_web.model.domain.Vaga;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroCadastroException;
import br.edu.infnet.venturaHR_web.model.service.VagaAlteraService;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "VagaAlteraServlet", value = "/vaga-altera")
public class VagaAlteraServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("lista");
        List<Vaga> vagaList = new ArrayList<Vaga>();
        vagaList = (List<Vaga>) req.getAttribute("lista");
        VagaAlteraService vagaAlteraService = new VagaAlteraService();

        try {
            Vaga vaga = vagaAlteraService.altera(Long.valueOf(id));
            req.setAttribute("mensagem_OK", "");
            req.setAttribute("vaga", vaga);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/vagas/cadastro.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ResponseStatusException | ErroCadastroException ex) {
            req.setAttribute("mensagem_NOK", ex.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/vagas/cadastro.jsp");
            requestDispatcher.forward(req, resp);
        }
    }


    public void destroy() {
    }
}