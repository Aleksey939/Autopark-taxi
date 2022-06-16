<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>


    <title>Coming</title>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>

    <section>
        <h2>Приходы</h2>
        <form method="post">
            <label>

                Инвестор: <select id="choice"  size="1" name="personId">
                <c:set var = "personPost" scope = "session" value = "${personPost}"/>
                <c:if test = "${personPost!=null}" >
                    <option value="${personPost.id}">${personPost.lastName}</option>

                </c:if>


                    <option value="0">Все</option>

           <c:forEach var="person" items="${persons}">
                    <option value="${person.id}"> ${person.lastName}</option>
                </c:forEach>
            </select>
            </label>


            <label>

                Автомобиль: <select id="choice" ; size="1" name="carId">
                <c:set var = "car" scope = "session" value = "${carPost}"/>
                <c:if test = "${carPost!=null}" >
                    <option value="${carPost.id}">${carPost.number}</option>
                </c:if>


                    <option value="0">Все</option>


                   <c:forEach var="car" items="${cars}">
                    <option value="${car.id}"> ${car.number}</option>
                </c:forEach>
            </select>
                </br>
            </label>
            </br>
            <label>
                Дата с: <input type="date" value="2022-01-01" name="date1"/> По: <input type="date" value="2022-03-06"
                                                                                        name="date2"/>

                </br>
            </label>
            <input type="submit">
        </form>
        <a href="coming/add">Добавить</a>


        <table class="table table-hover table table-condensed ">

            <%--<tr>--%>
            <%--<th>&nbsp;</th>--%>

            <%--<c:forEach items="${comings}" var="coming">--%>
            <%--<th scope="row">${coming.car.id}</th>--%>
            <%--</c:forEach>--%>
            <%--</tr>--%>
            <tr>
                <th>&nbsp;</th>

                <c:forEach items="${comings}" var="coming">
                    <th>${coming.car.number}</th>
                </c:forEach>
                <th>Итоги</th>
            </tr>
            <tr>
                <td>Начало периода</td>

                <c:forEach items="${comings}" var="coming">
                    <td>${coming.startDate}</td>
                </c:forEach>
            </tr>
            <tr>
                <td>Конец периода</td>
                <c:forEach items="${comings}" var="coming">
                    <td>${coming.startDate.plusDays(7)}</td>
                </c:forEach>
            </tr>
            <tr>
                <td>Выручка</td>
                <c:forEach items="${comings}" var="coming">
                    <td class="comingincome">${coming.income}</td>
                </c:forEach>
                <th id="comingincomeSum"></th>
            </tr>
            <tr>
                <td>Бонус</td>
                <c:forEach items="${comings}" var="coming">
                    <td class="bonus">${coming.bonus}</td>
                </c:forEach>
                <th id="bonusSum"></th>
            </tr>
            <tr>
                <td>% Партнера</td>
                <c:forEach items="${comings}" var="coming">
                    <td class="commissionPartner">${coming.commissionPartner}</td>
                </c:forEach>
                <th id="commissionPartnerSum"></th>
            </tr>
            <tr>
                <td>З/п водителя</td>
                <c:forEach items="${comings}" var="coming">
                    <td class="driverSalary">${coming.driverSalary}</td>
                </c:forEach>
                <th id="driverSalarySum"></th>
            </tr>
            <tr>
                <td>Пробег</td>
                <c:forEach items="${comings}" var="coming">
                    <td class="mileage">${coming.mileage}</td>
                </c:forEach>
                <th id="mileageSum"></th>
            </tr>
            <tr>
                <td>Расход топл/1км</td>
                <c:forEach items="${comings}" var="coming">
                    <td>${coming.consumptionOneKm}</td>
                </c:forEach>
            </tr>
            <tr>
                <td>Стоимость топлива</td>
                <c:forEach items="${comings}" var="coming">
                    <td>${coming.fuelCosts}</td>
                </c:forEach>
            </tr>
            <tr>
                <td>Выручка с 1 км</td>
                <c:forEach items="${comings}" var="coming">
                    <td>${coming.profitOneKm}</td>
                </c:forEach>

            </tr>

            <tr>
                <td>Отчисления фонд ТО</td>
                <c:forEach items="${comings}" var="coming">
                    <td class="fundMaintenance">${coming.fundMaintenance}</td>
                </c:forEach>
                <th id="fundMaintenanceSum"></th>
            </tr>
            <tr>
                <td>Траты ТО</td>
                <c:forEach items="${comings}" var="coming">
                    <td class="costsOfMaintenance">${coming.costsOfMaintenance}</td>
                </c:forEach>
                <th id="costsOfMaintenanceSum"></th>
            </tr>
            <tr>
                <td>Капитализация ТО</td>
                <c:forEach items="${comings}" var="coming">
                    <td class="capitalizationMaintenance">${coming.capitalizationMaintenanceEnd}</td>
                </c:forEach>
                <th id="capitalizationMaintenanceSum"></th>
            </tr>
            <tr>
                <td>Отисления фонд ремонт</td>
                <c:forEach items="${comings}" var="coming">
                    <td class="fundRepairs">${coming.fundRepairs}</td>
                </c:forEach>
                <th id="fundRepairsSum"></th>
            </tr>
            <tr>
                <td>Траты ремонт</td>
                <c:forEach items="${comings}" var="coming">
                    <td class="costsOfRepairs">${coming.costsOfRepairs}</td>
                </c:forEach>
                <th id="costsOfRepairsSum"></th>
            </tr>
            <tr>
                <td>Капитализация фонда Ремонт</td>
                <c:forEach items="${comings}" var="coming">
                    <td class="capitalizationRepairs">${coming.capitalizationRepairsEnd}</td>
                </c:forEach>
                <th id="capitalizationRepairsSum"></th>
            </tr>
            <tr>
                <td>Текущие затраты</td>
                <c:forEach items="${comings}" var="coming">
                    <td>${coming.currentExpenses}</td>
                </c:forEach>
            </tr>
            <tr>
                <td>Стоимость моек</td>
                <c:forEach items="${comings}" var="coming">
                    <td>${coming.carWash}</td>
                </c:forEach>
            </tr>

            <tr>
                <td>Прибыль</td>
                <c:forEach items="${comings}" var="coming">
                    <td class="profit">${coming.profit}</td>
                </c:forEach>
                <th id="profitSum"></th>
            </tr>
            <tr>
                <td>Комиссионнные за управление</td>
                <c:forEach items="${comings}" var="coming">
                    <td class="commissionControl">${coming.commissionControl}</td>
                </c:forEach>
                <th id="commissionControlSum"></th>
            </tr>
            <tr>
                <td>Доход инвестора</td>
                <c:forEach items="${comings}" var="coming">
                    <td class="investorIncome"><b>${coming.investorIncome}</b></td>
                </c:forEach>
                <th id="investorIncomeSum"></th>
            </tr>
            <tr>
                <td>Амортизация</td>
                <c:forEach items="${comings}" var="coming">
                    <td class="depreciation">${coming.depreciation}</td>
                </c:forEach>
                <th id="depreciationSum"></th>
            </tr>
            <tr>
                <td>Чистая Прибыль инвестора</td>
                <c:forEach items="${comings}" var="coming">
                    <td class="netinvestorIncome">${coming.netinvestorIncome}</td>
                </c:forEach>
                <th id="netinvestorIncomeSum"></th>
            </tr>
            <tr>
                <td>Оплата</td>

                    <c:forEach items="${comings}" var="coming">
                        <td>
                            <c:set var="checked" value ="unchecked"></c:set>
                            <c:if test="${coming.payment}">
                                <c:set var="checked" value ="checked"></c:set>
                            </c:if>
                        <input type="checkbox" ${checked} disabled>
                        </td>
                    </c:forEach>


            </tr>
            <tr>
                <td></td>
                <c:forEach items="${comings}" var="coming">
                    <th><a href="payment/addpaymentforComing/${coming.id}">Оплатить</a> </br>
                        <a href="payment/delete/${coming.id}">Удалить оплату</a>
                        </br>  <a href="/coming/edit/${coming.id}">Редактировать</a>
                        </br><a href="/coming/delete/${coming.id}">Удалить</a></th>

                </c:forEach>
            </tr>
        </table>


    </section>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>

    <script>
        function f() {
            var sum = 0;
            $('.investorIncome').each(function () {
                sum += +this.textContent;
            });
            investorIncomeSum.innerHTML = sum.toFixed(2);


            sum = 0;
            $('.commissionControl').each(function () {
                sum += +this.textContent;
            });
            commissionControlSum.innerHTML = sum.toFixed(2);


            sum = 0;
            $('.comingincome').each(function () {
                sum += +this.textContent;
            });
            comingincomeSum.innerHTML = sum.toFixed(2);


            sum = 0;
            $('.commissionPartner').each(function () {
                sum += +this.textContent;
            });
            commissionPartnerSum.innerHTML = sum.toFixed(2);

            sum = 0;
            $('.driverSalary').each(function () {
                sum += +this.textContent;
            });
            driverSalarySum.innerHTML = sum.toFixed(2);


            sum = 0;
            $('.mileage').each(function () {
                sum += +this.textContent;
            });
            mileageSum.innerHTML = sum.toFixed(2);

            var sumfundMaintenance = 0;
            $('.fundMaintenance').each(function () {
                sumfundMaintenance += +this.textContent;
            });
            fundMaintenanceSum.innerHTML = sumfundMaintenance.toFixed(2);

            var sumcostsOfMaintenance = 0;
            $('.costsOfMaintenance').each(function () {
                sumcostsOfMaintenance += +this.textContent;
            });
            costsOfMaintenanceSum.innerHTML = sumcostsOfMaintenance.toFixed(2);


            var sumfundRepairs = 0;
            $('.fundRepairs').each(function () {
                sumfundRepairs += +this.textContent;
            });
            fundRepairsSum.innerHTML = sumfundRepairs.toFixed(2);

            var sumcostsOfRepairs = 0;
            $('.costsOfRepairs').each(function () {
                sumcostsOfRepairs += +this.textContent;
            });
            costsOfRepairsSum.innerHTML = sumcostsOfRepairs.toFixed(2);


            sum = 0;
            $('.profit').each(function () {
                sum += +this.textContent;
            });
            profitSum.innerHTML = sum.toFixed(2);


            capitalizationRepairsSum.innerHTML = (sumfundRepairs - sumcostsOfRepairs).toFixed(2);
            capitalizationMaintenanceSum.innerHTML = (sumfundMaintenance - sumcostsOfMaintenance).toFixed(2);

            var suminvestorIncome = 0;
            $('.investorIncome').each(function () {
                suminvestorIncome += +this.textContent;
            });
            investorIncomeSum.innerHTML = suminvestorIncome.toFixed(2);


            var sumnetinvestorIncome = 0;
            $('.netinvestorIncome').each(function () {
                sumnetinvestorIncome += +this.textContent;
            });
            netinvestorIncomeSum.innerHTML = sumnetinvestorIncome.toFixed(2);

            var sumdepreciation = 0;
            $('.depreciation').each(function () {
                sumdepreciation += +this.textContent;
            });
            depreciationSum.innerHTML = sumdepreciation.toFixed(2);


            var sumbonus = 0;
            $('.bonus').each(function () {
                sumbonus += +this.textContent;
            });
            bonusSum.innerHTML = sumbonus.toFixed(2);

        }

        $(document).ready(f());
    </script>

<%@include file="/WEB-INF/views/includes/footer.jsp" %>