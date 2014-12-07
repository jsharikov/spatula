<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="path" required="true" type="java.lang.String" %>
<%@attribute name="label" required="false" type="java.lang.String" %>
<%@attribute name="items" required="true" type="java.util.Collection" %>
<%@attribute name="itemLabel" required="true" type="java.lang.String" %>
<%@attribute name="itemValue" required="true" type="java.lang.String" %>
<%@attribute name="disabled" required="false" type="java.lang.Boolean" %>

<spring:bind path="${path}">
    <div class="form-group ${status.error ? 'has-error' : '' }">
        <c:if test="${not empty label }">
            <form:label class="control-label" path="${path}">${label}</form:label>
        </c:if>
        <form:select class="form-control" path="${path}" disabled="${disabled}">
            <form:option value=""/>
            <form:options items="${items}" itemLabel="${itemLabel}" itemValue="${itemValue}"/>
        </form:select>
        <form:errors path="${path}" cssClass="help-block" element="span"/>
    </div>
</spring:bind>