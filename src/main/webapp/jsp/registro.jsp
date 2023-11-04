<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/pagina1.css">
	<link rel="stylesheet" type="text/css" href="/projeto-fintech-final/css/pagina1.css">
	
	<title>Criação Usuário</title>
</head>
<body>
	<div class="foto">
		<!-- Campo de Foto -->
		<label for="foto">Foto:</label> <input type="text" id="foto"
			name="foto" /> <span class="error" id="foto-error"> <c:out
				value="${erros['foto']}" />
		</span> <br />
	</div>

	<section class="nome">
	<form action="/projeto-fintech-final/cria-usuario" method="post">
		<!-- Campo de Nome -->
		<label for="nome">Nome:</label> <input type="text" id="nome"
			name="nome" /> <span class="error" id="nome-error"> <c:out
				value="${erros['nome']}" />
		</span>
	</form>
	</section>

	<section>
		<div class="dt_nasc">
		<!-- Campo de Data de Nascimento -->
		<label for="dataNasc">Data de Nascimento:</label> <input type="text"
			id="dataNasc" name="dataNasc" /> <span class="error"
			id="dataNasc-error"> <c:out value="${erros['dataNasc']}" />
		</span> <br />
		</div>

		<div class="sexo">
		<!-- Campo de Sexo -->
		<label for="sexo">Sexo:</label> <input type="text" id="sexo"
			name="sexo" /> <span class="error" id="sexo-error"> <c:out
				value="${erros['sexo']}" />
		</span> <br />
		</div>
	</section>

	<section>
		<!-- Campo de Email -->
		<label for="email">Email:</label> <input type="text" id="email"
			name="email" /> <span class="error" id="email-error"> <c:out
				value="${erros['email']}" />
		</span> <br />
	</section>

	<section>
		<!-- Campo de Senha -->
		<label for="senha">Senha:</label> <input type="password" id="senha"
			name="senha" /> <span class="error" id="senha-error"> <c:out
				value="${erros['senha']}" />
		</span> <br />
	</form>
		</section>


</body>
</html>
