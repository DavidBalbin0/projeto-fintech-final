CREATE TABLE usuario (
    id NUMBER DEFAULT usuario_seq.NEXTVAL PRIMARY KEY,
    foto BLOB,
    nome VARCHAR2(255) NOT NULL,
    data_nasc TIMESTAMP,
    sexo VARCHAR2(10),
    email VARCHAR2(255) UNIQUE NOT NULL,
    senha VARCHAR2(60) NOT NULL
);