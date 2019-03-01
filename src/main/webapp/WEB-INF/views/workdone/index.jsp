<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Home</title>


    <%@include file="/WEB-INF/views/includes/header.jsp" %>


    <section>
        <h2>Выполненные работы</h2>
        <form method="post">



            <label>
                Автомобиль: <select id="choice" ; size="1" name="carId">
                <option value="0"> Все</option>
                <c:forEach var="car" items="${cars}">
                    <option value="${car.id}"> ${car.number}</option>
                </c:forEach>
            </select>
                </br>
            </label>
            <input type="submit">
        </form>
        <a href="workdone/add">Добавить</a>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Автомобиль</th>
                <th>Дата</th>
                <th>Пробег</th>
                <th>Наименование</th>
                <th>Описание</th>
                <%--<th>Время</th>--%>
                <th>Стоимость</th>
                <%--<th>Выполнено</th>--%>
                <th>Операция</th>
            </tr>
            </thead>
            <tbody>

            <% int i = 0;%>

            <c:forEach items="${workdones}" var="workdone">
                <% i++;%>

                <tr>
                    <th scope="row"></th>
                    <td>${workdone.car.number}</td>
                    <td>${workdone.date}</td>
                    <td>${workdone.mileage}</td>
                    <td>${workdone.name}</td>
                    <td>${workdone.description}</td>
                    <%--<td>${workdone.time}</td>--%>
                    <td>${workdone.price}</td>
                    <%--<td>--%>
                        <%--<input onload="ch()" type="checkbox" id="${workdone.id}" name="done">--%>
                        <%--<script>--%>
                            <%--function ch() {--%>
                                 <%--$("#${workdone.id}").prob('checked', ${workdone.done});--%>
                            <%--}--%>
                        <%--</script>--%>

                    <%--</td>--%>

                    <th><a href="/workdone/edit/${workdone.id}">Редактировать</a>
                        <a href="/workdone/delete/${workdone.id}">Удалить</a></th>
                </tr>
            </c:forEach>
            </tbody>
        </table>



    </section>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>

<%@include file="/WEB-INF/views/includes/footer.jsp" %>