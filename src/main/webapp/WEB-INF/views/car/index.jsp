<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Автомобили</title>
    <%--<link rel="stylesheet" type="text/css" href="/style.css"/>--%>
    <%--<link rel="stylesheet" href="http://getbootstrap.com/dist/css/bootstrap.min.css">--%>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>

        <section>
            <h2>Автомобили</h2>
            <a href="car/add">Добавить</a>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Гос Номер</th>
                    <th>Пробег</th>
                    <th>Год</th>
                    <th>Начальная цена</th>
                    <th>Конечная цена</th>
                    <th>Инвестор</th>
                    <th>Марка</th>
                    <th>Операция</th>
                </tr>
                </thead>
                <tbody>

                <% int i = 0;%>

                <c:forEach items="${cars}" var="car">
                    <% i++;%>

                    <tr>
                        <th scope="row"></th>
                        <td>${car.number}</td>
                        <td>${car.mileage}</td>
                        <td>${car.year}</td>
                        <td>${car.priceStart}</td>
                        <td>${car.priceEnd}</td>
                        <td>${car.person.lastName}</td>
                        <td>${car.brand.brand}</td>
                        <th><a href="/car/edit/${car.id}">Редактировать</a>
                            <a href="/car/delete/${car.id}">Удалить</a></th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
</section>
<%@include file="/WEB-INF/views/includes/footer.jsp" %>