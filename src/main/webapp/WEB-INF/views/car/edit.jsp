<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

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
        <h2>Редактирование Автомобиля</h2>
        <div class="row">
            <div class="col-md-4 col-lg-4 content-container">
                <div class="field">
                    <form method="post">
                        <label>
                            <input type="hidden" value="${car.id}" name="id"/>
                        </label>
                        <br/>
                        <label>
                            number: <input value="${car.number}" name="number"/>
                        </label>
                        <br/>
                        <label>
                            mileage: <input value="${car.mileage}" input="number" name="mileage"/>
                        </label>
                        <br/>
                        <label>
                            year: <input value="${car.year}" input="number" name="year"/>
                        </label>
                        <br/>
                        <label>
                            priceStart: <input value="${car.priceStart}" input="number" name="priceStart"/>
                        </label>
                        <br/>
                        <label>
                            priceEnd: <input value="${car.priceEnd}" input="number" name="priceEnd"/>
                        </label>
                        <br/>
                        <label>
                            investor: <select size="1"  name="personId">
                            <option value=""> </option>
                            <c:forEach var="person" items="${persons}">
                                <option value="${person.id}"> ${person.lastName}</option>
                            </c:forEach>
                        </select>
                        </label>
                        <label>
                            car: <select size="1" name="brandId">
                            <option value=""> </option>
                            <c:forEach var="brand" items="${brands}">
                                <option value="${brand.id}"> ${brand.model}</option>
                            </c:forEach>
                        </select>
                        </label>

                        <br/>
                        <input type="submit"/>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>


