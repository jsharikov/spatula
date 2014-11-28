<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h4>Шаблоны</h4>
<hr class="title">
<div class="toolbar">
	<a href='<c:url value="/documents/template/create"/>'
		class="btn btn-default">Добавить</a>
</div>
<c:if test="${not empty templates}">
	<table class="table" border="1">
		<thead>
			<tr>
				<th>№</th>
				<th>Название шаблона</th>
				<th>Шаблон</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="template" items="${templates}" varStatus="status">
				<tr>
					<td><fmt:formatNumber pattern="###000"
							value="${status.index + 1}" /></td>
					<td>${template.name}</td>
					<td>
					    <c:url value="/documents/template/show/${template.id}" var="urlOpen" />
					    <a href="${urlOpen}">${template.fileName}</a>
					</td>
					<td class="center">
                    <c:url var="editUrl" value="/documents/template/${template.id}"/>
                    <a class="btn btn-info btn-sm" href="${editUrl}">
                        <i class="glyphicon glyphicon-edit icon-white"></i>
                        Редактировать
                    </a>
                    <a class="btn btn-danger btn-sm" href="#">
                        <i class="glyphicon glyphicon-trash icon-white"></i>
                        Удалить
                    </a>
                </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>