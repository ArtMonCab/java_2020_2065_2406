package com.libreriaMF0227.accesodatos;

import java.util.List;

import com.libreriaMF0227.modelos.Libro;

public interface Dao<T> {


	Iterable<T> getAll();

	T getById(int id);

	boolean delete(int id);

	boolean insert(T objeto);
	void modify(T objeto);
	
}


