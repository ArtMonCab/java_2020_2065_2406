package com.libreriaMF0227.accesodatos;

import java.util.TreeMap;


import com.libreriaMF0227.modelos.Usuario;

public class UsuarioDao implements Dao<Usuario>{
	
	private static TreeMap<Long, Usuario> usuarios = new TreeMap<>();
	
	static {
		usuarios.put(1L, new Usuario(1L, "administrador", "123456"));
	}

	// SINGLETON


	private UsuarioDao() {
	}

	private static UsuarioDao INSTANCIA = new UsuarioDao();


	public static UsuarioDao getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON
	
	@Override
	public Iterable<Usuario> getAll() {
		return usuarios.values();
	}

	@Override
	public Usuario getById(int id) {
		return usuarios.get(id);
	}

	@Override
	public boolean delete(int id) {
		usuarios.remove(id);
		return true;
	}

	@Override
	public boolean insert(Usuario usuario) {
		Long id = usuarios.size() == 0 ? 1L : usuarios.lastKey() + 1L;
		usuario.setId(id);
		usuarios.put(id, usuario);
		return true;
	}
	
	public Usuario obtenerPorNombre(String nombre) {
		for(Usuario usuario: usuarios.values()) {
			if(usuario.getNombre().equals(nombre)) {
				return usuario;
			}
		}
		
		return null;
	}

}
