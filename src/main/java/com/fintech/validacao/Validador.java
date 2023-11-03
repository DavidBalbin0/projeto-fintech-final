package com.fintech.validacao;

import java.util.HashMap;

public interface Validador<T> {
	void validate(T object, HashMap<String, String> erros);
	
}
