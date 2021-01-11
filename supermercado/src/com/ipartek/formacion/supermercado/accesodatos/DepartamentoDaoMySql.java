package com.ipartek.formacion.supermercado.accesodatos;

import java.util.HashSet;
import java.util.Set;

import com.ipartek.formacion.supermercado.modelos.Departamento;

public class DepartamentoDaoMySql implements Dao<Departamento> {

	private DepartamentoDaoMySql() {}
	
	private final static DepartamentoDaoMySql INSTANCIA = new DepartamentoDaoMySql();
	
	public static DepartamentoDaoMySql getInstancia() {
		return INSTANCIA;
	}
	
	@Override
	public Iterable<Departamento> obtenerTodos() {
		Set<Departamento> departamentos = new HashSet<Departamento>();

		departamentos.add(new Departamento(1L, "Lácteos", null));
		departamentos.add(new Departamento(2L, "Frescos", null));
		departamentos.add(new Departamento(3L, "Congelados", null));
		departamentos.add(new Departamento(4L, "Electrónica", null));
		departamentos.add(new Departamento(5L, "Navidad", null));

		return departamentos;
	}

}
