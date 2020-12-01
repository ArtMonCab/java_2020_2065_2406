package com.ipartek.formacion.supermercado.accesodatos;

public interface Dao<T> {
	
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	
	void crear (T objetos);
	void modificar(T objeto);
	void eliminar(long id);

}
