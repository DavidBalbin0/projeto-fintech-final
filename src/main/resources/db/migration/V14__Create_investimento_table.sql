CREATE TABLE objetivo
(
    id          NUMBER DEFAULT objetivo_seq.NEXTVAL PRIMARY KEY,
    descricao   VARCHAR2(255)                NOT NULL,
    saldo       NUMBER                       NOT NULL,
    data_inicio TIMESTAMP                    NOT NULL,
    data_final  TIMESTAMP                    NOT NULL,
    meta        NUMBER                       NOT NULL,
    progresso   NUMBER                       NOT NULL,
    conta_id    NUMBER REFERENCES conta (id) NOT NULL
);