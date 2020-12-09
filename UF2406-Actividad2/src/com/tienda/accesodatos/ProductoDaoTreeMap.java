package com.tienda.accesodatos;

import java.math.BigDecimal;
import java.util.TreeMap;

import org.apache.commons.lang3.SerializationUtils;

import com.tienda.modelos.Producto;

public class ProductoDaoTreeMap implements Dao<Producto>{
	
	private static TreeMap<Long, Producto> productos = new TreeMap<>();
	
	static {
		
		for (Long id = 1L; id <= 7L; id++) {
			productos.put(id, new Producto(id, "Producto " + id, new BigDecimal(10.34 * id), 0, new BigDecimal(0)));
			
		}
		
	}

	// SINGLETON


	private ProductoDaoTreeMap() {
	}

	private static ProductoDaoTreeMap INSTANCIA = new ProductoDaoTreeMap();

	
	public static ProductoDaoTreeMap getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		return productos.values();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return SerializationUtils.clone(productos.get(id));
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
	public void eliminar(Long id) {
		productos.remove(id);
		
	}

}
