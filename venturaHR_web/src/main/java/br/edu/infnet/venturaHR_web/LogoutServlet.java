package br.edu.infnet.venturaHR_web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "logoutServlet", value = "/sair")
public class LogoutServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        req.getSession().invalidate();
        req.getSession().removeAttribute("user");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void destroy() {
    }
}