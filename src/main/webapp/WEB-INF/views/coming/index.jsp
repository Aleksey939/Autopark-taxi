<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 20.12.2018
  Time: 09:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

    <title>Coming</title>
    <style>
        table {
            width: 100%; /* Ширина таблицы в процентах */
        }
        .col1 {
            width: 50px; /* Ширина ячейки */
        }
    </style>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
    <div   class="col-md-9 col-lg-11 content-container" style="background-color: #ffe0b2" >
        <hr class="mb-5">
        <section>
            <h2>Приходы</h2>
            <a href="coming/add">Добавить</a>

            <table   class="table table-hover table table-condensed ">

                <thead>
                <tr>
                   <th>#</th>
                    <th>Auto</th>
                    <th>startDate</th>
                    <th>EndDate</th>
                    <th>income</th>
                    <th>commissionPartner</th>
                    <th>driverSalary</th>
                    <th>mileage</th>
                    <th>consumptionOneKm</th>
                    <th>fuelCosts</th>
                    <th>profitOneKm</th>
                    <th>fundMaintenance</th>
                    <th>costsOfMaintenance</th>
                    <th>capitalizationMaintenance</th>
                    <th>fundRepairs</th>
                    <th>costsOfRepairs</th>
                    <th>capitalizationRepairs</th>
                    <th>currentExpenses</th>
                    <th>carWash</th>
                    <th>profit</th>
                    <th>commissionControl</th>
                    <th>investorIncome</th>
                    <th><a href="#link-4">Операция</a></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${comings}" var="coming">
                    <tr>
                        <th scope="row">${coming.id}</th>
                        <td class="col1" >${coming.car.number}</td>
                        <td class="col1">${coming.startDate}</td>
                        <td class="col1">${coming.startDate}</td>
                        <%--.plusDays(coming.days)--%>
                        <td class="col1">${coming.income}</td>
                        <td class="col1">${coming.commissionPartner}</td>
                        <td class="col1">${coming.driverSalary}</td>
                        <td class="col1">${coming.mileage}</td>
                        <td class="col1">${coming.consumptionOneKm}</td>
                        <td>${coming.fuelCosts}</td>
                        <td>${coming.profitOneKm}</td>
                        <td>${coming.fundMaintenance}</td>
                        <td>${coming.costsOfMaintenance}</td>
                        <td>${coming.capitalizationMaintenanceStart}</td>
                        <td>${coming.fundRepairs}</td>
                        <td>${coming.costsOfRepairs}</td>
                        <td>${coming.capitalizationRepairsStart}</td>
                        <td>${coming.currentExpenses}</td>
                        <td>${coming.carWash}</td>
                        <td>${coming.profit}</td>
                        <td>${coming.commissionControl}</td>
                        <td>${coming.investorIncome}</td>
                        <th><a href="/coming/edit/${coming.id}">Редактировать</a>
                            <a href="/coming/delete/${coming.id}">Удалить</a></th>
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
</html>
