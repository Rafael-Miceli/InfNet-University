<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="m" tagdir="/WEB-INF/tags" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<m:master>
	<div id="interface">
	
		<div id="DealSummary" style="width:350px; ">
			<span>Oferta: <c:out value="${DetailsModel.title}" /></span>	
			
			<br>	
			
			<span>
				<c:out value="${DetailsModel.description }" />			
			</span>
			
			<br>
			
			<span>
				Só R$<c:out value="${DetailsModel.price }" />			
			</span>
			
			<br>
			
			<span>Tempo para compra</span>
			<br>
			<span><c:out value="${DetailsModel.validation }" /></span>
			
			<br>
			
			<span>Quantos já compraram: </span>
			<span><c:out value="${DetailsModel.totalBuyed }" /></span>
			
			<br>
			
			<form method="get" action="DealPayment">
				<input type="hidden" value="${DetailsModel.id }" name="Id"/>			
				<input type="submit" value="Comprar" />
			</form>
		</div>
		
		<div id="DealImg" style="width:600px; ">
				Imagem Aqui
		
		</div>
		
		<div style="width:950px; margin-top: 30px">
		
			<div id="DealDetails" style="width:450px; margin-right: 50px; ">
				<span><c:out value="${DetailsModel.rules }" /></span>
			</div>
			
			<div id="DealRelationed" style="width:350px;">
				<c:forEach var="relationedDeal" items="${RelationedDeals}">
					<span>${relationedDeal.title}</span>
				</c:forEach>			
			
			</div>
			
		</div>
	</div>	
</m:master>