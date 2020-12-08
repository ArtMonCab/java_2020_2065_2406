package com.tienda.accesodatos;

import java.math.BigDecimal;
import java.util.TreeMap;

import com.tienda.modelos.Producto;

public class ProductoDaoTreeMap implements Dao<Producto>{
	
	private static TreeMap<Long, Producto> productos = new TreeMap<>();
	
	static {


		//Producto(long id, String nombre, BigDecimal precio, int unidades)
		productos.put(1L, new Producto(1L,"Nombre", new BigDecimal("23,76"), 0));
		
		for (Long id = 1L; id <= 12L; id++) {
			productos.put(id, new Producto(id, "Nombre + id, "Descripción" + id, "http://placeimg.com/640/480/tech?" + id,
					new BigDecimal(11 * id), id.intValue(), "Unidad" + id, new BigDecimal(10 * id), id.intValue()));
		}
		
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crear(Producto objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Producto objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
