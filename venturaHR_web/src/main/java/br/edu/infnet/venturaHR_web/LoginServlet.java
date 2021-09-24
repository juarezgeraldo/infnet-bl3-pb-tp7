package br.edu.infnet.venturaHR_web;

import br.edu.infnet.venturaHR_web.model.domain.Usuario;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroAutenticacaoException;
import br.edu.infnet.venturaHR_web.model.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Usuario usuario;
        usuario = (Usuario) request.getAttribute("user");
        request.setAttribute("user", usuario);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/index.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        LoginService loginService = new LoginService();
        Usuario autenticar = new Usuario();
        autenticar.setEmail(email);
        autenticar.setSenha(senha);

        try {
            Usuario usuarioLogado = loginService.login(autenticar);

            req.setAttribute("user", usuarioLogado);
            req.setAttribute("usuarioLogado", true);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/index.jsp");
            requestDispatcher.forward(req, resp);
        }
        catch(ErroAutenticacaoException ex) {
            req.setAttribute("mensagem_NOK", ex.getMessage());
            req.setAttribute("usuarioLogado", false);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
            requestDispatcher.forward(req, resp);
        }
    }

    public void destroy() {
    }
}