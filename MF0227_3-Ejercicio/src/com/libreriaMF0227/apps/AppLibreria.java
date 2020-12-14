package com.libreriaMF0227.apps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import com.libreriaMF0227.accesodatos.LibroDao;
import com.libreriaMF0227.modelos.Libro;


public class AppLibreria {
	
	static final protected String OP_LISTAR = "1";
	static final protected String OP_CREAR = "2";
	static final protected String OP_ELIMINAR = "3";
	static final protected String OP_MODIFICAR = "4";
	static final protected String OP_MOSTRAR = "5";
	static final protected String OP_SALIR = "s";
	static final protected String NOMBRE_POJO = "libro";
	
	
	static String opcion = "";   // opcion seleccionada en el menu por el usuario
	static private LibroDao modelo = new LibroDao();
	static private ArrayList<Libro> lista = new ArrayList<Libro>();
	static private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		
		inicializarDatos();
		
		
		boolean salir = false;
		
		do {
			System.out.println("");
			System.out.println("");
			System.out.println("-------------------------------------------------");
			System.out.println("");
			System.out.println("***********  GESTION DE LIBRERIA   **************");
			
			
			System.out.println("************************************");
			System.out.println(" " + OP_LISTAR + ".- Listar todos los libros");
			System.out.println(" " + OP_CREAR + ".- Dar de alta un libro");
			System.out.println(" " + OP_ELIMINAR + ".- Dar de baja un libro");
			System.out.println(" ");
			System.out.println(" " + OP_SALIR + " - Salir");
			System.out.println("************************************");
			
			System.out.println("");
			System.out.println("--------------------------------------------------");
			System.out.println("");
			System.out.println("Introduzca una opción: ");
			System.out.println("");
			
			opcion = sc.nextLine();	
			
			switch (opcion.toUpperCase()) { 
			
			case OP_LISTAR:
				listar();
				break;
			case OP_CREAR:
				crear();
				break;	
			case OP_ELIMINAR:
				eliminar();
				break;
			case OP_MOSTRAR:
				mostrar();
				break;
			case OP_SALIR:
				salir = true;
				System.out.println("***********  Programa finalizado   **************");
				break;
			default:
					System.out.println("Escoge una opcion correcta");
			}
		}while(!salir);
		
		sc.close();
	}


	protected static void eliminar() {
		int idLibro = 0;
		boolean repetir = true;
		char confirmacion = ' ';
		
		//Pongo el listado de libros disponibles para que sea m�s facil ver cual quiero eliminar
		listar();
		System.out.println("");
		//Compruebo que el ID es correcto
		do {
			try {
				System.out.println("Introduzca el ID del libro que desea eliminar");
				idLibro = Integer.parseInt(sc.nextLine());
				repetir = false;
			}catch (Exception E){
				System.out.println("El ID debe ser un numero entero");
				repetir = true;
			}
		}while(repetir);
		
		repetir = true;
		
		//Pido confirmacion de la baja
		do {
			System.out.printf("¿Desea eliminar el libro con el ID  " + idLibro + "(S/N)?");			
			confirmacion = Character.toUpperCase(sc.nextLine().charAt(0));
			
			if (confirmacion == 'S') {
				if (modelo.delete(idLibro)) {
					System.out.println("Libro correctamente eliminado");
					System.out.println("");
					System.out.println("");
					//Pongo el listado de libros para comprobar que se haya borrado
					listar();
				}else {
					System.out.println("No se ha podido borrar el libro porque su ID no existe");
				}					
			}		

		}while((confirmacion != 'S') && (confirmacion != 'N'));
			
		
		
	}

	protected static void listar() {

		lista = (ArrayList<Libro>) modelo.getAll();
	    for (int i=0;i<lista.size();i++) {   
	    	System.out.println("Id: " + lista.get(i).getId() +
	    			" - Titulo: " + lista.get(i).getNombre() +
	    			" - Precio: " + lista.get(i).getPrecio() +
	    			" - Descuento: " + lista.get(i).getDescuento() +
	    			" - Autor: " + lista.get(i).getAutor() +
	    			" - URLImagen: " + lista.get(i).getImagen());
	    
	    			
	      }
		
	}

	protected static void crear() {
		Libro liburu = new Libro();
		boolean repetir = true;
		String titulo = null;
		String precio = "0";
		int descuento = 0;
		String autor = "Anónimo";
		
		//Compruebo que el ID es correcto
		do {
			try {
				System.out.println("Introduce el ID del libro: ");
				liburu.setId(Integer.parseInt(sc.nextLine()));
				repetir = false;
			}catch (Exception E){
				System.out.println("El ID debe ser un numero entero");
				repetir = true;
			}
			
		}while(repetir);
		
		
		//Compruebo que el titulo del libro es correcto
		repetir = true;
		do {
			System.out.println("Introduce el titulo del libro: ");
			titulo = sc.nextLine();
			if ((titulo.length() < 2) || (titulo.length() > 150) || titulo.isEmpty()) {
				System.out.println("El título debe estar entre 2 y 150 caracteres");
				repetir= true;
			}else {
				liburu.setNombre(titulo);
				repetir = false;
				
			}	
		}while(repetir);
		

		
		//Compruebo que el precio es correcto
		do {
			try {
				System.out.println("Introduce el precio del libro: ");
				precio = sc.nextLine();
				if ( Integer.parseInt(precio) <= 0) {
					System.out.println("El precio del libro debe ser mayor que 0 y tener como mucho 2 decimales");
					repetir = true;
				}else {
					if ((precio.matches("\\d+.\\d\\d")) || (precio.matches("\\d+"))){
						liburu.setPrecio(new BigDecimal(precio));
						repetir = false;
					}else {
						System.out.println("El precio debe tener el formato correcto y a lo sumo 2 decimales");
						repetir = true;
					}
						
				}
			}catch (Exception E){
				System.out.println("El precio del libro debe ser un número mayor que 0 y tener como mucho 2 decimales");
				repetir = true;
			}
		}while(repetir);
		
		repetir = true;
		do {
			try {
				System.out.println("Introduce el descuento del libro: ");
				descuento = Integer.parseInt(sc.nextLine());
				if ((descuento >= 0) && (descuento <= 100)) {
					liburu.setDescuento(descuento);
					repetir = false;
				}else {
					System.out.println("El descuento debe ser un numero entre 0 y 100");
					repetir = true;
				}
				
			}catch (Exception E) {
				System.out.println("El descuento debe ser un numero entre 0 y 100");
				repetir = true;
			}
		}while(repetir);

		
		//SI dejo el autor del libro en blanco, su valor será "anonimo"
		System.out.println("Introduce el autor del libro: ");
		autor = sc.nextLine();
		if (autor.isEmpty()) {
			liburu.setAutor("Anónimo");
		}else {
			liburu.setAutor(autor);
		}

		//Meto la URL de la imagen del libro
		System.out.println("Introduce la url de la imagen: ");
		liburu.setImagen(sc.nextLine());
		
		
		//Indroduzco el libro
		if(modelo.insert(liburu)) {
			System.out.println ("Libro introducido correctamente");
		}else {
			System.out.println("No se ha podido dar de alta el libro porque alguno de sus valores no es correcto");
		
		}
	}
	
	protected static void inicializarDatos() {
		System.out.println("Opcion Inicializar datos en construccion");
		System.out.println("");
		
	}
	

	protected static void mostrar() {
		int idLibro;
		Libro liburu = null;
		boolean repetir = true;
		//Compruebo que el ID es correcto
		do {
			try {
				System.out.println("Introduce el ID del libro: ");
				idLibro = Integer.parseInt(sc.nextLine());
				liburu = modelo.getById(idLibro);
				repetir = false;
			}catch (Exception E){
				System.out.println("El ID debe ser un numero entero");
				repetir = true;
			}
		}while(repetir);

		if (liburu != null){
			System.out.println(liburu);
		}else {
			System.out.println("No existe un libro con ese ID");
		
		}
				
		
	}


	
}
