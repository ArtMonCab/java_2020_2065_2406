package com.libreriaMF0227.accesodatos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


import com.libreriaMF0227.modelos.Libro;

public class LibroDao implements Dao{
	
	private HashMap<Integer, Libro> hmLibros = new HashMap<Integer, Libro>();
	
	private int indice = 0;
	private static LibroDao INSTANCE = null;
	
	
	public LibroDao() {
		hmLibros.put(1, new Libro(1,"Los futbolisimos. El misterio del jugador número 13", new BigDecimal("11.95"),5,"Roberto Santiago","images/futbolisimos1.png"));
		hmLibros.put(2,new Libro(2,"Los futbolisimos. El misterio del obelisco mágico", new BigDecimal("11.95"),5,"Roberto Santiago","images/futbolisimos2.png"));
		hmLibros.put(3,new Libro(3,"Los futbolisimos. El misterio del día de los inocentes", new BigDecimal("11.95"),5,"Roberto Santiago","images/futbolisimos3.png"));

		indice = 4;
	
	}
	
	public static synchronized LibroDao getInstance() {
		
		if ( INSTANCE == null ) {
			INSTANCE = new LibroDao();
		}
		
		return INSTANCE;
	}

	@Override
	public List<Libro> getAll() {
		return new ArrayList<>(hmLibros.values());
	}

	@Override
	public Libro getById(int id) {
		
		Libro liburu = null;
		
		//Recorro el hashMap para ver si existe un libro con esa ID
		for  (Iterator itLibro = hmLibros.keySet().iterator(); itLibro.hasNext();) {
			int indice = (Integer) itLibro.next();
			Libro value = hmLibros.get(indice);
			if (value.getId() == id) {
				liburu = value;
				break;
			}
			
		}
		

		return liburu;
	}

	@Override
	public boolean delete(int id) {
		boolean centinela = false;;
		
		//Recorro el hashMap para ver si existe un libro con esa ID
		for  (Iterator itLibro = hmLibros.keySet().iterator(); itLibro.hasNext();) {
			int indice = (Integer) itLibro.next();
			Libro value = hmLibros.get(indice);
			if (value.getId() == id) {
				centinela = true;
				break;
			}
			
		}
		
		//Si el libro con esa ID existe, lo borro.
		if (centinela) { 
			hmLibros.remove(id);
		}
		return centinela;
	}

	@Override
	public boolean insert(Libro l) {
		boolean centinela = true;
		
		// recorrer con un Iterator
		for  (Iterator itLibro = hmLibros.keySet().iterator(); itLibro.hasNext();) {
			int indice = (Integer) itLibro.next();
			Libro value = hmLibros.get(indice);
			
			//Compruebo que no tenga la misma ID
			if ((l.getId()) == (value.getId())) {
				System.out.println("El libro no puede tener una ID ya existente");
				centinela = false;
				break;
			}
			
			//Compruebo que no tenga lel mismo titulo
			if (l.getNombre().equalsIgnoreCase(value.getNombre())) {
				System.out.println("El libro no puede tener un titulo ya existente");
				centinela = false;
				break;
			}
			
		}
		
		//Si Eel ID y el titulo son correctos, se introduce el libro
		if (centinela) {
			l.setId(indice);
			hmLibros.put(indice, l);
			indice++;
			centinela = true;
			
		}


		
		return centinela;
	}

}

