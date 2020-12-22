package com.ipartek.formacion.supermercado.controladores;

import com.ipartek.formacion.supermercado.accesodatos.Dao;
import com.ipartek.formacion.supermercado.accesodatos.ProductoDaoTreeMap;
import com.ipartek.formacion.supermercado.accesodatos.UsuarioDaoMySql;
import com.ipartek.formacion.supermercado.accesodatos.DaoUsuario;
import com.ipartek.formacion.supermercado.modelos.Producto;
import com.ipartek.formacion.supermercado.modelos.Usuario;

public class Configuracion {

	public static Dao<Usuario> daoUsuarios = UsuarioDaoMySql.getInstancia();
	public static Dao<Producto> daoProductos = ProductoDaoTreeMap.getInstancia();
}