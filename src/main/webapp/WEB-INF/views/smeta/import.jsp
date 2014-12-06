<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib tagdir="/WEB-INF/tags/form/fields" prefix="field"%>
<%@ taglib tagdir="/WEB-INF/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>

<h4>Импорт сметы</h4>
<hr class="title">
<form:form modelAttribute="uploadFile" path="/smeta/import" cancelUrl="/smeta" multipart="true">
    <spring:bind path="file">
    <div class="form-group ${status.error ? 'has-error' : '' }">
        <springform:input type="file" class="form-control" path="file"/>
        <springform:errors path="file" cssClass="help-block" element="span"/>
    </div>
</spring:bind>
</form:form>

