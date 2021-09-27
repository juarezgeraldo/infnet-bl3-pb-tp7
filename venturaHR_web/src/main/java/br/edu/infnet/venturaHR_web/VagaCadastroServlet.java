package br.edu.infnet.venturaHR_web;

import br.edu.infnet.venturaHR_web.model.domain.CriteriosVaga;
import br.edu.infnet.venturaHR_web.model.domain.Empresa;
import br.edu.infnet.venturaHR_web.model.domain.Usuario;
import br.edu.infnet.venturaHR_web.model.domain.Vaga;
import br.edu.infnet.venturaHR_web.model.domain.enumerations.FormaContratacao;
import br.edu.infnet.venturaHR_web.model.domain.enumerations.PMD;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroCadastroException;
import br.edu.infnet.venturaHR_web.model.service.VagaCadastroService;
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
import java.util.Map;

@WebServlet(name = "VagaCadastroServlet", value = "/vaga-inclui")
public class VagaCadastroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Vaga vaga = montaVaga(req);
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

    private Vaga montaVaga(HttpServletRequest req) {
        Vaga vaga = new Vaga();
        vaga.setTitulo(req.getParameter("titulo"));
        vaga.setDescricao(req.getParameter("descricao"));
        vaga.setBairro(req.getParameter("bairro"));
        vaga.setCidade(req.getParameter("cidade"));
        vaga.setEstado(req.getParameter("estado"));

        vaga.setFormaContratacao(FormaContratacao.valueOf(req.getParameter("formaContratacao")));

        Usuario usuario = (Usuario) req.getSession().getAttribute("user");
        Empresa empresa = new Empresa();
        empresa.setId(usuario.getId());
        vaga.setUsuarioEmpresa(empresa);

        List<CriteriosVaga> criteriosVagaList = new ArrayList<>();

        Map<String, String[]> parameters = req.getParameterMap();

        String[] descricoes = null;
        String[] pmds = null;
        String[] pesos = null;

        for (Map.Entry<String, String[]> criterio : parameters.entrySet()) {
            if (criterio.getKey().contains("criteriosVaga.descricao")) {
                descricoes = criterio.getValue();
            } else if (criterio.getKey().contains("criteriosVaga.pmd")) {
                pmds = criterio.getValue();
            } else if (criterio.getKey().contains("criteriosVaga.peso")) {
                pesos = criterio.getValue();
            }
        }

        if (descricoes != null && pmds != null && pesos != null) {
            for (int i = 0; i < descricoes.length; i++) {
                CriteriosVaga novoCriterio = new CriteriosVaga();
                novoCriterio.setDescricao(descricoes[i]);
                novoCriterio.setPmd(PMD.valueOf(pmds[i]));
                novoCriterio.setPeso(Integer.parseInt(pesos[i]));
                criteriosVagaList.add(novoCriterio);
            }
        }
        vaga.setCriteriosVagaList(criteriosVagaList);
        return vaga;
    }

    public void destroy() {
    }
}