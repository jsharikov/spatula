<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@attribute name="path" required="true" type="java.lang.String" %>

<form:input type="hidden" path="${path}"/>
