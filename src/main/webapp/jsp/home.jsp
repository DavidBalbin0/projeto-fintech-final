<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/pagina1.css">
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/nav.css">
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/reset.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200&display=swap" rel="stylesheet">

	<title>Fintech</title>
</head>

<body class="bg-verde-claro">
	<header class="bg-color-branco header ">
		<nav class="nav-bar">

			<div class="tool-left">
				<img class="icon-medium" src="${pageContext.request.contextPath}/imagens/icone-logo.svg" alt="">
				<div class="ms-10">
					<h3>Olá,</h3>
					<h3>${nome}</h3>
				</div>
			</div>

			<ul class="nav-list">

				<li class="nav-item"><a href="${pageContext.request.contextPath}/restrito/home" class="nav-link">Início</a></li>
				<li class="nav-item"><a href="${pageContext.request.contextPath}/restrito/objetivos" class="nav-link">Objetivos</a></li>
				<li class="nav-item"><a href="${pageContext.request.contextPath}/restrito/receitas" class="nav-link">Receitas</a></li>
				<li class="nav-item"><a href="${pageContext.request.contextPath}/restrito/despesas" class="nav-link">Despesas</a></li>
				<li class="nav-item"><a href="${pageContext.request.contextPath}/restrito/perfil" class="nav-link">Perfil</a></li>

			</ul>

			<div class="botao-mobile-menu">
				<button id="mostrar-menu">
					<img src="${pageContext.request.contextPath}/imagens/icone-mobile-verde.svg" alt="">
				</button>
			</div>


		</nav>
		<div class="mobile-menu">
			<ul class="nav-list-mobile">
				<li class="nav-item-mobile"><a href="${pageContext.request.contextPath}/restrito/home" class="nav-link">Início</a></li>
				<li class="nav-item-mobile"><a href="${pageContext.request.contextPath}/restrito/objetivos" class="nav-link">Objetivos</a></li>
				<li class="nav-item-mobile"><a href="${pageContext.request.contextPath}/restrito/receitas" class="nav-link">Receitas</a></li>
				<li class="nav-item-mobile"><a href="${pageContext.request.contextPath}/restrito/despesas" class="nav-link">Despesas</a></li>
				<li class="nav-item-mobile"><a href="${pageContext.request.contextPath}/restrito/perfil" class="nav-link">Perfil</a></li>
			</ul>
		</div>

	</header>

	<div class="flex-center">
		<div
			class="card-container flex-column-center w-80 mt-40 border-radius-10 py-20 box-shadow bg-color-branco">
			<h3 class="saldo fw-bold mb-10">Seu saldo atual é de:</h3>
			<h3 class="saldo mb-10">R$${saldo}</h3>
			<h2>Resumo Financeiro (últimos 10 dias)</h2>

			<table>
				<tr>
					<th>Descrição</th>
					<th>Valor</th>
					<th>Data</th>
				</tr>
				<c:forEach var="transacao" items="${transacoes}">
					<tr>
						<td>${transacao.descricao}</td>
						<td class="${transacao.valor >= 0 ? 'receita' : 'gasto'}">${transacao.valor}</td>
						<td>${transacao.data}</td>
					</tr>

				</c:forEach>

<%--				<tr>--%>
<%--					<td>Financiamento auto</td>--%>
<%--					<td class="gasto">- R$ 672,00</td>--%>
<%--					<td>01/11/2023</td>--%>
<%--				</tr>--%>
			</table>
		</div>
	</div>
	<div class="flex-column-center">
		<div class="mt-40 flex-column-center">
			<button class="button">Mais informações</button>
		</div>
	</div>

		<script>
			document.getElementById("mostrar-menu").addEventListener('click',
					function() {
						var mobileMenu = document.querySelector('.mobile-menu')

						if (mobileMenu.style.display === "none") {
							mobileMenu.style.display = "flex"
						} else {
							mobileMenu.style.display = "none"
						}
					})
		</script>
</body>

</html>

<div></div>