package com.fintech.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
@WebFilter("/restrito/*")
public class AutenticacaoFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest  = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        // Verifica se a sessão contém as informações do usuário
        if (session != null && session.getAttribute("usuarioLogado") != null) {
            // Se autenticado, permite a requisição continuar
            chain.doFilter(request, response);
        } else {
            // Se não autenticado, redireciona para a página de login
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/login.jsp");
        }

    }
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
