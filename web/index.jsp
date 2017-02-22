<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@ taglib prefix="vi" tagdir="/WEB-INF/tags"%>
<% boolean errores = false; %>
<% Map<String, String> casos = new TreeMap(); %>
<% String mensaje = ""; %>
<%
    if(((Boolean) request.getAttribute("errores")) != null){
        errores = (Boolean) request.getAttribute("errores");
    }
%>
<%
    if (request.getAttribute("casos") != null) {
        casos = (Map<String, String>) request.getAttribute("casos");
    }
    if (errores) {
        mensaje = "Hay errores en los datos que ingresó";
        request.setAttribute("mensaje", mensaje);
    }

    if (!casos.isEmpty()) {
        for (Map.Entry<String, String> en : casos.entrySet()) {
            String key = en.getKey();
            String val = en.getValue();
            mensaje += key +": " + val +"<br>";

        }
        request.setAttribute("mensaje", mensaje);
    }
%>
<vi:layout pageTitle="Datos de viaje">
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
    <h2>Datos de los viajes</h2>
    <form name="viaje" action="Viajes" method="POST">
        <div class="row">
            <div class="col-md-2">
                <label for="elementos">Días a trabajar</label> 
                <input type="number" name="dias_trabajo" min="1" max="500" required="true" id="viaje_dias_trabajo" class="form-group form-control"/>
            </div>
        </div>
        <div class="row" id="dias_trabajo">
        </div>
        <input type="submit" name="submit" value="Enviar"
               class="btn btn-default"/>
    </form>
    <div class="panel panel-info">
        <div class="panel-heading">
            Información
        </div>
        <div class="panel-body">
            ${mensaje}    
        </div>
    </div>
</vi:layout>