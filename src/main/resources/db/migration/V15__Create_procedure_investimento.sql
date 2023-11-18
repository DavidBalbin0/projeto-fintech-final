CREATE OR REPLACE PROCEDURE inserir_investimento(
    p_descricao             VARCHAR2,
    p_saldo                 NUMBER,
    p_meta                  NUMBER,
    p_vinculado_saldo_conta NUMBER, -- Alteração aqui para utilizar NUMBER
    p_conta_id              NUMBER,
    p_id                    OUT NUMBER
) AS
BEGIN
    INSERT INTO investimento (descricao,saldo, meta,vinculado_saldo_conta, conta_id)
    VALUES (p_descricao, p_saldo, p_meta, p_vinculado_saldo_conta, p_conta_id)
    RETURNING id INTO p_id;

    COMMIT; -- Adicione um COMMIT se desejar confirmar a transação.
EXCEPTION
    WHEN OTHERS THEN
        -- Tratamento de erros, por exemplo:
        -- DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM);
        ROLLBACK; -- Adicione um ROLLBACK em caso de erro.
END;
/