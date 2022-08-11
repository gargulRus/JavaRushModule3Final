package ru.gabaraev.jrmodule3.core;

import ru.gabaraev.jrmodule3.dbemulate.DBActions;
import ru.gabaraev.jrmodule3.dbemulate.DBState;
import ru.gabaraev.jrmodule3.dbemulate.DBStory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "StartServlet", value = "/start")
public class StartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //получаем экземпляры классов, которые эмулируют разные таблицы с БД
        //Хранит варианты действий
        DBActions db = DBActions.getInstance();
        //Хранит в себе логику шагов
        DBState dbState = DBState.getInstance();
        //Хранит в себе текстовую часть
        DBStory dbStory = DBStory.getInstance();

        HttpSession curSession = req.getSession();

        String name = req.getParameter("name");

        curSession.setAttribute("name", name);

        req.setAttribute("name", curSession.getAttribute("name"));
        req.getServletContext().getRequestDispatcher("/start.jsp").forward(req, resp);

    }
}
