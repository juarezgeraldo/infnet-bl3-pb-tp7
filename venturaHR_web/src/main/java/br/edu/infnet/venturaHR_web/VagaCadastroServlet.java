package br.edu.infnet.venturaHR_web;

import br.edu.infnet.venturaHR_web.model.domain.CriteriosVaga;
import br.edu.infnet.venturaHR_web.model.domain.Vaga;
import br.edu.infnet.venturaHR_web.model.domain.enumerations.FormaContratacao;
import br.edu.infnet.venturaHR_web.model.domain.enumerations.PMD;
import br.edu.infnet.venturaHR_web.model.domain.enumerations.StatusVaga;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroBuscaVagasException;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroCadastroException;
import br.edu.infnet.venturaHR_web.model.service.VagaCadastroService;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "VagaCadastroServlet", value = "/vaga-cadastro")
public class VagaCadastroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Vaga vaga = criarVagaAPartirDaRequisicao(req);
        VagaCadastroService vagaCadastroService = new VagaCadastroService();

        try {
            vagaCadastroService.cadastro(vaga);
            req.setAttribute("mensagem_OK", "Vaga " + vaga.getTitulo() + " cadastrado com sucesso");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/index.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ResponseStatusException | ErroCadastroException ex) {
            req.setAttribute("mensagem_NOK", ex.getMessage());
            req.setAttribute("user", vaga);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/vagas/cadastro.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {

        req.setAttribute("user", req.getAttribute("user"));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/vagas/cadastro.jsp");
        requestDispatcher.forward(req, resp);
    }

    private Vaga criarVagaAPartirDaRequisicao(HttpServletRequest req) {
        Vaga vaga = new Vaga();
//        Empresa empresa = new Empresa();
        vaga.setDataInicio(LocalDate.parse(req.getParameter("dataInicio")));
        vaga.setDataFinal(LocalDate.parse(req.getParameter("dataFinal")));
//        vaga.setUsuarioEmpresa(req.getParameter("usuarioEmpresa"));
        vaga.setTitulo(req.getParameter("titulo"));
        vaga.setDescricao(req.getParameter("descricao"));
        vaga.setFormaContratacao(FormaContratacao.CLT);
//        vaga.setFormaContratacao(FormaContratacao.forValue(req.getParameter("formaContratacao")));
        vaga.setBairro(req.getParameter("bairro"));
        vaga.setCidade(req.getParameter("cidade"));
        vaga.setEstado(req.getParameter("estado"));
        vaga.setStatusVaga(StatusVaga.ABERTA);
        CriteriosVaga criteriosVaga = new CriteriosVaga();
        List<CriteriosVaga> criteriosVagaList = new ArrayList<>();
//        criteriosVaga.setVaga(vaga);
        criteriosVaga.setDescricao("descricao criterio");
        criteriosVaga.setPeso(3);
        criteriosVaga.setPmd(PMD.DESEJAVEL);
        criteriosVagaList.add(criteriosVaga);
        vaga.setCriteriosVagaList(criteriosVagaList);
        return vaga;
    }

    public void destroy() {
    }
}