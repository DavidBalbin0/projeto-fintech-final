//package com.fintech.servlets;
//
//import com.fintech.db.FlywayConfig;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//@WebListener
//public class FlywayInitializer implements ServletContextListener {
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        System.out.println("Aplicação Inicializada. Iniciando Flyway...");
//
//        // Configurar e migrar o banco de dados usando Flyway
//        FlywayConfig.configureAndMigrate();
//
//        System.out.println("Flyway inicializado com sucesso.");
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        // Este método é chamado quando a aplicação é encerrada.
//        // Você pode adicionar código de limpeza aqui, se necessário.
//    }
//}
