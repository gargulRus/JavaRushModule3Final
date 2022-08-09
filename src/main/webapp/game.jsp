<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:out value="${requestScope.story}"/>
<form>
    <p>Выбери действие!</p>
    <div>
        <c:choose>
            <c:when test="${actions != null}">
                <c:forEach items="${actions}" var="action">
                    <input type="radio" id="choice${action.key}"
                           name="action" value="${action.key}">
                    <label for="choice${action.key}">${action.value}</label>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${isEnd != null}">

                    </c:when>
                    <c:otherwise>
                        <input type="radio" id="choice1"
                               name="action" value="1">
                        <label for="choice1">Пойти в зоо-магазин</label>

                        <input type="radio" id="choice2"
                               name="action" value="2">
                        <label for="choice2">Пойти в цветочный</label>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </div>

</form>
<button id="btn_Start" onclick="getActions()" class="btn_Start">Вперед!</button>

<script>

    function getActions () {
        let action = $("input[name='action']:checked").val();
        console.log(action);
        $.ajax({
            url: "/game",
            type: "POST",
            dataType: "html",
            data: {"action" : action},
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

    }
</script>