<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%--<jsp:include page="/WEB-INF/views/includes/add.css"/>--%>
<html>
<head>
    <title>Добавление работ</title>
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
    <h2>Добавление работ</h2>
    <div class="row">
        <div class="col-md-4 col-lg-4 content-container">
            <div class="field">
                <form id="work" method="post">
                    <label>
                        Выбор автомобиля: <select size="1" name="carId">
                        <option value=""> </option>
                        <c:forEach var="car" items="${cars}">
                            <option value="${car.id}"> ${car.number}</option>
                        </c:forEach>
                    </select>
                    </label>
                    <br/>
                    <label>Дата: <input type="date" name="Date"/>
                    </label>
                    <br/>
                    <label>
                        Пробег: <input input="number" name="mileage"/>
                    </label>
                    <br/>
                    <label>Наименование: <input  name="name"/>
                    </label>
                    <br/>
                    <label>Описание: <textarea form="work" name="description" ></textarea>
                     </label>
                    <br/>
                    <label>Стоимость: <input  name="price"/>
                    </label>
                    <br/>
                    <%--<label>Выполнено: <input type="checkbox"  name="done"/>--%>
                    <%--</label>--%>

                    <br/>
                    <input type="submit"/>

                </form>
            </div>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/views/includes/footer.jsp" %>