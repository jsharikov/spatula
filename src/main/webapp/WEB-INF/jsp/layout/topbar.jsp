<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- topbar starts -->
<div class="navbar navbar-default" role="navigation">
	<div class="navbar-inner">
		<!-- user dropdown starts -->
		<div class="btn-group pull-right">
			<button class="btn btn-default dropdown-toggle"
				data-toggle="dropdown">
				<i class="glyphicon glyphicon-user"></i><span
					class="hidden-sm hidden-xs"> admin</span> <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="#">Profile</a></li>
				<li class="divider"></li>
				<li><a href="login.html">Logout</a></li>
			</ul>
		</div>
		<!-- user dropdown ends -->
		<ul class="collapse navbar-collapse nav navbar-nav top-menu">
                <li><a href="#"><i class="glyphicon glyphicon-globe"></i> Visit Site</a></li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown"><i class="glyphicon glyphicon-star"></i> Справочники <span
                            class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <c:url var="resourcesUrl" value="/standart/resource"/>
                        <li><a href="${resourcesUrl}">Нормативная база ресурсов</a></li>
                        <c:url var="worksUrl" value="/standart/work"/>
                        <li><a href="${worksUrl}">Нормативная база работ</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown"><i class="glyphicon glyphicon-file"></i> Документы <span
                            class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <c:url var="templateUrl" value="/documents/node"/>
                        <li><a href="${templateUrl}">Разделы</a></li>
                        <c:url var="contractUrl" value="/documents/contract_template"/>
                        <li><a href="${contractUrl}">Шаблоны договоров</a></li>
                        <c:url var="contractUrl" value="/documents/contract"/>
                        <li><a href="${contractUrl}">Договора</a></li>
                    </ul>
                </li>
            </ul>
	</div>
</div>
<!-- topbar ends -->