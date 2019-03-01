<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Persons</title>
    <%--<link rel="stylesheet" type="text/css" href="/style.css"/>--%>
    <%--<link rel="stylesheet" href="http://getbootstrap.com/dist/css/bootstrap.min.css">--%>

    <%@include file="/WEB-INF/views/includes/header.jsp" %>


        <section>
            <h2>Персоны</h2>
            <a href="person/add">Добавить</a>
            <table class="table table-hover" class="sort">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>Паспорт</th>
                    <th>ИНН</th>
                    <th>Телефон</th>
                    <th>Email</th>
                    <th>Карта</th>
                    <th>Статус</th>
                    <th><a href="#link-4">Операция</a></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${persons}" var="person">
                    <tr>
                        <th scope="row"></th>
                        <td>${person.firstName}</td>
                        <td>${person.lastName}</td>
                        <td>${person.passport}</td>
                        <td>${person.identificationNumber}</td>
                        <td>${person.phone}</td>
                        <td>${person.email}</td>
                        <td>${person.card}</td>
                        <td>${person.status}</td>
                        <th><a href="/person/edit/${person.id}">Редактировать</a>
                            <a href="/person/delete/${person.id}">Удалить</a></th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </section>
        <%@include file="/WEB-INF/views/includes/footer.jsp" %>





