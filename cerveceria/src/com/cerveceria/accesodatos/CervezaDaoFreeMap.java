package com.cerveceria.accesodatos;

import java.math.BigDecimal;
import java.util.TreeMap;

import com.cerveceria.modelos.Cerveza;
import com.ipartek.formacion.supermercado.modelos.Producto;


public class CervezaDaoFreeMap implements Dao<Cerveza>{
	
	private static TreeMap<Long, Cerveza> cervezas = new TreeMap<>();

	//Datos de prueba
	static {
		(Long id = 1L; id <= 12L; id++) {
			//cervezas.put(id, new Cerveza(id, "Producto" + id, "Descripción" + id, "foto" + id + ".jpg",
				//	new BigDecimal(11 * id), id.intValue(), "Unidad" + id, new BigDecimal(10 * id), id.intValue()));
			cervezas.put(id, new Cerveza(id,"Cerveza" + id, "Tipo" + id, "Pais" + id, "Descripción" + id,
					))
			
			/*
			 	private long id;
	private String nombre;
	private String tipo;
	private String pais;
	private String descripcion;
	private BigDecimal graduacion;
	private BigDecimal precio;
	private String envase;
	private Integer capacidadEnvase;
	private Integer unidadesCaja; 
	private String urlImagen;
	private Integer stock;
			 */
		}
		
	}
	//SINGLETON
	private CervezaDaoFreeMap() {}
	
	private static CervezaDaoFreeMap INSTANCIA = new CervezaDaoFreeMap();
	

	public static CervezaDaoFreeMap getInstancia(){
		return INSTANCIA;
	}
	
	// FIN SINGLETON
	
	@Override
	public Iterable<Cerveza> buscarTodas() {
		return cervezas.values();
	}

	@Override
	public Cerveza buscarPorId(Long id) {
		return cervezas.get(id);
	}

	@Override
	public void crear(Cerveza cerveza) {
		Long id = cervezas.size() == 0 ? 1L : cervezas.lastKey() + 1L;
		cerveza.setId(id);
		cervezas.put(id, cerveza);
	}

	@Override
	public void modificar(Cerveza cerveza) {
		cervezas.put(cerveza.getId(), cerveza);
		
	}

	@Override
	public void eliminar(Long id) {
		cervezas.remove(id);
		
	}

}
