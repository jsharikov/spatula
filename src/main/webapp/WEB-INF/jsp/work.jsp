<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form commandName="work" class = "form-horizontal">
    <div class="form-group">
        <form:label class="control-label" path="standartWorkId">Норматив работы</form:label>
        <form:select class="form-control" path="standartWorkId">
            <form:options items="${standarts}" itemLabel="name" itemValue="id"/>
        </form:select>
    </div>
    <div class="form-group">
        <form:label class="control-label" path="quantity">Количество</form:label>
        <form:input class="form-control" path="quantity"/>
    </div>
    <button class="btn btn-default">Сохранить</button>
</form:form>