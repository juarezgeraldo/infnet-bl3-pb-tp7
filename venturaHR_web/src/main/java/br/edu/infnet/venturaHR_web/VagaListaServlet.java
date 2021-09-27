package br.edu.infnet.venturaHR_web;

import br.edu.infnet.venturaHR_web.model.domain.Vaga;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroAutenticacaoException;
import br.edu.infnet.venturaHR_web.model.service.VagaListaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "VagaListaServlet", value = "/vaga-lista")
public class VagaListaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            VagaListaService vagaListaService = new VagaListaService();

            List<Vaga> vagas = vagaListaService.buscarVagas();
            req.setAttribute("lista", vagas);
            req.setAttribute("idMensagem", "");
            req.setAttribute("mensagem", "");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/vagas/lista.jsp");
            requestDispatcher.forward(req, resp);
        }
        catch (ErroAutenticacaoException exception) {
            req.setAttribute("mensagem", exception.getMessage());
            req.setAttribute("idMensagem", "erro");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
            requestDispatcher.forward(req, resp);
        }

    }

    public void destroy() {
    }
}