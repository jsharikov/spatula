<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action='<c:url value="/smeta/new" />'>
    <button class="btn btn-default">Добавить новую смету</button>
</form>
<table border="1">
    <thead>
        <tr>
            <td>ID</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="smeta" items="${smetaList}">
            <tr>
                <td><a href='<c:url value="/smeta/${smeta.id}"/>'>${smeta.id}</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>