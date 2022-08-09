<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Приветствую тебя! <c:out value="${sessionScope.name}"/>  Нас ждет небольшой квест!</h1>
<div class="">
    <p>
        <a href="/">Начать снова</a>
    </p>
</div>

<div class="game-content-area" id="game-content-area">

</div>

<script>

    $(document).ready(function(){
        $.ajax({
            url: "/game",
            type: "POST",
            dataType: "html",
            async: false,
            success: function (data){
                $("#game-content-area").html(data);
            }
        });
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
