package com.libreriaMF0227.accesodatos;

import java.util.List;

public interface Dao<T> {
	List<T> obtenerTodos();
	T obtenerPorId(int id);
	
	boolean crear(T objeto);
	boolean eliminar(int id);
}
