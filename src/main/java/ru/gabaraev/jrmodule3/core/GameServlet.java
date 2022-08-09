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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DBActions db = DBActions.getInstance();
        DBState dbState = DBState.getInstance();
        DBStory dbStory = DBStory.getInstance();

        Integer progress = 0;

        ArrayList<Integer> arrayOfActions;

        Map<Integer, String> actions;

        String story;

        HttpSession curSession = req.getSession();

        System.out.println(req.getParameter("action"));

        if (req.getParameter("action") != null) {
            progress = Integer.parseInt(req.getParameter("action"));

            if (progress == 4 || progress == 7 ||progress == 8 || progress == 11 || progress == 13) {
                story = dbStory.getAction(progress);
                Boolean isEnd = true;
                System.out.println(progress);
                System.out.println(story);
                System.out.println(curSession.getAttribute("gameCount"));
                try {
                    Integer gameCount = (Integer) curSession.getAttribute("gameCount");
                    curSession.setAttribute("gameCount", gameCount + 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                req.setAttribute("story", story);
                req.setAttribute("isEnd", isEnd);
            } else {
                arrayOfActions = dbState.getState(progress);

                actions = new HashMap<>();

                story = dbStory.getAction(progress);

                for (Integer action : arrayOfActions) {
                    actions.put(action, db.getAction(action));
                }
                req.setAttribute("actions", actions);
                req.setAttribute("story", story);
            }

        } else {

            System.out.println(progress);
            arrayOfActions = dbState.getState(progress);

            actions = new HashMap<>();

            story = dbStory.getAction(progress);

            for (Integer action : arrayOfActions) {
                actions.put(action, db.getAction(action));
            }
            req.setAttribute("actions", actions);
            req.setAttribute("story", story);
        }

        req.getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);

    }
}
