<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="m" tagdir="/WEB-INF/tags" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<m:master>    

	<!-- Colocar a busca e o select de estados por aqui -->

    <!-- Header -->

	<form id="formState" method="post" action="Home.go">
		<span>Estado</span>
		<select name="ddlState" id="ddlState">
			<option value="0">Todos...</option>
			<c:forEach items="${States}" var="state">
				<option value="${state.id}" ${state.id == StateId ? 'selected' : '' } >${state.name}</option>
			</c:forEach>
		</select>
	</form>
	
    <header class="cabecalho">
        <h1>Compras via web</h1>
    </header>
    
    <!-- Menu -->

    <nav class="menu">
        <div class="container">
            <ul>
            	<c:forEach var="category" items="${Categories}">
            		<c:url value="Home.go" var="urlHome">
						<c:param name="Id" value="${category.id}" />
					</c:url>
					
            		<li><a href="${urlHome}"><c:out value="${category.nome}" /></a></li>
            	</c:forEach>                
            </ul>
        </div>
    </nav>
    
    <div id="interface">
		
		<c:forEach var="spotlight" items="${SpotLightDeal}">
			<c:url value="DealDetails" var="urlDealDetail">
				<c:param name="Id" value="${spotlight.id}" />
			</c:url>
					
			<a href="${urlDealDetail}" > ${spotlight.title} </a>
			<br>				
		</c:forEach>				
		
	</div>
	
	<script type="text/javascript">
		$("#ddlState").change(function() {
			$("#formState").submit();
			
			var id = $( "select option:selected" ).val();
			
			
		});
	</script>
</m:master>
