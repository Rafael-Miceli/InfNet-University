<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="m" tagdir="/WEB-INF/tags" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<m:master>
	<div id="interface">
		<form method="post" action="Register">
			<span>Nome</span>
			<br>
			<input type="text" name="txtName" />
			<br>
			<br>
			<span>Sobrenome</span>
			<br>
			<input type="text" name="txtLastName" />
			<br>
			<br>
			<span>Data de nacimento</span>
			<br>
			<input type="text" name="txtBirth" />
			<br>
			<br>
			<span>Estado</span>
			<br>
			<select name="ddlState">
				<c:forEach var="state" items="${states}">
					<option value="${state.id}">${state.name}</option>			
				</c:forEach>
			</select>
			<br>
			<br>
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
			<span>Confirmar Senha</span>
			<br>
			<input type="password" name="txtConfirmPassword" />
			<br>
			<br>
			<input type="submit" value="Cadastrar" /> <input type="button" value="Cancelar" />
		</form>
	</div>
</m:master>
	