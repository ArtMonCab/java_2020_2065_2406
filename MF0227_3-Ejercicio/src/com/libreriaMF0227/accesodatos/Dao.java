package com.libreriaMF0227.accesodatos;

import java.util.List;

import com.libreriaMF0227.modelos.Libro;

public interface Dao {

	List<Libro> getAll();
		
	Libro getById(int id);
	
	boolean delete(int id);
	
	boolean insert(Libro l);
	
}
