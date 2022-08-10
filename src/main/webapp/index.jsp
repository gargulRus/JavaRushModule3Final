<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=ru>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0" />
    <meta charset="utf-8" />
    <meta name="description" content="Финальный проект модуля 3 на JavaRush" />
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <link href="<c:url value="/static/bootstrap.min.css"/>" rel="stylesheet">
    <title>JavaRushModule3</title>
</head>
<body>
<div class="row">
    <div class="col-sm-12 text-center" >
        <h2>Привет! Сегодня нам предстоит прожить непростой путь мужика с городка "Нигде"</h2>
    </div>
</div>
<div class="row">
    <div class="col-sm-6 p-5" >
        <div id="ajax-content" class="ajax-content" >
            <form>
                <p>Вводи мужицкое имя и погнали!
                    <input type="text" id="name" name="name" /></p>
            </form>
            <button id="btn_Start" onclick="greet()" class="btn btn-success  btn_Start">Старт!</button>
        </div>
    </div>
    <div class="col-sm-6 p-5">
        <div class="logger" id="logger">

        </div>
    </div>
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
