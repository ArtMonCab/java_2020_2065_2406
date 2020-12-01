package com.ipartek.formacion.supermercado.accesodatos;

public interface Dao<T> {
	
	Iterable<T> obtenerTodos();
	T obtenerPorId(long id);
	
	void crear (T objeto);
	void modificar(T objeto);
	void eliminar(long id);

}
