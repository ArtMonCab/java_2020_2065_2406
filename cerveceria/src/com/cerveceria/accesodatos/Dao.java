package com.cerveceria.accesodatos;

public interface Dao<T> {
	Iterable<T> buscarTodas();
	
	T buscarPorId(Long id);
	
	void crear(T objeto);
	void modificar(T objeto);
	void eliminar(Long id);
	
	}

