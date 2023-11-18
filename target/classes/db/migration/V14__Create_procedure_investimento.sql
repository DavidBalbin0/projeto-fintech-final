CREATE OR REPLACE PROCEDURE inserir_investimento(
    p_descricao VARCHAR2,
    p_meta NUMBER,
    p_conta_id NUMBER,
    p_vinculado_saldo_conta BOOLEAN,
    p_saldo NUMBER,
    p_id OUT NUMBER
) AS
BEGIN
    INSERT INTO investimento (descricao, meta, conta_id, vinculado_saldo_conta, saldo)
    VALUES (p_descricao, p_meta, p_conta_id, p_vinculado_saldo_conta, p_saldo)
    RETURNING id INTO p_id;
END;
/