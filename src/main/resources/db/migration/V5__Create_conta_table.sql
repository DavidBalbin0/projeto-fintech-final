CREATE TABLE conta
(
    id         NUMBER DEFAULT conta_seq.NEXTVAL PRIMARY KEY,
    nome       VARCHAR2(255) NOT NULL,
    saldo      NUMBER(10, 2) DEFAULT 0.0,
    usuario_id NUMBER,
    FOREIGN KEY (usuario_id) REFERENCES usuario (id)
);