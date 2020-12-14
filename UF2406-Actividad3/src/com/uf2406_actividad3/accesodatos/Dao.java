package com.uf2406_actividad3.accesodatos;

public interface Dao<T> {
	Iterable<T> obtenerTodos();
	
	T obtenerPorId(Long id);
	void modificar(T objeto);
	void crear(T objeto);
	void eliminar(Long id);
}
