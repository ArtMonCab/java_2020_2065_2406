package com.uf2406_actividad3.accesodatos;

import java.math.BigDecimal;
import java.util.TreeMap;

import org.apache.commons.lang3.SerializationUtils;

import com.uf2406_actividad3.modelo.Libro;

public class LibroDao implements Dao<Libro>{
	
	private static TreeMap<Long, Libro> libros = new TreeMap<>();
	

	// SINGLETON


	private LibroDao() {
	}


	private static LibroDao INSTANCIA = new LibroDao();


	public static LibroDao getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON

	@Override
	public Iterable<Libro> obtenerTodos() {

		return libros.values();
	}

	@Override
	public Libro obtenerPorId(Long id) {
		return SerializationUtils.clone(libros.get(id));
	}

	@Override
	public void crear(Libro libro) {

		Long id = libros.size() == 0 ? 1L : libros.lastKey() + 1L;
		libro.setId(id);
		libros.put(id, libro);
		
	}
	
	@Override
	public void modificar(Libro libro) {
		libros.put(libro.getId(), libro);
	}

	@Override
	public void eliminar(Long id) {
		libros.remove(id);
	}

}
