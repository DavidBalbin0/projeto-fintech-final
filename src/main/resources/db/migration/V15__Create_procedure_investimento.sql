CREATE OR REPLACE PROCEDURE inserir_objetivo(
    p_descricao VARCHAR2,
    p_saldo NUMBER,
    p_data_inicio TIMESTAMP,
    p_data_final TIMESTAMP,
    p_meta NUMBER,
    p_progresso NUMBER,
    p_conta_id NUMBER,
    p_id OUT NUMBER
) AS
BEGIN
    INSERT INTO objetivo (descricao, saldo, data_inicio, data_final, meta, progresso, conta_id)
    VALUES (p_descricao, p_saldo, p_data_inicio, p_data_final, p_meta, p_progresso, p_conta_id)
    RETURNING id INTO p_id;
END;
/