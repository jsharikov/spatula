<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib tagdir="/WEB-INF/tags/form/fields" prefix="field"%>
<%@ taglib tagdir="/WEB-INF/tags/form" prefix="form"%>

<script>
function removeResource(index) {
	$('<input>').attr({
	    type: 'hidden',
	    name: 'removedResourceIndex',
	    value : index
	}).appendTo('#work');
}
$(document).ready(function(){
	$('table select').change(function() {
		$('#addResourceBtn').val("GET_RESOURCE_INFO");
		$('#addResourceBtn').click();
	});
	document.getElementById( 'addResourceBtn' ).scrollIntoView();
});
</script>

<h4>Создание работы</h4>
<hr class="title">
<form:form modelAttribute="work" path="/standart/work/save" cancelUrl="/standart/work/">
    <field:input label="Шифр" path="standart.code"/>
    <field:input label="Наименование" path="standart.name"/>
    <field:select label="Ед. изм." path="standart.unitId" items="${units}" itemLabel="name" itemValue="id"/>
    <field:select label="Тип работы" path="workTypeId" items="${workTypes}" itemLabel="name" itemValue="id"/>
    
    <field:input label="Накладные расходы (%)" path="percent"/>
    <field:input label="ЗП рабочих-строителей" path="wagesOfWorkers"/>
    <field:input label="Экспл. машин" path="operMachinesCost"/>
    <field:input label="в т.ч. ЗП машинистов " path="includingWagesOfMachinists"/>
    <field:input label="Стоимость" path="totalCost"/>
    <table class="table">
        <thead>
            <tr>
                <th class="col-md-2">Шифр</th>
                <th class="col-md-5">Наименование</th>
                <th class="col-md-2">Ед. изм.</th>
                <th class="col-md-1">Количество</th>
                <th class="col-md-1">Стоимость</th>
                <th class="col-md-1"></th>
            </tr>
        </thead>
        <c:forEach var="resourceWork" items="${work.resources}" varStatus="status">
            <tbody>
                <tr>
                    <td><field:input path="resources[${status.index}].resource.standart.code" readonly="true"/></td>
                    <td>
                        <field:hidden path="resources[${status.index}].resourceId"/>
                        <field:select items="${standarts}" itemLabel="name" path="resources[${status.index}].resource.standartId" itemValue="id"/>
                    </td>
                    <td>
                        <field:select items="${units}" itemLabel="name" path="resources[${status.index}].resource.standart.unitId" itemValue="id" disabled="true"/>
                    </td>
                    <td><field:input path="resources[${status.index}].quantity"/></td>
                    <td><field:input path="resources[${status.index}].resource.cost" readonly="${work.resources[status.index].resource.machine != null && work.resources[status.index].resource.machine }"/></td>
                    <td>
                        <%-- <input type="hidden" name="removedResourceIndex" value="${status.index}"/> --%>
                        <button class="btn btn-danger" name="sbmt" value="REMOVE_RESOURCE" onclick="removeResource(${status.index})">
                        <i class="glyphicon glyphicon-trash icon-white"></i>
                        Удалить
                    </button>
                    </td>
                </tr>
            </tbody>
        </c:forEach>
    </table>
    <div>
        <button id="addResourceBtn" class="btn btn-default" type="submit" name="sbmt" value="ADD_RESOURCE">Добавить ресурс</button>
    </div>
    <br/>
    <%-- <div class="col-md-12">
        <div class="col-md-3">
            <field:input label="Стоимость" path="totalCost"/>
        </div>
        <div class="col-md-3">
            <field:input label="ЗП рабочих-строителей" path="wagesOfWorkers"/>
        </div>
        <div class="col-md-3">
            <field:input label="Экспл. машин" path="operMachinesCost" readonly="true"/>
        </div>
        <div class="col-md-3">
            <field:input label="в т.ч. ЗП машинистов " path="includingWagesOfMachinists" readonly="false"/>
        </div>
    </div> --%>
</form:form>


