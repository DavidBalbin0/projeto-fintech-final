CREATE TABLE investimento
(
    id                    NUMBER DEFAULT investimento_seq.NEXTVAL PRIMARY KEY,
    descricao             VARCHAR2(255)                NOT NULL,
    saldo                 NUMBER                       NOT NULL,
    meta                  NUMBER                       NOT NULL,
    vinculado_saldo_conta NUMBER(1)                      NOT NULL,
    conta_id              NUMBER REFERENCES conta (id) NOT NULL
);