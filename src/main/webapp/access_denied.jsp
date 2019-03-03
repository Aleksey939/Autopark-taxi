<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Home</title>


    <%@include file="/WEB-INF/views/includes/header.jsp" %>


    <section>
       Доступ запрещен, только для Админа



    </section>

<%@include file="/WEB-INF/views/includes/footer.jsp" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <html>
    <head>
        <title>Home</title>


        <%@include file="/WEB-INF/views/includes/header.jsp" %>


        <section>
            Вы вошли как :
            <sec:authentication var="user" property="principal" />
            <sec:authentication property="name"/>
            <%--<sec:authorize  access="!isAuthenticated()">--%>
            <a class="btn btn-sm btn-success" href="<c:url value="/login" />" role="button">Войти</a>
            <%--</sec:authorize>--%>
            <%--<sec:authorize access="isAuthenticated()">--%>


            <%--<sec:authentication var="user" property="principal" />--%>
            <%--<sec:authentication property="name"/>--%>
            <a class="btn btn-sm btn-danger" href="<c:url value="/j_spring_security_logout" />" role="button">Выйти</a>
            <%--</sec:authorize>--%>



        </section>

<%@include file="/WEB-INF/views/includes/footer.jsp" %>