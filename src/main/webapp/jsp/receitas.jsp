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

<title>Fintech</title>
</head>

<body class="bg-verde-claro">
	<header class="bg-color-branco header ">
		<nav class="nav-bar">

			<div class="tool-left">
				<img class="icon-medium" src="/img/icone-logo.svg" alt="">
				<div class="ms-10">
					<h3>Olá,</h3>
					<h3>Fernando</h3>
				</div>
			</div>

			<ul class="nav-list">

				<li class="nav-item"><a href="#" class="nav-link">Início</a></li>
				<li class="nav-item"><a href="#" class="nav-link">Relatórios</a></li>
				<li class="nav-item"><a href="#" class="nav-link">Receitas</a></li>
				<li class="nav-item"><a href="#" class="nav-link">Despesas</a></li>
				<li class="nav-item"><a href="#" class="nav-link">Perfil</a></li>

			</ul>

			<div class="botao-mobile-menu">
				<button id="mostrar-menu">
					<img src="../img/icone-mobile-verde.svg" alt="">
				</button>
			</div>


		</nav>
		<div class="mobile-menu">
			<ul class="nav-list-mobile">
				<li class="nav-item-mobile"><a href="#" class="nav-link">Início</a></li>
				<li class="nav-item-mobile"><a href="#" class="nav-link">Relatórios</a></li>
				<li class="nav-item-mobile"><a href="#" class="nav-link">Receitas</a></li>
				<li class="nav-item-mobile"><a href="#" class="nav-link">Despesas</a></li>
				<li class="nav-item-mobile"><a href="#" class="nav-link">Perfil</a></li>
			</ul>
		</div>

	</header>

	<div class="flex-center">
		<div
			class="card-container flex-column-center w-80 mt-40 border-radius-10 py-20 box-shadow bg-color-branco">
			<h3 class="saldo fw-bold mb-10">Receitas cadastradas</h3>

			<table>
				<tr>
					<th>Descrição</th>
					<th>Valor</th>
					<th>Tipo</th>
					<th>Data</th>
				</tr>
				<tr>
					<td>Salário</td>
					<td class="receita">R$ 3.000,00</td>
					<td>Fixo</td>
					<td>Todo dia 10</td>
				</tr>
				<tr>
					<td>Transferência recebida</td>
					<td class="receita">R$ 540,00</td>
					<td>Variável</td>
					<td>03/11/2023</td>
				</tr>
				</tr>
			</table>
		</div>
	</div>
	<div class="flex-column-center">
		<div class="mt-40 flex-column-center">
			<button class="button">Cadastrar novo</button>
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