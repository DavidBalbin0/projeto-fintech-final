package com.fintech.db;

import org.flywaydb.core.Flyway;

public class FlywayConfig {
    public static void configureAndMigrate() {
        System.out.println("comecando a configuracao flyway");
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:oracle:thin:@//oracle.fiap.com.br:1521/ORCL", "RM99394", "100792")
                .locations("filesystem:src/main/resources/db/migration")
                .load();
        System.out.println("configure chamado");
        flyway.migrate();
        System.out.println("migrate chamado");
    }
}
