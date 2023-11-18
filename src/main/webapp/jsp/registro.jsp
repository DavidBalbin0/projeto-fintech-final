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

<title>Criação Usuário</title>
</head>
<body>
	<div class="container flex-column-center">

		<div class="flex-column-center mt-40">
			<img src="/img/foto-user-2.png" alt="" class="foto-user" />
			<div>
				<button class="mt-10 button bg-verde-escuro">Upload Foto</button>
			</div>
		</div>
		<div
			class="card-container flex-column-center w-90 border-radius-10 py-20 box-shadow mt-10">
			<form action="" method="post" class="flex-column-center">
				<input class="input" type="text" id="nome" name="nome"
					placeholder="Nome Completo" /> <input class="input"
					type="email" id="email" name="email" placeholder="E-mail" required />
				<div class="flex space-between w-100 gap-10">
					<input class="input" type="date" id="data_nascimento"
						name="data_nascimento" placeholder="Data Nascimento" required />
					<select class="input">
						<option value="sexo">Gênero</option>
						<option value="masculino">Masculino</option>
						<option value="feminino">Feminino</option>
					</select>
				</div>
				<input class="input" type="password" id="senha" name="senha"
					placeholder="Senha" required /> <input class="input"
					type="password" id="confirmar_senha" name="confirmar_senha"
					placeholder="Confirmar Senha" required /> <input
					class="button" type="submit" value="Registrar" />
			</form>
		</div>
	</div>
</body>
</html>