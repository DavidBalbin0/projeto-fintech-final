CREATE TABLE despesa
(
    id        NUMBER DEFAULT despesa_seq.NEXTVAL PRIMARY KEY,
    descricao VARCHAR2(255)                NOT NULL,
    valor     NUMBER                       NOT NULL,
    data      TIMESTAMP                    NOT NULL,
    conta_id  NUMBER REFERENCES conta (id) NOT NULL
);