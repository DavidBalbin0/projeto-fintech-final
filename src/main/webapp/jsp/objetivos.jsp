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
				<img class="icon-medium" src="${pageContext.request.contextPath}/imagens/icone-logo.svg" alt="">
				<div class="ms-10">
					<h3>Olá,</h3>
					<h3>Fernando</h3>
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
		<div class="card-container flex-column-center w-80 mt-40 border-radius-10 py-20 box-shadow bg-color-branco">

			<form action="" method="post" class="flex-column-center">
				<input type="text" name="descricao" placeholder="Descrição" required/>
				<span class="error">${erros.descricao}</span>
				<input type="text" name="valor" placeholder="Valor" required/>
				<span class="error">${erros.saldo}</span>
				<input type="date" name="dataInicio" placeholder="Data Inicial" required/>
				<span class="error">${erros.dataInicio}</span>
				<input type="date" name="dataFinal" placeholder="Data Final" required/>
				<span class="error">${erros.dataFinal}</span>
				<input type="text" name="meta" placeholder="Meta" required/>
				<span class="error">${erros.meta}</span>

				<input class="button" type="submit" value="Adicionar Objetivo"/>
			</form>


			<h3 class="saldo fw-bold mb-10">Meus objetivos</h3>

			<table>
				<tr>
					<th>Descrição</th>
					<th>Data início</th>
					<th>Data final</th>
					<th>Valor atual</th>
					<th>Objetivo</th>
					<th>Progresso</th>
					<th>Ações</th>
				</tr>
				<c:forEach var="objetivo" items="${objetivos}">
					<tr>
						<td>${objetivo.descricao}</td>
						<td>${objetivo.dataInicio}</td>
						<td>${objetivo.dataFinal}</td>
						<td>${objetivo.saldo}</td>
						<td>${objetivo.meta}</td>
						<td>${objetivo.progresso}%</td>
						<td>
							<!-- Adicionando botão de editar -->
							<button onclick="abrirModal('${objetivo.id}', '${objetivo.descricao}', '${objetivo.saldo}', '${objetivo.dataInicio}', '${objetivo.dataFinal}', '${objetivo.meta}')">Editar</button>
						</td>
					</tr>

				</c:forEach>

				<c:if test="${empty objetivos}">
					<tr>
						<td colspan="7">
							<p>Sem objetivos cadastrados.</p>
						</td>
					</tr>
				</c:if>
<%--				<tr>--%>
<%--					<td>Carro novo</td>--%>
<%--					<td class="receita">R$1000,00</td>--%>
<%--					<td>12/12/2023</td>--%>
<%--					<td>10/12/2024</td>--%>
<%--					<td class="receita">R$25.000,00</td>--%>
<%--					<td class="gasto">R$65.000,00</td>--%>
<%--				</tr>--%>
			</table>

			<!-- Modal de Edição -->
			<div id="modalEditar" class="modal">
				<div class="modal-content">
					<div class="modal-header">
						<h2>Editar Objetivo</h2>
						<span class="modal-close" onclick="fecharModal()">&times;</span>
					</div>
					<form action="" method="post" class="flex-column-center">
						<!-- Seus campos de edição aqui -->
						<input type="hidden" id="editId" name="id"/>
						<input type="text" id="editDescricao" name="descricao" placeholder="Descrição" required/>
						<input type="text" id="editValor" name="valor" placeholder="Valor" required/>
						<input type="date" id="editDataInicio" name="dataInicio" placeholder="Data Inicial" required/>
						<input type="date" id="editDataFinal" name="dataFinal" placeholder="Data Final" required/>
						<input type="text" id="editMeta" name="meta" placeholder="Meta" required/>
						<input class="button" type="submit" value="Salvar Edições"/>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="flex-column-center">
		<div class="mt-40 flex-column-center">
			<button class="button">Cadastrar novo</button>
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

			function abrirModal(id, descricao, valor, dataInicio, dataFinal, meta) {
				// Preencher os campos do modal com os valores do objetivo
				document.getElementById("editId").value = id;
				document.getElementById("editDescricao").value = descricao;
				document.getElementById("editValor").value = valor;
				document.getElementById("editDataInicio").value = dataInicio;
				document.getElementById("editDataFinal").value = dataFinal;
				document.getElementById("editMeta").value = meta;

				// Exibir o modal
				document.getElementById("modalEditar").style.display = "block";
			}
			function fecharModal() {
				document.getElementById("modalEditar").style.display = "none";
			}
		</script>
</body>

</html>