package ru.gabaraev.jrmodule3.core;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoggerServlet" , value = "/logger")
public class LoggerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession curSession = req.getSession();

        if (curSession.getAttribute("gameCount") == null) {
            curSession.setAttribute("gameCount", 0);
        }

        req.getServletContext().getRequestDispatcher("/logger.jsp").forward(req, resp);
    }
}
