
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Add Coming</title>
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
        <h3>Добавление Прихода</h3>
        <div class="row">
            <div class="col-md-6 col-lg-6 content-container">
                <div class="field">
                                <form method="post">
                                    <label>
                                        Автомобиль: <select size="1" name="carId">
                                        <option value=""> </option>
                                        <c:forEach var="car" items="${cars}">
                                            <option value="${car.id}"> ${car.number}</option>
                                        </c:forEach>
                                    </select>
                                    </label>
                                    <br/>
                                    <label>Начало периода: <input type="date" name="startDateDto"/>
                                    </label>
                                    <br/>

                                    <label>Выручка: <input input="number"  step=".01" name="income" required pattern="\d+(\.\d+)?" title="данные вводить через точку"/>
                                    </label>
                                    <br/>
                                    <label>Бонус: <input input="number" step=".01" name="bonus" value="0"/>
                                    </label>
                                    <br/>

                                    <label>Пробег: <input input="number" name="mileage" required pattern="\d+(\.\d+)?"/>
                                    </label>
                                    <br/>

                                    <label>Затраты топливо: <input input="number" step=".01" name="fuelCosts" required pattern="\d+(\.\d+)?" title="данные вводить через точку"/>
                                    </label>
                                    <br/>

                                    <label>Траты ТО: <input input="number" step=".01" value="0" name="costsOfMaintenance" pattern="\d+(\.\d+)?"/>
                                    </label>
                                    <br/>

                                    <label>Траты Ремонт: <input input="number" step=".01" value="0" name="costsOfRepairs" pattern="\d+(\.\d+)?"/>
                                    </label>
                                    <br/>

                                    <label>Текущие затраты: <input input="number" step=".01" value="0" name="currentExpenses" pattern="\d+(\.\d+)?"/>
                                    </label>
                                    <br/>
                                    <label>Мойка: <input input="number" step=".01" value="0" name="carWash" pattern="\d+(\.\d+)?"/>
                                    </label>
                                    <br/>

                                    <br/>
                                    <input type="submit"/>
                                </form>
                            </div>
                        </div>
                    </div>

    </section>
<%@include file="/WEB-INF/views/includes/footer.jsp" %>