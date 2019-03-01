<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%--<jsp:include page="/WEB-INF/views/includes/add.css"/>--%>
<html>
<head>
    <title>Добавление оплаты</title>
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
        <h2>Оплата: ${coming.get().startDate}   -   ${coming.get().startDate.plusDays(7)} ${coming.get().car.person.lastName}  ${coming.get().car.number}   </h2>
        <div class="row">
            <div class="col-md-4 col-lg-4 content-container">
                <div class="field">
                    <form method="post">

                        Сумма: <input value="${coming.get().investorIncome}" input="number" name="sum"/>
                        Карта: <input value="${coming.get().car.person.card}" name="card"/>
                        <input hidden value="${coming.get().id}" name="comingId"/>
                        <%--<label>Начало периода: <input type="date" name="startDate"/>--%>
                        <%--</label>--%>
                        <%--<label>--%>
                            <%--Сумма: <input input="number" name="sum"/>--%>
                        <%--</label>--%>
                        <%--<br/>--%>
                        <%--<label>--%>
                            <%--Инвестор: <select size="1" name="personId">--%>
                            <%--<option value=""> </option>--%>
                            <%--<c:forEach var="person" items="${persons}">--%>
                                <%--<option value="${person.id}"> ${person.lastName}</option>--%>
                            <%--</c:forEach>--%>
                        <%--</select>--%>
                        <%--</label>--%>

                        <br/>
                        <input value="Оплатить" type="submit"/>
                        <br/>

                    </form>
                    <%--<form method="POST" action="https://www.liqpay.ua/api/3/checkout"--%>
                          <%--accept-charset="utf-8">--%>
                        <%--<input type="hidden" name="data" value="eyAidmVyc2lvbiIgOiAzLCAicHVibGljX2tleSIgOiAieW91cl9wdWJsaWNfa2V5IiwgImFjdGlv--%>
<%--biIgOiAicGF5IiwgImFtb3VudCIgOiAxLCAiY3VycmVuY3kiIDogIlVTRCIsICJkZXNjcmlwdGlv--%>
<%--biIgOiAiZGVzY3JpcHRpb24gdGV4dCIsICJvcmRlcl9pZCIgOiAib3JkZXJfaWRfMSIgfQ=="/>--%>
                        <%--<input type="hidden" name="signature" value="QvJD5u9Fg55PCx/Hdz6lzWtYwcI="/>--%>
                        <%--Оплатить с помощью Liqpay--%>
                        <%--<input type="image"--%>
                               <%--src="//static.liqpay.ua/buttons/p1ru.radius.png"/>--%>
                    <%--</form>--%>

                </div>
            </div>
        </div>
    </section>

<script src="//static.liqpay.ua/libjs/checkout.js" async></script>
<%@include file="/WEB-INF/views/includes/footer.jsp" %>