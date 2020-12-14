package com.libreriaMF0227.apps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import com.libreriaMF0227.accesodatos.LibroDao;
import com.libreriaMF0227.modelos.Libro;


public class AppLibreria {
	
	
	
	//Variables globales
	static String opcion = "";   // opcion seleccionada en el menu por el usuario
	static private LibroDao libroDao = new LibroDao();
	static private ArrayList<Libro> lista = new ArrayList<Libro>();

	static private Scanner sc = new Scanner(System.in);
	
	static private LibroDao book = LibroDao.getInstance();
	
	

	
	//Constantes
	static final private String OP_LISTAR = "1";
	static final private String OP_ALTA = "2";
	static final private String OP_BAJA = "3";
	static final private String OP_SALIR = "S";

	public static void main(String[] args) {
		
		System.out.println("***********  GESTION DE LIBRERIA   **************");
		sc = new Scanner(System.in);
		boolean salir = false;
		
		do {
			crearMenu();
		
			switch (opcion.toUpperCase()) { 
			case OP_LISTAR:
				listar();
				break;
			case OP_ALTA:
				alta();
				break;	
			case OP_BAJA:
				baja();
				break;
			case OP_SALIR:
				salir = true;
				System.out.println("***********  Fin del programa   **************");
				break;
			default:
					System.out.println("Escoge una opcion correcta");
			}
		}while(!salir);

		 
		
		sc.close();
		
	}
	
	private static void crearMenu() {
		
		System.out.println("************************************");
		System.out.println(" "+ OP_LISTAR + ".- Listado de libros");
		System.out.println(" "+ OP_ALTA + ".- Alta de un libro");
		System.out.println(" "+ OP_BAJA + ".- Baja de un libro");
		System.out.println(" ");
		System.out.println(" "+ OP_SALIR + " - Salir");
		System.out.println("************************************");
		
		System.out.println("\n Selecciona una opcion del menu:");
		
		opcion = sc.nextLine();
		
		
	}
	
	private static void listar() {
		
		ArrayList<Libro> libros = book.obtenerTodos();
		for (Libro libro : libros) {
			System.out.println(String.format("%3s %-15s %-15s  %4s €  %2s por ciento %s", libro.getId(), libro.getNombre(), libro.getAutor(),
					libro.getPrecio(), libro.getDescuento(), libro.getImagen()));
		
		}
		
        	
	}
	
	private static void alta() {
		Libro liburu = new Libro();
		boolean repetir = true;
		
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
		
		do {
			System.out.println("Introduce el titulo del nuevo libro:");
			liburu.setNombre(sc.nextLine());
			if ((liburu.getNombre().length() < 2) || (liburu.getNombre().length() > 150)) {
				System.out.println("El título del libro debe tener de 2 a 150 caracteres.");
			}else {
				repetir = false;
			}
			
		}while (repetir);
		
		
		
		//Controlo que el precio sea un numero
		repetir = true;
		
		do {
			try{
				System.out.println("Introduce el precio del nuevo libro:");
				liburu.setPrecio(new BigDecimal(sc.nextLine()));
				repetir = false;
			} catch(Exception e) {
				System.out.println("El precio debe ser un número. Vuelva a introducirlo");
				repetir = true;
			}
		}while (repetir);
		
		
		//Controlo que el descuento sea un numero, y este entre 0 y 100
		repetir = true;
		
		do {
			try {
				System.out.println("Introduce el descuento del nuevo libro:");
				liburu.setDescuento(Integer.parseInt(sc.nextLine()));
				if ((liburu.getDescuento() >= 0) && (liburu.getDescuento() <= 100)) {
					repetir = false;
				}else {
					System.out.println("El descuento debe ser un número entre 0 y 100. Vuelva a introducirlo");
					repetir = true;
				}
			}catch(Exception e) {
				System.out.println("El descuento debe ser un número entre 0 y 100. Vuelva a introducirlo");
				repetir = true;
			}
			
		}while (repetir);
		
		//Si el autor es nulo, pongo "anónimo" por defecto
		System.out.println("Introduce el autor del nuevo libro:");
		liburu.setAutor(sc.nextLine());
		
		System.out.println("Introduce la URL de la imagen del nuevo libro:");
		liburu.setImagen(sc.nextLine());
		
		if(libroDao.crear(liburu)) {
			System.out.println ("Libro introducido correctamente");
		}else {
			System.out.println("No se ha podido dar de alta el libro porque alguno de sus valores no es correcto");
		
		}
		
		
	}
	
	private static void baja() {
		System.out.println("Opcion baja en construcción");
	}
	

	
	
}
