package com.ipartek.formacion.supermercado.accesodatos;

import java.math.BigDecimal;
import java.util.TreeMap;

import com.ipartek.formacion.supermercado.modelos.Producto;
import com.ipartek.formacion.supermercado.modelos.Usuario;
import com.ipartek.formacion.supermercado.modelos.Usuario;

public class UsuarioDaoTreeMap implements Dao<Usuario>{
	
	private static TreeMap<Long, Usuario> usuarios = new TreeMap<>();
	
	static {
		usuarios.put(1L, new Usuario(1L, "pepito@perez.com", "qwerty"));
		usuarios.put(2L, new Usuario(2L, "perico@delospalotes.com", "qwerty"));

	}

	// SINGLETON

	private UsuarioDaoTreeMap() {
	}

	private static UsuarioDaoTreeMap INSTANCIA = new UsuarioDaoTreeMap();

	public static UsuarioDaoTreeMap getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON

	@Override
	public Iterable<Usuario> obtenerTodos() {
		return usuarios.values();
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		return usuarios.get(id);
	}

	@Override
	public void crear(Usuario producto) {
		Long id = usuarios.size() == 0 ? 1L : usuarios.lastKey() + 1L;
		producto.setId(id);
		usuarios.put(id, producto);
	}

	@Override
	public void modificar(Usuario producto) {
		usuarios.put(producto.getId(), producto);
	}

	@Override
	public void eliminar(Long id) {
		usuarios.remove(id);
	}


}
