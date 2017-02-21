<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="vi" tagdir="/WEB-INF/tags"%>
<vi:layout pageTitle="Datos de viaje"></vi:layout>

<h2>Datos de los viajes</h2>
<h3><%= (String) request.getAttribute("dias") %></h3>
<form name="viaje" action="Viajes" method="POST">
	<div class="form-group">
		<label for="dias_trabajo">Días a trabajar</label> <input type="number"
			name="dias_trabajo" min="0" max="500" id="viaje_dias_trabajo"
			class="form-control" />
	</div>
	<input type="submit" name="submit" value="Enviar"
		class="btn btn-default"/>
</form>
