<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib tagdir="/WEB-INF/tags/form/fields" prefix="field"%>
<%@ taglib tagdir="/WEB-INF/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>

<script>
$(document).ready(function(){
    $('input[name="machine"]').change(function() {
        if ($(this).val() == "true") {
            $('#wageOfMachinist').removeAttr("disabled");
        } else {
            $('#wageOfMachinist').attr("disabled", "disabled");
        }
    })
});
</script>

<h4>Редактирование ресурса</h4>
<hr class="title">
<form:form modelAttribute="resource" path="/standart/resource/save" cancelUrl="/standart/resource/">
    <field:hidden path="id"/>
    <field:hidden path="standart.id"/>
    <field:input label="Шифр" path="standart.code"/>
    <field:input label="Наименование" path="standart.name"/>
    <field:select label="Ед. изм." path="standart.unitId" items="${units}" itemLabel="name" itemValue="id"/>
    <field:input label="Стоимость" path="cost"/>
        <div class="form-group">
    <springform:label path="machine" class="control-label input-group">Тип ресурса</springform:label>
    <div class="radio">
        <label>
            <springform:radiobutton path="machine" value="true"/>
            Строительные машины и механизмы
        </label>
        </div>
        <div class="radio">
        <label>
            <springform:radiobutton path="machine" value="false"/>
            Строительные материалы и конструкции
        </label>
        </div>
    </div>
    <field:input label="Зарплата машиниста" path="wageOfMachinist" disabled="${!resource.machine}"/>
</form:form>


