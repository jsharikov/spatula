<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

<!-- <script>
$(document).ready(function() {
    $('#example').dataTable();
} );
</script> -->
<form action='<c:url value="/smeta/${smeta.id}/work/new"/>'>
    <button class="btn btn-default">Добавить новую работу</button>
</form>
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
<c:forEach var="work" items="${smeta.works}" varStatus="status">
    <tr>
        <td rowspan="3" class="queue">${status.index + 1}</td>
        <td rowspan="3">${work.standartWork.code}</td>
        <td rowspan="2" style="text-align: left;">${work.standartWork.name}</td>
        <td rowspan="3"><fmt:formatNumber value="${work.quantity}" minFractionDigits="2"/></td>
        <td rowspan="2" class="number"><fmt:formatNumber value="${work.standartWork.totalCost}" minFractionDigits="2"/></td>
        <td rowspan="2" class="number"><fmt:formatNumber value="${work.standartWork.operMachinesCost}" minFractionDigits="2"/></td>
        <td rowspan="2" class="number"><fmt:formatNumber value="${work.quantity * work.standartWork.totalCost}" minFractionDigits="2"/></td>
        <td rowspan="2" class="number"><fmt:formatNumber value="${work.quantity * work.standartWork.operMachinesCost}" minFractionDigits="2"/></td>
        <td rowspan="2" class="number"><fmt:formatNumber value="${work.quantity * (work.standartWork.wagesOfWorkers + work.standartWork.includingWagesOfMachinists) * work.standartWork.percent / 100}" minFractionDigits="2"/></td>
        <td rowspan="2" class="number"><fmt:formatNumber value="${work.workersQuantity}" minFractionDigits="2"/></td>
        <td rowspan="2" class="number"><fmt:formatNumber value="${work.workersTotalQuantity}" minFractionDigits="2"/></td>
    </tr>
    <tr>
    </tr>
    <tr>
        <td class="number">${work.standartWork.unitId}</td>
        <td class="number"><fmt:formatNumber value="${work.standartWork.wagesOfWorkers}" minFractionDigits="2"/></td>
        <td class="number"><fmt:formatNumber value="${work.standartWork.includingWagesOfMachinists}" minFractionDigits="2"/></td>
        <td class="number"><fmt:formatNumber value="${work.quantity * work.standartWork.wagesOfWorkers}" minFractionDigits="2"/></td>
        <td class="number"><fmt:formatNumber value="${work.quantity * work.standartWork.includingWagesOfMachinists}" minFractionDigits="2"/></td>
        <td class="number">${work.standartWork.percent}%</td>
        <td class="number"><fmt:formatNumber  value="${work.machinistsQuantity}" minFractionDigits="2"/></td>
        <td class="number"><fmt:formatNumber value="${work.machinistsTotalQuantity}" minFractionDigits="2"/></td>
    </tr>
    <%-- <tr>
        <td colspan="10">
            <table border="1" width="100%">
                <thead>
                    <tr>
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
                <c:forEach var="resource" items="${work.resources}">
                    <tr>
                        <td>${resource.standartWorkResource.code}</td>
                        <td>${resource.standartWorkResource.name}</td>
                        <td>${resource.standartWorkResource.unitId}</td>
                        <td>
                            <c:set var="resQuantity" value="${resource.quantity}"/>
                            <fmt:formatNumber value="${resQuantity}" minFractionDigits="2"/>
                        </td>
                        <td><fmt:formatNumber value="${resource.quantity * work.quantity}" minFractionDigits="2"/></td>
                        <td><fmt:formatNumber value="${resource.cost}" minFractionDigits="2"/></td>
                        <td><fmt:formatNumber value="${resource.totalCost}" minFractionDigits="2"/></td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr> --%>
</c:forEach>
</tbody>
</table>