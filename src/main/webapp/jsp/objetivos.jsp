<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nav.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;1,100;1,200&display=swap" rel="stylesheet">
    <title>Fintech</title>
</head>

<body class="bg-verde-claro">
<header class="bg-color-branco header">
    <nav class="nav-bar">

        <div class="tool-left">
            <img class="icon-medium" src="${pageContext.request.contextPath}/imagens/icone-logo.svg" alt="">
            <div class="ms-10">
                <h3>Olá,</h3>
                <h3>${nome}</h3>
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
            <button id="mostrar-menu">
                <img src="${pageContext.request.contextPath}/imagens/icone-mobile-verde.svg" alt="">
            </button>
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

<div class="flex-center">
    <div class="card-container flex-column-center w-80 mt-40 border-radius-10 py-20 box-shadow bg-color-branco">
        <h3 class="saldo fw-bold mb-10">Meus objetivos</h3>

        <c:if test="${not empty objetivos}">
            <table>

                <!-- (Cabeçalho da tabela) -->
                <tr>
                    <th>Descrição</th>
                    <th>Saldo</th>
                    <th>Data Inicio</th>
                    <th>Data Final</th>
                    <th>Meta</th>
                    <th>Progresso</th>
                </tr>
                <c:forEach var="objetivo" items="${objetivos}">
                    <tr>
                        <!-- (Colunas da tabela) -->
                        <td>${objetivo.descricao}</td>
                        <td>${objetivo.saldo}</td>
                        <td>${objetivo.dataInicio}</td>
                        <td>${objetivo.dataFinal}</td>
                        <td>${objetivo.meta}</td>
                        <td>
                            <fmt:formatNumber value="${objetivo.progresso}" type="number" maxFractionDigits="2" /> %
                        </td>

                        <td>
                            <!-- Adicionando botão de editar -->
                            <button class="button-adicionar"  onclick="abrirModal('${objetivo.id}', '${objetivo.saldo}')">
                                <img src="${pageContext.request.contextPath}/imagens/plus.png"/>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <c:if test="${empty objetivos}">
            <p>Sem objetivos cadastrados.</p>
        </c:if>
        </table>

        <!-- Modal de Edição -->
        <div id="modalEditar" class="modal">
            <div class="modal-content flex-column-center mt-10">

                <h2>Editar Objetivo</h2>
                <span class="close mb-10" onclick="fecharModal()">&times;</span>
                <form action="${pageContext.request.contextPath}/editar-objetivo" method="post"
                      class="flex-column-center">
                    <!-- Seus campos de edição aqui -->
                    <input type="hidden" id="editId" name="id"/>


                    <input class="input border-verde" type="text" id="editValor" name="valor" placeholder="Adicionar valor" required/>
                    <span class="error">${empty erros ? '' : erros.saldo}</span>

                    <input class="button" type="submit" value="Adicionar saldo"/>
                </form>
            </div>
        </div>

        <!-- Modal Cadastrar -->
        <div id="myModal" class="modal">
            <div class="modal-content flex-column-center mt-10">

                <h2>Cadastrar Objetivo</h2>
                <span class="close mb-10" id="closeModalBtn">&times;</span>

                <form action="${pageContext.request.contextPath}/restrito/objetivos" method="post"
                      class="flex-column-center">
                    <!-- Seus campos de edição aqui -->
                    <input type="hidden" id="id" name="id"/>

                    <input class="input border-verde" type="text" id="descricao" name="descricao" placeholder="Descrição" required/>
                    <span class="error">${empty erros ? '' : erros.descricao}</span>

                    <input class="input border-verde" type="text" id="valor" name="valor" placeholder="Valor" required/>
                    <span class="error">${empty erros ? '' : erros.saldo}</span>

                    <input class="input border-verde" type="date" id="dataInicio" name="dataInicio" placeholder="Data Inicial" required/>
                    <span class="error">${empty erros ? '' : erros.dataInicio}</span>

                    <input class="input border-verde" type="date" id="dataFinal" name="dataFinal" placeholder="Data Final" required/>
                    <span class="error">${empty erros ? '' : erros.dataFinal}</span>

                    <input class="input border-verde" type="text" id="meta" name="meta" placeholder="Meta" required/>
                    <span class="error">${empty erros ? '' : erros.meta}</span>

                    <input class="button" type="submit" value="Cadastrar Objetivo"/>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="flex-column-center">
    <div class="mt-40 flex-column-center">
        <button class="button" id="openModalBtn">Cadastrar novo</button>
    </div>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function () {
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
    });

    function abrirModal(id, descricao, valor) {
        // Preencher os campos do modal com os valores do objetivo
        document.getElementById("editId").value = id;
        document.getElementById("editValor").value = valor;

        // Exibir o modal
        document.getElementById("modalEditar").style.display = "block";
    }

    function fecharModal() {
        document.getElementById("modalEditar").style.display = "none";
    }
</script>
</body>
</html>