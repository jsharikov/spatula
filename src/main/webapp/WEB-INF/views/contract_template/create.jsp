<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib tagdir="/WEB-INF/tags/form/fields" prefix="field"%>
<%@ taglib tagdir="/WEB-INF/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>

<h4>Добавление шаблона договора</h4>
<hr class="title">


<springform:form modelAttribute="contractTemplateForm" commandName="contractTemplateForm" action="/spatula/documents/contract_template/save" method="post">
    <springform:label class="control-label" path="" >Название шаблона договора</springform:label>
    <springform:input class="form-control" path="contractTemplateName" />
    <br />
    <springform:checkboxes items="${nodes}" delimiter="<br />" path="nodeIds" itemLabel="name" itemValue="id"/>
    <br />
    <input class="btn btn-default" type="submit" value="Сохранить" />
    <c:url value="/documents/node" var="cancel_url"/>
    <a class="btn btn-default" href="${cancel_url}">Отмена</a>
</springform:form>


