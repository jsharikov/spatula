<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h4>Нормативная база ресурсов</h4>
<hr class="title">
<div class="toolbar">
    <a href='<c:url value="/standart/resource/create"/>' class="btn btn-default">Добавить</a>
</div>
<table class="table" border="1">
    <thead>
        <tr>
            <th class="col-md-1">Шифр</th>
            <th class="col-md-5">Наименование</th>
            <th class="col-md-1">Ед. изм.</th>
            <th class="col-md-1">Стоимость</th>
            <th class="col-md-1">Тип ресурса</th>
            <th class="col-md-1">Зарплата машиниста</th>
            <th class="col-md-2"></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="resource" items="${resources}">
            <tr>
                <td>${resource.standart.code}</td>
                <td>${resource.standart.name}</td>
                <td>${resource.standart.unit.name}</td>
                <td><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${resource.cost}"/></td>
                <td>
                    <c:if test="${resource.machine}">
                        Машина
                    </c:if>
                    <c:if test="${!resource.machine}">
                        Материал
                    </c:if>
                </td>
                <td><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${resource.wageOfMachinist}"/></td>
                <td class="center">
                    <c:url var="editUrl" value="/standart/resource/${resource.id}"/>
                    <a class="btn btn-info btn-sm" href="${editUrl}">
                        <i class="glyphicon glyphicon-edit icon-white"></i>
                        Ред.
                    </a>
                    <a class="btn btn-danger btn-sm" href="#">
                        <i class="glyphicon glyphicon-trash icon-white"></i>
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>