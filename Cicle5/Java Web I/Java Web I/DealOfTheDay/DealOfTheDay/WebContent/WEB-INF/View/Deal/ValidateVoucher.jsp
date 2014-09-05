<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="m" tagdir="/WEB-INF/tags" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<m:master>	
	<div id="interface">
		<form method="post" action="ValidateVoucher">
			<span>Código do voucher</span>
			<br>
			<input type="text" name="txtVoucherCode" />
			<input type="submit" value="Validar" />
		</form>
		
		<br>
		<h2 style="color: red">${VoucherMessage}</h2>
	</div>
</m:master>