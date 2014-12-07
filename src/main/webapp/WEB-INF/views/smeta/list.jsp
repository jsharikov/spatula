<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h4>Список смет</h4>
<hr class="title">
<div class="toolbar">
    <a href='<c:url value="/smeta/create"/>' class="btn btn-default">Добавить</a>
    <a href='<c:url value="/smeta/import"/>' class="btn btn-default">Импорт</a>
</div>
<table class="table" border="1">
    <thead>
        <tr>
            <th>Идентификатор</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="smeta" items="${smetaList}">
            <tr>
                <td>${smeta.id}</td>
                <td class="center">
                    <c:url var="editUrl" value="/smeta/${smeta.id}"/>
                    <a class="btn btn-info btn-sm" href="${editUrl}">
                        <i class="glyphicon glyphicon-edit icon-white"></i>
                        Ред.
                    </a>
                    <!-- <a class="btn btn-danger btn-sm" href="#">
                        <i class="glyphicon glyphicon-trash icon-white"></i>
                        Delete
                    </a> -->
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>