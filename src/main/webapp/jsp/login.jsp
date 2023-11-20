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
	
	
<title>Login</title>
</head>
<body>
	 <div class="container flex-column-center mt-40">
        <div class="flex-column-center">
            <img src="${pageContext.request.contextPath}/imagens/icone-logo.svg" id="img-logo-principal" alt="">
            <div class="flex font-title">
                <h1 class="title">FINTECH</h1>
            </div>
        </div>
        <div class="card-container flex-column-center w-80 mt-40 border-radius-10 py-20 box-shadow">
            <form action="" method="post" class="flex-column-center">
                <input type="text" placeholder="E-Mail" class="input" name="email">
                <input type="password" placeholder="Senha" class="input"  name="senha">
                <div class="space-between mt-80">
                    <div class="flex-align-center"> 
                        <input type="checkbox" class="check-box">
                        <span class="fs-xsmall color-verde-escuro fw-bold">Lembrar Login</span>
                    </div>
                
                </div>

                <div class="mt-10 w-100 flex-column-center">
                    <button type="submit" class="button">Entrar</button>
                    <p class="fs-xsmall mt-10">Não tem conta? <a href="${pageContext.request.contextPath}/cadastro" class="fw-bold link color-verde-escuro">Registre-se </a></p>
                </div>
                

                <div class="flex-column-center w-100">
                    <button class="button mt-40 bg-color-azul flex-align-center flex-center">
                        <img src="${pageContext.request.contextPath}/imagens/facebook.png" alt="" class="icon-small">
                        Login com Facebook
                    </button>
                    <button class="button mt-10 bg-color-branco flex-align-center color-black flex-center">
                        <img src="${pageContext.request.contextPath}/imagens/google.png" alt="" class="icon-small">Login com Google</button>
                </div>
            </form>
        </div>

    </div>
    </div>

</body>
</html>