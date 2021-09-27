package br.edu.infnet.venturaHR_web;

import br.edu.infnet.venturaHR_web.model.domain.Usuario;
import br.edu.infnet.venturaHR_web.model.exceptions.ErroAutenticacaoException;
import br.edu.infnet.venturaHR_web.model.service.LoginService;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse resp, HttpSession session, SessionStatus status) throws IOException, ServletException {
        status.setComplete();
        session.removeAttribute("user");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void destroy() {
    }
}