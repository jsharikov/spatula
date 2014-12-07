<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib tagdir="/WEB-INF/tags/form/fields" prefix="field"%>
<%@ taglib tagdir="/WEB-INF/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>

<h4>Добавление договора</h4>
<hr class="title">

<form:form modelAttribute="contractForm" path="/documents/contract/save" cancelUrl="/documents/contract">
    <field:input label="Наименование" path="contractName"/>
    <field:select label="Шаблон" path="templateId" items="${contractTemp}" itemLabel="name" itemValue="id"/>
</form:form>


