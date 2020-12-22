package com.ipartek.formacion.supermercado.accesodatos;

import java.util.TreeMap;

import com.ipartek.formacion.supermercado.modelos.Usuario;

public class UsuarioDaoTreeMap implements DaoUsuario {
	private static TreeMap<Long, Usuario> usuarios = new TreeMap<>();

	static {
		usuarios.put(1L, new Usuario(1L, "perico@delospalotes.com", "qwerty"));
		usuarios.put(2L, new Usuario(2L, "pepito@perez.com", "12345"));
	}

	// SINGLETON

	// Ponemos privado el constructor por defecto para que nadie pueda crear
	// instancias de esta clase de forma libre
	// Con esto evitamos la posibilidad de que nadie haga new de esta clase (salvo
	// esta clase en s� misma)
	private UsuarioDaoTreeMap() {
	}

	// Creamos el �nico objeto que va a existir de este tipo
	private static UsuarioDaoTreeMap INSTANCIA = new UsuarioDaoTreeMap();

	// Creamos un m�todo p�blico que de acceso a la �nica instancia disponible
	// Desde otras clases deberemos hacer
	// ProductoDaoTreeMap dao = ProductoDaoTreeMap.getInstancia();
	// o mejor
	// Dao<Producto> dao = ProductoDaoTreeMap.getInstancia();
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
	public void crear(Usuario usuario) {
		Long id = usuarios.size() == 0 ? 1L : usuarios.lastKey() + 1L;
		usuario.setId(id);
		usuarios.put(id, usuario);
	}

	@Override
	public void modificar(Usuario usuario) {
		usuarios.put(usuario.getId(), usuario);
	}

	@Override
	public void eliminar(Long id) {
		usuarios.remove(id);
	}
	
	// M�todo espec�fico de este DAO
	
	public Usuario obtenerPorEmail(String email) {
		for(Usuario usuario: usuarios.values()) {
			if(usuario.getEmail().equals(email)) {
				return usuario;
			}
		}
		
		return null;
	}
	
//	public Usuario obtenerPorEmail(String email) {
//		Usuario resultado = null;
//		
//		for(Usuario usuario: usuarios.values()) {
//			if(usuario.getEmail().equals(email)) {
//				resultado = usuario;
//				break;
//			}
//		}
//		
//		return resultado;
//	}
}
