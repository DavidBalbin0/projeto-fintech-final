CREATE OR REPLACE PROCEDURE inserir_usuario(
    p_foto BLOB,
    p_nome VARCHAR2,
    p_data_nasc TIMESTAMP,
    p_sexo VARCHAR2,
    p_email VARCHAR2,
    p_senha VARCHAR2,
    p_id OUT NUMBER
) AS
BEGIN
    INSERT INTO usuario (foto, nome, data_nasc, sexo, email, senha)
    VALUES (p_foto, p_nome, p_data_nasc, p_sexo, p_email, p_senha)
    RETURNING id INTO p_id;
END;
/