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
	href="F/css/reset.css">

<title>Criação Usuário</title>
</head>
<body>
	<div class="container flex-column-center">
        <div class="flex-column-center mt-40">
            <img src="${pageContext.request.contextPath}/imagens/icone-logo.svg" id="img-logo-principal" alt="">
            <div class="flex font-title">
                <h1 class="title">FINTECH</h1>
            </div>
        </div>
		<div class="card-container flex-column-center w-90 border-radius-10 py-20 box-shadow mt-10">

			<form action="" method="post" class="flex-column-center">

                <div class="w-100">
                    <input
                            class="input w-100"
                            type="text" id="nome"
                            name="nome"
                            placeholder="Nome Completo"
                    />
                    <span class="error">${erros.nome}</span>
                </div>

                <div class="w-100" >
                    <input
                            class="input w-100"
                            type="email"
                            id="email"
                            name="email"
                            placeholder="E-mail"
                            required
                    />
                    <span class="error">${erros.email}</span>
                </div>


                <div class="flex space-between w-100 gap-10">
                    <input
                            class="input"
                            type="date"
                            id="data_nascimento"
                            name="dataNasc"
                            placeholder="Data Nascimento"
                            required
                    />


                    <select class="input" id="sexo" name="sexo">
                        <option value="sexo">Gênero</option>
                        <option value="masculino">Masculino</option>
                        <option value="feminino">Feminino</option>
                    </select>

                </div>
                <span class="error">${erros.dataNasc}</span>
                <span class="error">${erros.sexo}</span>
                <div class="w-100">
                    <input
                            class="input w-100"
                            type="password"
                            id="senha"
                            name="senha"
                            placeholder="Senha"
                            required
                    />
                    <span class="error">${erros.senha}</span>
                </div>

                <input
					class="button" type="submit" value="Registrar"
                />
			</form>
		</div>
	</div>
    <script>
        function enviarFoto() {
            var formFoto = document.getElementById('formFoto');
            var formDataFoto = new FormData(formFoto);

            var formUsuario = document.querySelector('.flex-column-center');
            var formDataUsuario = new FormData(formUsuario);

            for (var [key, value] of formDataUsuario.entries()) {
                formDataFoto.append(key, value);
            }
        }
    </script>
</body>
</html>