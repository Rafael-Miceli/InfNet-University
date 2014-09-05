<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="m" tagdir="/WEB-INF/tags" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<m:master>
	<div id="interface">
		<h2>Login</h2>
		
		<form method="post" action="Login">
			<span>E-mail</span>
			<br>
			<input type="text" name="txtEmail" />
			<br>
			<br>
			<span>Senha</span>
			<br>
			<input type="password" name="txtPassword" />
			<br>
			<br>
			<input type="submit" value="Logar" />
		</form>
	</div>
</m:master>