<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=ru>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0" />
    <meta charset="utf-8" />
    <meta name="description" content="Финальный проект модуля 3 на JavaRush" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <title>JavaRushModule3</title>
</head>
<body>
<div id="ajax-content" class="ajax-content" >
    <p class="greetengs">Приветствую тебя игрок! Для начала приключения нажми кнопку!</p>
    <form>
        <p>Вводи свое имя и погнали!
            <input type="text" id="name" name="name" /></p>
    </form>
    <button id="btn_Start" onclick="greet()" class="btn_Start">Старт!</button>
</div>
<hr>
<div class="logger" id="logger">

</div>
<script>
    function greet () {
        let name = document.getElementById("name").value;
        $.ajax({
            url: "/start",
            type: "POST",
            dataType: "html",
            data: {"name" : name},
            async: false,
            success: function (data){
                $("#ajax-content").html(data);
            }
        });
    }

    $(document).ready(function(){
        $.ajax({
            url: "/logger",
            type: "POST",
            dataType: "html",
            async: false,
            success: function (data){
                $("#logger").html(data);
            }
        });
    });
</script>

</body>
</html>
