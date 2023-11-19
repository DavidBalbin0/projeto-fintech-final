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

<title>Home</title>
</head>
<body>
<body>
    <div class="container flex-column-center ">
        <div class="flex">
            <h1 class="text-center mt-60 fw-bold color-verde-escuro fw-bold">Chegou o momento de revolucionar suas finanças.</h1>
        </div>
        <div class="flex-column-center mt-40">
            <img src="${pageContext.request.contextPath}/imagens/icone-logo.svg" id="img-logo-principal" alt="">
            <div class="flex font-title">
                <h1 class="title">FINTECH</h1>
            </div>

        </div>
        <div class="flex-column-center mt-40 ">
            <p class="text-center w-80 color-verde-escuro">
                A estrada para a mudança financeira
                começa aqui, e você já deu o passo mais importante para alcançá-la.
                
            </p>
            <p class="text-center color-verde-escuro w-80 mt-10 fw-bold">Podemos ajudá-lo a seguir em frente nessa jornada.</p>
        </div>
        <div class="flex-column-center mt-40 w-60">
            <button class="button" onclick="redirecionarParaServlet()" >Começar</button>
            <div class="mt-10">
                <a href="${pageContext.request.contextPath}/login" class="link text-verde fw-bold">Já sou cadastrado</a>
            </div>
        </div>
    </div>

    <script>
        function redirecionarParaServlet() {
            // Use a variável definida para o contexto do caminho
            window.location.href = "${pageContext.request.contextPath}/cadastro";
        }
    </script>
</body>
</body>
</html>