<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h4>Нормативная база работ</h4>
<hr class="title">
<div class="toolbar">
    <a href='<c:url value="/standart/work/create"/>' class="btn btn-default">Добавить</a>
</div>
<table class="table" border="1">
    <thead>
        <tr>
            <th>Шифр</th>
            <th>Наименование</th>
            <th>Ед. изм.</th>
            <th>Всего</th>
            <th>ЗП рабочих-строителей</th>
            <th>Экспл. машин</th>
            <th>в т.ч. ЗП машинистов </th>
            <th>Наклад-ные расходы(%)</th>
            <th>Тип работы</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="work" items="${works}" varStatus="status">
            <tr>
                <td>${work.standart.code}</td>
                <td>${work.standart.name}</td>
                <td>${work.standart.unit.name}</td>
                <td><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${work.totalCost}"/></td>
                <td><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${work.wagesOfWorkers}"/></td>
                <td><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${work.operMachinesCost}"/></td>
                <td><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${work.includingWagesOfMachinists}"/></td>
                <td>${work.percent}</td>
                <td>${work.workType.name}</td>
                <%-- <td><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${resource.cost}"/></td>
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
                </td> --%>
            </tr>
            <!-- Ресурсы -->
                <td colspan="9">
                    <table class="table" border="1">
                        <thead>
                            <tr>
                                <th>№ п/п</th>
                                <th>Код ресурса</th>
                                <th>Наименование ресурса</th>
                                <th>Измеритель</th>
                                <th>Количество</th>
                                <th>Стоимость</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="resourceWork" items="${work.resources}">
                                <tr>
                                    <td>${resourceWork.queue}</td>
                                    <td>${resourceWork.resource.standart.code}</td>
                                    <td>${resourceWork.resource.standart.name}</td>
                                    <td>${resourceWork.resource.standart.unit.name}</td>
                                    <td><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${resourceWork.quantity}"/></td>
                                    <td><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${resourceWork.resource.cost}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </td>
            <!-- Конец ресурсов -->
        </c:forEach>
    </tbody>
</table>