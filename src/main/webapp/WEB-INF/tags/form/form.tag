<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="modelAttribute" required="true" type="java.lang.String" %>
<%@ attribute name="path" required="true" type="java.lang.String" %>
<%@ attribute name="multipart" required="false" type="java.lang.Boolean" %>
<%@ attribute name="cancelUrl" required="false" type="java.lang.String" %>

<c:set var="enctype" value="application/x-www-form-urlencoded" />
<c:if test="${multipart}">
	<c:set var="enctype" value="multipart/form-data" />
</c:if>
<spring:url value="${path}" var="form_url" />
<form:form action="${form_url}" method="POST" modelAttribute="${modelAttribute}" enctype="${enctype}">
	<jsp:doBody />
	<input class="btn btn-default" type="submit" value="Сохранить" />
	<c:url value="${cancelUrl}" var="cancel_url"/>
    <a class="btn btn-default" href="${cancel_url}">Отмена</a>
</form:form>
