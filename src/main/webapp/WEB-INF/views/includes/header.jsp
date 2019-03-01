<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>


<%--<link rel="stylesheet" type="text/css" media="screen" href="/WEB-INF/views/includes/style.css"/>--%>
<%--<link rel="stylesheet" href="http://getbootstrap.com/dist/css/bootstrap.min.css">--%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<style>
    <%@include file='/WEB-INF/views/includes/style.css' %>
</style>
</head>

<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2 col-lg-1 navbar-container bg-light">
            <nav class="navbar navbar-expand-md navbar-light">
                <a class="navbar-brand" href="#">Автопарк</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbar">
                    <!-- Вертикальное меню -->
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="/">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/coming">Приходы</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/payment">Оплаты</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/person">Персоны</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/car">Автомобили</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/setting">Настройки</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/brand">Бренды</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/workdone">Выполненные работы</a>
                        </li>


                    </ul>
                </div>
            </nav>
        </div>

        <div class="col-md-10 col-lg-11 content-container" style="background-color: #ffe0b2">
            <div >

                <div style="margin-top: 20px;">

                    <p class="lead">

                    </p>

                    Здраствуйте:
                    <sec:authentication var="user" property="principal" />
                    <sec:authentication property="name"/>
                   <%--<sec:authorize  access="!isAuthenticated()">--%>
                    <a class="btn btn-sm btn-success" href="<c:url value="/login" />" role="button">Войти</a>
                    <%--</sec:authorize>--%>
                    <%--<sec:authorize access="isAuthenticated()">--%>


                        <%--<sec:authentication var="user" property="principal" />--%>
                        <%--<sec:authentication property="name"/>--%>
                            <a class="btn btn-sm btn-danger" href="<c:url value="/j_spring_security_logout" />" role="button">Выйти</a>
                    <%--</sec:authorize>--%>
                </div>
            <hr class="mb-5">

