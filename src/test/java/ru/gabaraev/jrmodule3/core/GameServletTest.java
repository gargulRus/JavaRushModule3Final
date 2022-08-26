package ru.gabaraev.jrmodule3.core;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import ru.gabaraev.jrmodule3.dbemulate.DBStory;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GameServletTest {
    public GameServlet gameServlet;
    public MockHttpServletRequest request;
    public MockHttpServletResponse response;
    public MockHttpSession session;

    public DBStory story;

    @BeforeAll
    public void setUp() throws ServletException {
        story = DBStory.getInstance();
        session = new MockHttpSession();
        gameServlet = new GameServlet();
        gameServlet.init();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        request.setSession(session);
    }

    static Stream<String> argsForTestSessionParameterWhenGameIsEnd() {
        return Stream.of("4", "7", "8", "11", "13");
    }

    static Stream<String> argsForTestSessionParameterWhenGameInProgress() {
        return Stream.of("1", "2", "3", "5", "6", "9", "10", "12");
    }

    @ParameterizedTest
    @MethodSource("argsForTestSessionParameterWhenGameIsEnd")
    public void testForCorrectSessionParameterGameCountAssigmentWhenGameIsEnd(String testArg) throws ServletException, IOException {
        session.setAttribute("gameCount", 1);
        request.setParameter("action", testArg);
        gameServlet.doPost(request, response);
        assertEquals(2, Objects.requireNonNull(request.getSession()).getAttribute("gameCount"));
    }

    @ParameterizedTest
    @MethodSource("argsForTestSessionParameterWhenGameInProgress")
    public void testForCorrectSessionParameterGameCountAssigmentWhenGameInProgress(String testArg) throws ServletException, IOException {
        session.setAttribute("gameCount", 1);
        request.setParameter("action", testArg);
        gameServlet.doPost(request, response);
        assertEquals(1, Objects.requireNonNull(request.getSession()).getAttribute("gameCount"));
    }

    @ParameterizedTest
    @MethodSource("argsForTestSessionParameterWhenGameIsEnd")
    public void testForCorrectAssigmentBooleanAttributeOfEndGame(String testArg) throws ServletException, IOException {
        session.setAttribute("gameCount", 1);
        request.setParameter("action", testArg);
        gameServlet.doPost(request, response);
        assertEquals(true, request.getAttribute("isEnd"));
    }

    @ParameterizedTest
    @MethodSource("argsForTestSessionParameterWhenGameIsEnd")
    public void testForCorrectStoryAssigmentWhenGameIsEnd(String testArg) throws ServletException, IOException {
        session.setAttribute("gameCount", 1);
        request.setParameter("action", testArg);
        gameServlet.doPost(request, response);
        assertEquals(story.getAction(Integer.parseInt(testArg)), request.getAttribute("story"));
    }

    @ParameterizedTest
    @MethodSource("argsForTestSessionParameterWhenGameInProgress")
    public void testForCorrectStoryWhenGameInProgress(String testArg) throws ServletException, IOException {
        session.setAttribute("gameCount", 1);
        request.setParameter("action", testArg);
        gameServlet.doPost(request, response);
        assertEquals(story.getAction(Integer.parseInt(testArg)), request.getAttribute("story"));
    }

    @ParameterizedTest
    @MethodSource("argsForTestSessionParameterWhenGameInProgress")
    public void testForActionsNotEmptyWhenGameInProgress(String testArg) throws ServletException, IOException {
        session.setAttribute("gameCount", 1);
        request.setParameter("action", testArg);
        gameServlet.doPost(request, response);
        assertFalse(request.getAttribute("actions").getClass().getTypeName().isEmpty());
    }
}
