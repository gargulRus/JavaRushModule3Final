<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p>
    ИД сессии - <%= session.getId() %>
</p>
<p>
    Имя Мужика - <c:out value="${sessionScope.name}"/>
</p>
<p>
    Кол-во сыгранных игр - <c:out value="${sessionScope.gameCount}"/>
</p>