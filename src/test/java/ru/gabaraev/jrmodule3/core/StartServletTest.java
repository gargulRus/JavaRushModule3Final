package ru.gabaraev.jrmodule3.core;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import ru.gabaraev.jrmodule3.dbemulate.DBActions;
import ru.gabaraev.jrmodule3.dbemulate.DBState;
import ru.gabaraev.jrmodule3.dbemulate.DBStory;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StartServletTest {

    public StartServlet startServlet;
    public MockHttpServletRequest request;
    public MockHttpServletResponse response;
    public MockHttpSession session;

    @BeforeAll
    public void setUp() throws ServletException {
        session = new MockHttpSession();
        startServlet = new StartServlet();
        startServlet.init();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        request.setSession(session);
    }

    @Test
    void testSetCorrectAttributeNameToSession() throws ServletException, IOException {
        request.setParameter("name", "NameChar");
        startServlet.doPost(request, response);
        assertEquals("NameChar", session.getAttribute("name"));
    }

    @Test
    void testCorrectInitializationDBEmulate() throws ServletException, IOException {
        startServlet.doPost(request, response);
        assertNotNull(DBStory.getDb());
        assertNotNull(DBActions.getDb());
        assertNotNull(DBState.getDb());
    }
}