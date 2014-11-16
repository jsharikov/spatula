<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ru">
<head>
    <title>СеКо</title>
    <c:url var="bootstrapCss" value="/css/bootstrap-cerulean.min.css" />
    <link id="bs-css" href="${bootstrapCss}" rel="stylesheet">
    <c:url var="appCss" value="/css/spatula-app.css" />
    <link href="${appCss}" rel="stylesheet">
    <link href='<c:url value="/css/jquery.dataTables.css"/>' rel="stylesheet">

    <!-- jQuery -->
    <c:url var="JQueryJs" value="/js/jquery-1.11.1.min.js"/>
    <script src="${JQueryJs}"></script>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
    <!-- topbar -->
    <jsp:include page="/WEB-INF/jsp/layout/topbar.jsp" />
    <div class="ch-container">
        <div class="row">
            <jsp:include page="/WEB-INF/jsp/layout/leftmenu.jsp" />

            <div id="content" class="col-lg-10 col-sm-10">
                <!-- content starts -->
                <tiles:insertAttribute name="content"/>
                <!-- content ends -->
            </div>
            <!--/#content.col-md-0-->
        </div>
        <!--/fluid-row-->

        <hr>
        <footer class="row">
            <p class="col-md-9 col-sm-9 col-xs-12 copyright">
                &copy; <a href="#" target="_blank">СеКо</a>
                2014
            </p>

        </footer>

    </div>
    <!--/.fluid-container-->

<!-- external javascript -->
<script src='<c:url value="/js/dataTables.bootstrap.js"/>'></script>
<script src='<c:url value="/js/jquery.dataTables.min.js"/>'></script>
</body>

</html>