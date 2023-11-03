package com.fintech.validacao;

public interface Validador<T> {
	void validate(T object) throws ValidadorException;
}
