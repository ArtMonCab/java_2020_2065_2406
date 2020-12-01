package com.ipartek.formacion.supermercado.accesodatos;

import java.util.TreeMap;

import com.ipartek.formacion.supermercado.modelos.Producto;

public class ProductoDaoFreeMap implements Dao<Producto>{
	
	private static TreeMap<Long, Producto> productos = new TreeMap<>();
	
	//SINGLETON
	//Ponemos privado el contructor por defecto para que nadie pueda crear instancias de esta clase de forma libre
	//Con esto evitamos la posibilidad de que nadie haga new de esta clase(Salvo la clase en si misma);
	private ProductoDaoFreeMap() {}
	
	//Creamos el único objeto que va a existir de este tipo
	private static ProductoDaoFreeMap INSTANCIA = new ProductoDaoFreeMap();
	
	//Creamos un método publico que de acceso a la única instancia disponible
	//Desde otras clases deberemos hacer: 
	//ProductoDaoTreeMap dao = ProductoDaoTreeMap.getInstancia();
	//o mejor
	// Dao<Producto> dao = ProductoDaoTreeMap.getInstancia();
	public static ProductoDaoFreeMap getInstancia(){
		return INSTANCIA;
	}
	
	//FIN DE SINGLETON
	

	@Override
	public Iterable<Producto> obtenerTodos() {
		return productos.values();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return productos.get(id);
	}

	@Override
	public void crear(Producto producto) {
		Long id = productos.size() == 0 ? 1L : productos.lastKey() + 1L;
		producto.setId(id);
		productos.put(id, producto);
	}

	@Override
	public void modificar(Producto producto) {
		productos.put(producto.getId(), producto);
		
	}

	@Override
	public void eliminar(long id) {
		productos.remove(id);
	}

}
