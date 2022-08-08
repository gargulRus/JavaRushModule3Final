<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8"%>
<%@ page import="ru.gabaraev.jrmodule3.helpers.Helper" %>

<h1><% request.getAttribute("name"); %>  - 1</h1>
<h1><% session.getAttribute("name2"); %>  - 2 </h1>
<h1><%= request.getAttribute("name") %></h1>

