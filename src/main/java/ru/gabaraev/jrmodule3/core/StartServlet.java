package ru.gabaraev.jrmodule3.core;

import ru.gabaraev.jrmodule3.dbemulate.DB;
import ru.gabaraev.jrmodule3.dbemulate.DBEmulate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InitServlet", value = "/start")
public class StartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DBEmulate db = DB.getInstance();
        HttpSession curSession = req.getSession();

        String name = req.getParameter("name");

        curSession.setAttribute("name", name);

        //System.out.println(curSession.getAttribute("name"));

        req.setAttribute("name", curSession.getAttribute("name"));

        req.getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);

    }
}
