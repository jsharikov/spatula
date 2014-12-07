<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib tagdir="/WEB-INF/tags/form/fields" prefix="field"%>
<%@ taglib tagdir="/WEB-INF/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>

<style>
td, th {
    text-align: center;
}
th {
    vertical-align: middle;
    padding: 0px 2px;
    background-color: #AFEEEE;
}
.number {
    text-align: right;
}
.queue {
    vertical-align: top;
}
</style>

<h4>Создание сметы</h4>
<hr class="title">
<form:form modelAttribute="smetaForm" path="/smeta/save" cancelUrl="/smeta">
    <springform:hidden path="smeta.id"/>
<table border="1" id="example" class="smeta">
<thead>
    <tr>
        <th rowspan="4" width="*">N п/п</th>
        <th rowspan="4" width="*">Шифр и № позиции норматива</th>
        <th rowspan="4" width="25%">Наименование работ и затрат,  единица измерения</th>
        <th rowspan="4" width="*">Коли- чество</th>
        <th colspan="2" width="*">Стоимость ед, тенге</th>
        <th colspan="2" width="*">Общая стоимость, тенге</th>
        <th rowspan="2" width="*">Наклад- ные расходы</th>
        <th colspan="2" rowspan="2" width="*">Затраты  труда, чел.-ч, рабочих-строителей</th>
    </tr>
    <tr>
        <th>Всего</th>
        <th>Экспл машин</th>
        <th>Всего</th>
        <th>Экспл машин</th>
    </tr>
    <tr>
        <th rowspan="2">ЗП рабочих- строителей</th>
        <th rowspan="2">в т.ч. ЗП машин- истов </th>
        <th rowspan="2">ЗП рабочих- строителей</th>
        <th rowspan="2">в т.ч. ЗП машин- истов </th>
        <th>тенге</th>
        <th colspan="2">рабочих, обслуживаю- щих машины</th>
    </tr>
    <tr>
        <th>%</th>
        <th>на един.</th>
        <th>всего</th>
    </tr>
    </thead>
    <tbody>
<c:forEach var="workSmeta" items="${smetaForm.smeta.works}" varStatus="status">
    <tr>
        <td rowspan="3" class="queue">${workSmeta.queue}</td>
        <td rowspan="3">${workSmeta.work.standart.code}</td>
        <td rowspan="2" style="text-align: left;">${workSmeta.work.standart.name}</td>
        <td rowspan="3"><fmt:formatNumber value="${workSmeta.quantity}" minFractionDigits="2"/></td>
        <td rowspan="2" class="number"><fmt:formatNumber value="${workSmeta.work.totalCost}" minFractionDigits="2"/></td>
        <td rowspan="2" class="number"><fmt:formatNumber value="${workSmeta.work.operMachinesCost}" minFractionDigits="2"/></td>
        <td rowspan="2" class="number"><fmt:formatNumber value="${workSmeta.quantity * workSmeta.work.totalCost}" minFractionDigits="2"/></td>
        <td rowspan="2" class="number"><fmt:formatNumber value="${workSmeta.quantity * workSmeta.work.operMachinesCost}" minFractionDigits="2"/></td>
        <td rowspan="2" class="number"><fmt:formatNumber value="${workSmeta.quantity * (workSmeta.work.wagesOfWorkers + workSmeta.work.includingWagesOfMachinists) * workSmeta.work.percent / 100}" minFractionDigits="2"/></td>
        <td rowspan="2" class="number"><%-- <fmt:formatNumber value="${work.workersQuantity}" minFractionDigits="2"/> --%></td>
        <td rowspan="2" class="number"><%-- <fmt:formatNumber value="${work.workersTotalQuantity}" minFractionDigits="2"/> --%></td>
    </tr>
    <tr>
    </tr>
    <tr>
        <td class="number">${workSmeta.work.standart.unit.name}</td>
        <td class="number"><fmt:formatNumber value="${workSmeta.work.wagesOfWorkers}" minFractionDigits="2"/></td>
        <td class="number"><fmt:formatNumber value="${workSmeta.work.includingWagesOfMachinists}" minFractionDigits="2"/></td>
        <td class="number"><fmt:formatNumber value="${workSmeta.quantity * workSmeta.work.wagesOfWorkers}" minFractionDigits="2"/></td>
        <td class="number"><fmt:formatNumber value="${workSmeta.quantity * workSmeta.work.includingWagesOfMachinists}" minFractionDigits="2"/></td>
        <td class="number">${workSmeta.work.percent}%</td>
        <td class="number"><%-- <fmt:formatNumber  value="${work.machinistsQuantity}" minFractionDigits="2"/> --%></td>
        <td class="number"><%-- <fmt:formatNumber value="${work.machinistsTotalQuantity}" minFractionDigits="2"/> --%></td>
    </tr>
    <tr>
        <td colspan="11">
            <table border="1" width="100%">
                <thead>
                    <tr>
                        <td rowspan="2">№ п/п</td>
                        <td rowspan="2">Код ресурса</td>
                        <td rowspan="2">Наименование ресурса</td>
                        <td rowspan="2">Измеритель</td>
                        <td colspan="2">Количество</td>
                        <td colspan="2">Стоимость</td>
                    </tr>
                    <tr>
                        <td>на единицу</td>
                        <td>всего</td>
                        <td>на единицу</td>
                        <td>всего</td>
                    </tr>
                </thead>
                <c:forEach var="resourceWork" items="${workSmeta.work.resources}">
                    <tr>
                        <td>${workSmeta.queue}.${resourceWork.queue}</td>
                        <td>${resourceWork.resource.standart.code}</td>
                        <td>${resourceWork.resource.standart.name}</td>
                        <td>${resourceWork.resource.standart.unit.name}</td>
                        <td>
                            <c:set var="resQuantity" value="${resourceWork.quantity}"/>
                            <fmt:formatNumber value="${resQuantity}" minFractionDigits="2"/>
                        </td>
                        <td><fmt:formatNumber value="${resourceWork.quantity * workSmeta.quantity}" minFractionDigits="2"/></td>
                        <td><fmt:formatNumber value="${resourceWork.resource.cost}" minFractionDigits="2"/></td>
                        <td><fmt:formatNumber value="${resourceWork.resource.cost * resourceWork.quantity * workSmeta.quantity}" minFractionDigits="2"/></td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
</c:forEach>
</tbody>
</table>

    <field:select label="Работа" path="workSmeta.workId" items="${works}" itemLabel="standart.name" itemValue="id"/>
    <field:input label="Количество" path="workSmeta.quantity"/>
</form:form>


