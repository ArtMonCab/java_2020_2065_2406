package com.uf2406_actividad3.accesodatos;

public interface Dao<T> {
	Iterable<T> obtenerTodos();
	
	T obtenerPorId(Long id);
	
	void crear(T objeto);
}
