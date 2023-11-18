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
          <h3>Olá, </h3>
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
        <button id="mostrar-menu"><img src="../img/icone-mobile-verde.svg" alt=""></button>
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
  <section>
    <div class="flex-center">
      <div class="card-container flex-column-center w-80 mt-40 border-radius-10 py-20 box-shadow bg-color-branco">
        <div class="fw-bold title mt-10 mb-50">
          <p>Meus dados cadastrais</p>

        </div>
        <div class="flex-column-center mt-10">
          <img src="/img/foto-user-2.png" alt="" class="foto-user" />

          <div class="dados text-center">
            <div class="item mb-10 mt-40">
              <span class="tipo">Nome:</span> Fernando Ortriwano
            </div>
            <div class="item mb-10">
              <span class="tipo">Sexo:</span> Masculino
            </div>
            <div class="item mb-10">
              <span class="tipo">Idade:</span> 30 anos
            </div>
            <div class="item mb-10">
              <span class="tipo">Profissão:</span> Desenvolvedor de Sistemas
            </div>
            <div class="item mb-10">
              <span class="tipo">Cadastro:</span> 10/11/2023
            </div>
            <div class="item mb-10">
              <span class="tipo">Tipo de plano:</span> Básico
            </div>
          </div>

          <div class="flex-column-center">
            <div class="mt-10 flex-column-center">
              <button class="button-red">Excluir Conta</button>
            </div>
          </div>
  </section>
  <div class="flex-column-center">
    <div class="mt-40 flex-column-center">
      <button class="button">Sair da Sessão</button>
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

    </script>
</body>

</html>