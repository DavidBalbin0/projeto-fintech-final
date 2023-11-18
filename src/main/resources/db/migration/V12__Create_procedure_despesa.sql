CREATE OR REPLACE PROCEDURE inserir_despesa(
    p_descricao VARCHAR2,
    p_categoria VARCHAR2,
    p_valor NUMBER,
    p_data TIMESTAMP,
    p_conta_id NUMBER,
    p_id OUT NUMBER
) AS
BEGIN
    INSERT INTO despesa (descricao, categoria, valor, data, conta_id)
    VALUES (p_descricao, p_categoria, p_valor, p_data, p_conta_id)
    RETURNING id INTO p_id;
END;
/