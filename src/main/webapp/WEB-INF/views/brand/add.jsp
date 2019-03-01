<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>


<%--<jsp:include page="/WEB-INF/views/includes/add.css"/>--%>
<html>
<head>
    <title>Добавление автомобиял</title>
    <style>
        .field {
            clear: both;
            text-align: right;
            line-height: 25px;
        }
    </style>
</head>
<body>
<%@include file="/WEB-INF/views/includes/header.jsp" %>

<section>
    <h2>Добавление Автомобиля</h2>
    <div class="row">
        <div class="col-md-4 col-lg-4 content-container">
            <div class="field">
                <form method="post">
                    <label>
                       Марка : <input name="brand"/>
                    </label>
                    <br/>
                    <label>
                        Модель: <input name="model"/>
                    </label>
                    <br/>
                    <label>
                        Объем двигателя: <input input="number" name="engineСapacity"/>
                    </label>
                    <br/>
                    <label>
                        Трансмиссия: <input name="transmission"/>
                    </label>
                    <br/>




                    <input type="submit"/>

                </form>
            </div>
        </div>
    </div>
</section>

<%@include file="/WEB-INF/views/includes/footer.jsp" %>
