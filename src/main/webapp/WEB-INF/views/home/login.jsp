
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Home</title>


    <%@include file="/WEB-INF/views/includes/header.jsp" %>

        <section>
            <title>Spring Security</title>
            <!-- Bootstrap core CSS -->
            <%--<link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">--%>
            <!-- Custom styles for this template -->
            <%--<link href="<c:url value="/pages/css/signin.css" />" rel="stylesheet">--%>
            <c:if test="${not empty errorMessge}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div></c:if>
            <div class="container" style="width: 300px;">
                <%--<c:url value="/j_spring_security_check" var="loginUrl"/>--%>

                <form name='login' action="/login" method="post">
                    <h2 class="form-signin-heading">Please sign in</h2>
                    <input type="text" class="form-control" name="username" placeholder="Email address" required
                           autofocus >
                    <input type="password" class="form-control" name="password" placeholder="Password" required
                           >
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
                </form>
                <%--<form name="f" action="j_spring_security_check" method="post">--%>
                    <%--<label for="username">Username:</label>--%>
                    <%--<input id="username" name="j_username"></br>--%>
                    <%--<label for="password">Password:</label>--%>
                    <%--<input id="password" name="j_password" type='password'></br>--%>
                    <%--<input name="submit" type="submit" value="Login"/> </form>--%>
            </div>

        </section>

        <%@include file="/WEB-INF/views/includes/footer.jsp" %>



