CREATE OR REPLACE PROCEDURE inserir_conta(
    p_nome VARCHAR2,
    p_saldo_inicial NUMBER,
    p_usuario_id NUMBER,
    p_id OUT NUMBER
) AS
BEGIN
    INSERT INTO conta (nome, saldo, usuario_id)
    VALUES (p_nome, p_saldo_inicial, p_usuario_id)
    RETURNING id INTO p_id;
END;
/