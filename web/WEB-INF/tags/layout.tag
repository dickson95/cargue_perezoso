<%-- 
    Document   : layout
    Created on : 20/02/2017, 08:14:39 PM
    Author     : esteban
--%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="pageTitle" type="java.lang.String" %>
<!DOCTYPE html> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <title>${pageTitle == null ? "Cargue perezoso" : pageTitle}</title>
	</head>
	<body class="container">
	    <jsp:doBody/>
	</body>
</html>