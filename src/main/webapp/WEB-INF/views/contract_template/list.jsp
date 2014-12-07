<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h4>Шаблоны договоров</h4>
<hr class="title">
<div class="toolbar">
	<a href='<c:url value="/documents/contract_template/create"/>'
		class="btn btn-default">Добавить</a>
</div>
<c:if test="${not empty contractTemplate}">
	<table class="table" border="1">
		<thead>
			<tr>
				<th>№</th>
				<th>Название шаблона договора</th>
				<th>Шаблон договора</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="contractTemp" items="${contractTemplate}" varStatus="status">
				<tr>
					<td><fmt:formatNumber pattern="###000"
							value="${status.index + 1}" /></td>
					<td>${contractTemp.name}</td>
					<td>
					    <c:url value="/documents/contract_template/show/${contractTemp.id}" var="urlOpen" />
					    <a href="${urlOpen}" >${contractTemp.name}.docx</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>