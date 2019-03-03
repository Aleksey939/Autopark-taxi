<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <html>
    <head>
        <title>Payment</title>


        <%@include file="/WEB-INF/views/includes/header.jsp" %>


            <section>
                <h2>Оплаты</h2>
                <form method="post">
                    <label>
                        Ивестор: <select id="choice"  size="1" name="personId">
                        <option value="0"> Все</option>
                        <c:forEach var="person" items="${persons}">
                            <option value="${person.id}"> ${person.lastName}</option>
                        </c:forEach>
                    </select>
                    </label>
                    </label>
                    <input type="submit">
                </form>
                <%--<a href="payment/add">Добавить</a>--%>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Период*</th>
                        <th>Сумма</th>
                        <th>Инвестор</th>
                        <th>Карта</th>
                        <th>Время</th>
                        <th>Операция</th>
                    </tr>
                    </thead>
                    <tbody>

                    <% int i = 0;%>

                    <c:forEach items="${payments}" var="payment">
                        <% i++;%>

                        <tr>
                            <th scope="row"></th>
                            <td>${payment.startDate} - ${payment.coming.startDate.plusDays(7)} </td>
                            <td>${payment.sum}</td>
                            <td>${payment.person.lastName}</td>
                            <td>${payment.person.card}</td>
                            <td>${payment.time}</td>
                            <th>
                                <%--<a href="/payment/edit/${payment.id}">Редактировать</a>--%>
                                <a href="/payment/delete/${payment.id}">Удалить</a></th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>


            </section>
<%@include file="/WEB-INF/views/includes/footer.jsp" %>