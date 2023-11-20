<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/nav.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/reset.css">
<link rel="stylesheet"
	  href="https://fonts.googleapis.com/css2?family=Josefin+Slnavab:wght@400;600;700&family=Montserrat:wght@400;600;700&family=Roboto:wght@300;400;500&display=swap">

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

			<h3 class="saldo fw-bold mb-10">Despesas cadastradas</h3>

			<table>
				<tr>
					<th>Descrição</th>
					<th>Valor</th>
					<th>Data</th>
				</tr>
				<c:forEach var="despesa" items="${despesas}">
					<tr>
						<td>${despesa.descricao}</td>
						<td class="gasto">${despesa.valor}</td>
						<td>${despesa.data}</td>
					</tr>

				</c:forEach>
				<c:if test="${empty despesas}">
					<p>Sem despesas cadastradas.</p>
				</c:if>
<%--				<tr>--%>
<%--					<td>Financiamento auto</td>--%>
<%--					<td class="gasto">- R$ 672,00</td>--%>
<%--					<td>Fixo</td>--%>
<%--					<td>Todo dia 01</td>--%>
<%--				</tr>--%>
			</table>
		</div>
	</div>
	<div class="flex-column-center">
		<div class="container">
			<button id="openModalBtn" class="button mt-40">Cadastrar novo</button>
		</div>
	</div>
	<!-- Modal -->
	<div id="myModal" class="modal">
		<div class="modal-content flex-column-center mt-10">
			<span class="close mb-10" id="closeModalBtn">&times;</span>
			<form action="" method="post" class="flex-column-center" id="modalForm">
				<label for="descricao">Descrição:</label>
				<input class="mb-10 border-radius-5" type="text" name="descricao" id="descricao" placeholder="Descrição"
					   required />
				<span class="error">${erros.descricao}</span>

				<label for="valor">Valor:</label>
				<input class="mb-10 border-radius-5" type="text" name="valor" id="valor" placeholder="Valor" required />
				<span class="error">${erros.valor}</span>

				<label for="data">Data:</label>
				<input class="mb-10 border-radius-5" type="date" name="data" id="data" required />
				<span class="error">${erros.data}</span>

				<input class="button mt-10" type="submit" value="Adicionar" />
			</form>
		</div>
	</div>


	<script>document.addEventListener("DOMContentLoaded", function () {
		var openModalBtn = document.getElementById("openModalBtn");
		var closeModalBtn = document.getElementById("closeModalBtn");
		var modal = document.getElementById("myModal");

		openModalBtn.onclick = function () {
			modal.style.display = "block";
		};

		closeModalBtn.onclick = function () {
			modal.style.display = "none";
		};

		window.onclick = function (event) {
			if (event.target === modal) {
				modal.style.display = "none";
			}
		};
	});</script>


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

			document.addEventListener("DOMContentLoaded", function () {
				<%-- Verifica se há erros na sessão --%>
				var errors = <%= request.getAttribute("erros") %>;

				if (errors != null && Object.keys(errors).length > 0) {
					// Exibe o modal
					var modal = document.getElementById("myModal");
					modal.style.display = "block";
				}
			});
		</script>
</body>

</html>

<div></div>