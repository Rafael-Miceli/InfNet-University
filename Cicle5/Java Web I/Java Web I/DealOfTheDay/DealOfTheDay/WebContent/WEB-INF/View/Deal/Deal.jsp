<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="m" tagdir="/WEB-INF/tags" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<m:master>	
	<div id="interface">
		<form method="post" action="Deal">
			<div id="DealSummary" style="width:350px; ">
				<span>Oferta: </span><input type="text" name="txtTitle" value="${DealModel.title}" required="required" autofocus="autofocus"" />	
				
				<br>	
				
				<span>Descrição: </span>			
				<br>
				<input type="text" name="txtDescription" value="${DealModel.description}" required="required"/>
				
				<br>
				
				<span>Preço: R$</span><input type="text" name="txtPrice" value="${DealModel.price}" required="required" pattern="[0-9]+(\.[0-9]+)?" title="Use ponto para separar as casas decimais" />						
				
				
				<br>
				
				<span>Tempo para compra</span>
				<br>
				<input type="text" name="txtValidation" value="${DealValidation}" required="required" pattern="\d{2}\/\d{2}\/\d{4}[-]\d{2}" />dd/mm/aaaa-horas
										
			</div>
			
			<div id="DealImg" style="width:600px; ">
			
				<span>Categoria</span>
				<select name="ddlCategory">
					<c:forEach items="${Categories}" var="category">
						<option value="${category.id}" ${category.id == DealModel.category.id ? 'selected' : '' }>${category.nome}</option> -->
					</c:forEach>
					
				</select>
				
				<br>
				
				<span>Imagem</span>	
				<input type="file" name="imgDeal"/>
			
			</div>
			
			<div style="width:950px; margin-top: 30px">
			
				<span>Estado</span>
				<select name="ddlState">
					<c:forEach items="${States}" var="state">
						<option value="${state.id}" ${state.id == DealModel.state.id ? 'selected' : '' } >${state.name}</option>
					</c:forEach>  					
				</select>
				
				<br>
			
				<span>É promoção em destaque?</span>
				<input type="checkbox" name="chkIsSpotlight" value="true" ${isSpotlight.equals('true') ? 'checked' : '' } />
				<br>
				
				<span>É promoção do dia?</span>
				<input type="checkbox" name="chkIsDealOfTheDay" value="true" ${isDealOfTheDay.equals('true') ? 'checked' : '' } />
				<br>
				
				<span>Regras da promoção</span>
				<br>
				<div id="DealRules" style="width:450px; margin-right: 50px; ">
					<input type="text" name="txtRules" value="${DealModel.rules}" required="required"/>
				</div>			
				
			</div>
			
			<input type="hidden" name="idDeal" value="${DealModel.id}"/>
			
			
			<input type="submit" value="Salvar"> <input id="cancelar" type="button" value="Cancelar" > 
		</form>
	</div>
	
	<script type="text/javascript" >
		$("#cancelar").click(function(){
			window.location.href = "ListDeals";
		});
	</script>	
</m:master>
