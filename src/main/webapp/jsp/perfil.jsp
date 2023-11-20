<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.Period" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

    <title>Fintech</title>
</head>

<body class="bg-verde-claro">
<header class="bg-color-branco header ">
    <nav class="nav-bar">

        <div class="tool-left">
            <img class="icon-medium" src="${pageContext.request.contextPath}/imagens/icone-logo.svg" alt="">
            <div class="ms-10">
                <h3>Olá, </h3>
                <h3>Fernando</h3>
            </div>
        </div>

        <ul class="nav-list">

            <li class="nav-item"><a href="${pageContext.request.contextPath}/restrito/home" class="nav-link">Início</a>
            </li>
            <li class="nav-item"><a href="${pageContext.request.contextPath}/restrito/objetivos" class="nav-link">Objetivos</a>
            </li>
            <li class="nav-item"><a href="${pageContext.request.contextPath}/restrito/receitas" class="nav-link">Receitas</a>
            </li>
            <li class="nav-item"><a href="${pageContext.request.contextPath}/restrito/despesas" class="nav-link">Despesas</a>
            </li>
            <li class="nav-item"><a href="${pageContext.request.contextPath}/restrito/perfil"
                                    class="nav-link">Perfil</a></li>


        </ul>

        <div class="botao-mobile-menu">
            <button id="mostrar-menu"><img src="${pageContext.request.contextPath}/imagens/icone-mobile-verde.svg"
                                           alt=""></button>
        </div>


    </nav>
    <div class="mobile-menu">
        <ul class="nav-list-mobile">
            <li class="nav-item-mobile"><a href="${pageContext.request.contextPath}/restrito/home" class="nav-link">Início</a>
            </li>
            <li class="nav-item-mobile"><a href="${pageContext.request.contextPath}/restrito/objetivos"
                                           class="nav-link">Objetivos</a></li>
            <li class="nav-item-mobile"><a href="${pageContext.request.contextPath}/restrito/receitas" class="nav-link">Receitas</a>
            </li>
            <li class="nav-item-mobile"><a href="${pageContext.request.contextPath}/restrito/despesas" class="nav-link">Despesas</a>
            </li>
            <li class="nav-item-mobile"><a href="${pageContext.request.contextPath}/restrito/perfil" class="nav-link">Perfil</a>
            </li>
        </ul>
    </div>

</header>
<section>
    <div class="flex-center">
        <div class="card-container flex-column-center w-80 mt-40 border-radius-10 py-20 box-shadow bg-color-branco">
            <div class="fw-bold title mt-10 mb-50">
                <p>Meus dados cadastrais</p>

            </div>
            <div class="flex-column-center mt-10">
                <img src="${pageContext.request.contextPath}/imagens/foto-user-2.png" alt="" class="foto-user"/>

                <div class="dados text-center">
                    <div class="item mb-10 mt-40">
                        <span class="tipo">Nome:</span> ${usuario.nome}
                    </div>
                    <div class="item mb-10">
                        <span class="tipo">Sexo:</span> ${usuario.sexo}
                    </div>

                    <div class="item mb-10">
                        <span class="tipo">Idade:</span> ${idade}
                    </div>
                    <div class="item mb-10">
                        <span class="tipo">Tipo de plano:</span> Básico
                    </div>
                </div>

                <div class="flex-column-center">
                    <div class="mt-10">
                        <form action="${pageContext.request.contextPath}/excluir-usuario" method="post">
                            <button class="button-red" type="submit">Excluir Conta</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>
<div class="flex-column-center">
    <div class="mt-40 flex-column-center">
        <button class="button" onclick="encerrarSessao()">Sair da Sessão</button>
    </div>
</div>


<script>
    document.getElementById("mostrar-menu").addEventListener('click', function () {
        var mobileMenu = document.querySelector('.mobile-menu')

        if (mobileMenu.style.display === "none") {
            mobileMenu.style.display = "flex"
        } else {
            mobileMenu.style.display = "none"
        }
    })

    function encerrarSessao() {
        fetch('${pageContext.request.contextPath}/encerrar-sessao', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: 'dummyData=example', // Pode ser qualquer dado, já que você não está enviando parâmetros neste caso
        })
            .then(response => {
                // Tratar a resposta, se necessário
                console.log('Sessão encerrada com sucesso');
                // Redirecionar para a página de login ou a página desejada após o encerramento da sessão
                window.location.href = '${pageContext.request.contextPath}/login';
            })
            .catch(error => {
                console.error('Erro ao encerrar a sessão', error);
            });
    }

</script>
</body>

</html>