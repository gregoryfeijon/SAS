package br.com.sas.util;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import br.com.sas.enums.Estado;

public class MetodosAuxiliares<T> {

	public static List<Estado> getEstados() {
		return Arrays.asList(Estado.values());
	}

	public static String getEstadoNome(Estado estado) {
		String nomeEstado = estado.getDescricao();
		return nomeEstado;
	}

	public static <T> Object verificaPresencaObjeto(Optional<T> entity) {
		Object[] object = new Object[1];
		entity.ifPresent(obj -> object[0] = obj);
		return object[0];
	}
}
