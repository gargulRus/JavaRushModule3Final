<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8"%>
<%@ page import="ru.gabaraev.jrmodule3.helpers.Helper" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Helper helper = new Helper(); %>
<!DOCTYPE html>
<html lang=ru>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0" />
    <meta charset="utf-8" />
    <meta name="description" content="Финальный проект модуля 3 на JavaRush" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <title><%= helper.getDescription() %></title>
</head>
<body>
<div id="ajax-content" class="ajax-content" >
    <p class="greetengs"><%= helper.getGreetings()%></p>
    <form>
        <p>Вводи свое имя и погнали!
            <input type="text" id="name" name="name" /></p>

        <p>Submit button.

    </form>
    <button id="btn_Start" onclick="greet()" class="btn_Start">Старт!</button>
</div>

<script>
    function greet () {
        let name = document.getElementById("name").value;
        $.ajax({
            url: "<%= helper.getLinkToStart() %>",
            type: "POST",
            dataType: "html",
            data: {"name" : name},
            async: false,
            success: function (data){
                $("#ajax-content").html(data);
            }
        });
    }
</script>

</body>
</html>
