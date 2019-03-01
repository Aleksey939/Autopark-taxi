<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Автомобили</title>
    <%--<link rel="stylesheet" type="text/css" href="/style.css"/>--%>
    <%--<link rel="stylesheet" href="http://getbootstrap.com/dist/css/bootstrap.min.css">--%>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>

    <section>
        <h2>Бренд</h2>
        <a href="brand/add">Добавить</a>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Марка</th>
                <th>Модель</th>
                <th>Объем двиг</th>
                <th>КПП</th>

            </tr>
            </thead>
            <tbody>



            <c:forEach items="${brands}" var="brand">


                <tr>
                    <th scope="row">${car.id}</th>
                    <td>${brand.brand}</td>
                    <td>${brand.model}</td>
                    <td>${brand.engineСapacity}</td>
                    <td>${brand.transmission}</td>


                    <th><a href="/car/edit/${car.id}">Редактировать</a>
                        <a href="/car/delete/${car.id}">Удалить</a></th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
<%@include file="/WEB-INF/views/includes/footer.jsp" %>