<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>


<%--<jsp:include page="/WEB-INF/views/includes/add.css"/>--%>
<html>
<head>
    <title>Добавление бренда</title>
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
    <h2>Редактирование бренда</h2>
    <div class="row">
        <div class="col-md-4 col-lg-4 content-container">
            <div class="field">
                <form method="post">
                    <label>
                        <input type="hidden" value="${brand.get().id}" name="id"/>
                    </label>
                    <label>
                        Марка : <input value="${brand.get().brand}"name="brand"/>
                    </label>
                    <br/>
                    <label>
                        Модель: <input value="${brand.get().model}"name="model"/>
                    </label>
                    <br/>
                    <label>
                        Объем двигателя: <input value="${brand.get().engineСapacity}" input="number" name="engineСapacity"/>
                    </label>
                    <br/>
                    <label>
                        Трансмиссия: <input value="${brand.get().transmission}" name="transmission"/>
                    </label>
                    <br/>




                    <input type="submit"/>

                </form>
            </div>
        </div>
    </div>
</section>

<%@include file="/WEB-INF/views/includes/footer.jsp" %>
