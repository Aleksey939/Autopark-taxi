<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Coming</title>


    <%@include file="/WEB-INF/views/includes/header.jsp" %>
    <div class="col-md-9 col-lg-10 content-container" style="background-color: #ffe0b2">

        <hr class="mb-5">

        <section>
            <h2>Отчет</h2>
            <form method="post">
                <label>
                    Ивестор: <select id="choice" onchange=func(); size="1" name="personId">
                    <option value="0"> Все</option>
                    <c:forEach var="person" items="${persons}">
                        <option value="${person.id}"> ${person.lastName}</option>
                    </c:forEach>
                </select>
                </label>


                </label>


                <label>
                    Автомобиль: <select id="choice" onchange=func(); size="1" name="carId">
                    <option value="0"> Все</option>
                    <c:forEach var="car" items="${cars}">
                        <option value="${car.id}"> ${car.number}</option>
                    </c:forEach>
                </select>
                    </br>
                </label>
                <input type="submit">
            </form>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#</th>
                     <th>Инвестор</th>
                    <th>За управление</th>
                    <th>Доход инвестора</th>
                                  </tr>
                </thead>
                <tbody>
                <% int i = 0;%>
                <c:forEach items="${payments}" var="payment">
                    <% i++;%>
                    <tr>
                        <th scope="row">*</th>
                        <td>${person.lastName}</td>
                        <td>${report.sum1}</td>
                        <td>${report.sum2}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>






        </section>

    </div>
    </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>


    </body>