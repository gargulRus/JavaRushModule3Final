package ru.gabaraev.jrmodule3.core;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoggerServletTest {
    public LoggerServlet loggerServlet;
    public MockHttpServletRequest request;
    public MockHttpServletResponse response;

    @Before
    public void setUp() throws ServletException {
        loggerServlet = new LoggerServlet();
        loggerServlet.init();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void testForCorrectSessionParameterGameCountAssigment() throws ServletException, IOException {
        loggerServlet.doPost(request, response);
        assertEquals(0, Objects.requireNonNull(request.getSession()).getAttribute("gameCount"));
    }
}
