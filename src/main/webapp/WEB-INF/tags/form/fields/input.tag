<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="path" required="true" type="java.lang.String" %>
<%@attribute name="label" required="false" type="java.lang.String" %>
<%@ attribute name="required" required="false" type="java.lang.String" %>
<%@ attribute name="disabled" required="false" type="java.lang.Boolean" %>
<%@ attribute name="readonly" required="false" type="java.lang.Boolean" %>

<spring:bind path="${path}">
    <div class="form-group ${status.error ? 'has-error' : '' }">
        <c:if test="${not empty label }">
            <form:label class="control-label" path="${path}">${label}</form:label>
        </c:if>
        <c:set var="disable" value="false"/>
        <c:if test="${not empty disabled }">
            <c:set var="disable" value="${disabled}"/>
        </c:if>
        <c:set var="read_only" value="false"/>
        <c:if test="${not empty readonly}">
            <c:set var="read_only" value="${readonly}"/>
        </c:if>
        <form:input class="form-control" path="${path}" disabled="${disable}" readonly="${read_only}"/>
        <form:errors path="${path}" cssClass="help-block" element="span"/>
    </div>
</spring:bind>