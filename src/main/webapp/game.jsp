<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p class="">
    <c:out value="${requestScope.story}"/>
</p>
<form class="form-control">
    <p>Выбери действие!</p>
    <div class="">
        <c:choose>
            <c:when test="${actions != null}">
                <c:forEach items="${actions}" var="action">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" id="choice${action.key}"
                               name="action" value="${action.key}">
                        <label class="form-check-label" for="choice${action.key}">${action.value}</label>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${isEnd != null}">

                    </c:when>
                    <c:otherwise>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" id="choice1"
                                   name="action" value="1">
                            <label class="form-check-label" for="choice1">Пойти в зоо-магазин</label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" id="choice2"
                                   name="action" value="2">
                            <label class="form-check-label" for="choice2">Пойти в цветочный</label>
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </div>

</form>
<div class="mt-2">
    <button id="btn_Start" onclick="getActions()" class="btn btn-success btn_Start">Вперед!</button>
</div>


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