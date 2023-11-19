package com.fintech.servlets;

import com.fintech.service.ContaService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static java.lang.Long.parseLong;

@WebServlet("/editar-objetivo")
public class EditarObjetivoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        // Recuperar os parâmetros do formulário
        String idStr = request.getParameter("id");
        String descricao = request.getParameter("descricao");
        String saldoStr = request.getParameter("saldo");

        // Convertendo strings para tipos apropriados (você pode precisar validar esses valores)
        long id = parseLong(idStr);
        double saldo = Double.parseDouble(saldoStr);

        ContaService contaService = new ContaService();
        contaService.adiconarSaldoAoObjetivo(id, saldo);

        // Redirecionar de volta para a página de objetivos após a edição
        response.sendRedirect(request.getContextPath() + "/restrito/objetivos");
    }
}