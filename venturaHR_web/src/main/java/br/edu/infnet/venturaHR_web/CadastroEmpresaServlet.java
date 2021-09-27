package br.edu.infnet.venturaHR_web;

import br.edu.infnet.venturaHR_web.model.domain.Empresa;
import br.edu.infnet.venturaHR_web.model.domain.enumerations.StatusUsuario;
import br.edu.infnet.venturaHR_web.model.domain.enumerations.TipoConta;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroCadastroException;
import br.edu.infnet.venturaHR_web.model.service.CadastroEmpresaService;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CadastroEmpresaServlet", value = "/cadastro-empresa")
public class CadastroEmpresaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Empresa empresa = criarEmpresaAPartirDaRequisicao(req);
        CadastroEmpresaService cadastroEmpresaService = new CadastroEmpresaService();

        try {
            cadastroEmpresaService.cadastro(empresa);
            req.setAttribute("mensagem_OK", "Usuário " + empresa.getNome() + " da Empresa " + empresa.getRazaoSocial() + " cadastrado com sucesso");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/index.jsp");
            requestDispatcher.forward(req, resp);
        }
        catch (ResponseStatusException | ErroCadastroException ex){
            req.setAttribute("mensagem_NOK", ex.getMessage());
            req.setAttribute("usuario", empresa);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/empresa/cadastro.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    private Empresa criarEmpresaAPartirDaRequisicao(HttpServletRequest req) {
        Empresa empresa = new Empresa();
        empresa.setCnpj(req.getParameter("cnpj"));
        empresa.setNome(req.getParameter("nome"));
        empresa.setEmail(req.getParameter("email"));
        empresa.setSenha(req.getParameter("senha"));
        empresa.setRazaoSocial(req.getParameter("razaoSocial"));
        empresa.setStatusUsuario(StatusUsuario.ATIVO);
        empresa.setTipoConta(TipoConta.CANDIDATO);
        return empresa;
    }

    public void destroy() {
    }
}