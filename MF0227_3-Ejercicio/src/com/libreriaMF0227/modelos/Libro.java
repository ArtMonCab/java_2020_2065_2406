package com.libreriaMF0227.modelos;

import java.io.Serializable;
import java.math.BigDecimal;


public class Libro implements Serializable{
	
	private static final long serialVersionUID = 5452816664057554386L;
	
	public static final String AUTOR_POR_DEFECTO = "Anónimo";
	public static final String IMAGEN_POR_DEFECTO = "img/default.png";
	
	private int id;
	private String nombre;
	private BigDecimal precio;
	private Integer descuento;
	private String autor;
	private String imagen;
	
	private boolean correcto = true;

	private String errorId;
	private String errorNombre;
	private String errorPrecio;
	private String errorDescuento;
	private String errorAutor;
	private String errorImagen;
	
	public Libro(String id, String nombre, String precio, String descuento, String autor, String imagen) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setDescuento(descuento);
		setAutor(autor);
		setImagen(imagen);
	}


	private void setId(String id) {
		try {
			setId(id.trim().length() != 0 ? Integer.parseInt(id) : null);
		} catch (NumberFormatException e) {
			setErrorId("El id debe ser numérico");
		}
	}


	private void setPrecio(String precio) {
		try {
			if ((precio.matches("\\d+.\\d\\d")) || (precio.matches("\\d+"))){
				setPrecio(new BigDecimal(precio));
			}else {
				setErrorPrecio("El precio debe tener el formato correcto y a lo sumo 2 decimales");
			}
			
		} catch (Exception e) {
			setErrorPrecio("El precio no tiene un formato correcto");
		}
	}



	private void setDescuento(String descuento) {
		try {
			setDescuento(Integer.parseInt(descuento));
		} catch (NumberFormatException e) {
			setErrorDescuento("El descuento debe ser un número entero");
		}
	}
	
	
	public Libro(int id, String nombre, BigDecimal precio, Integer descuento, String autor, String imagen) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.autor = autor;
		this.imagen = imagen;
	}
	


	public Libro() {
		super();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if ( autor != null ) {
			
			if ( autor.trim().isEmpty() ) {
				autor = AUTOR_POR_DEFECTO;
			}
			this.autor = autor;
			
		}else {
			this.autor = AUTOR_POR_DEFECTO;
		}	
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		
		if ( imagen != null ) {
			
			if ( imagen.trim().isEmpty() ) {
				imagen = IMAGEN_POR_DEFECTO;
			}
			this.imagen = imagen;
			
		}else {
			this.imagen =  IMAGEN_POR_DEFECTO;
		}
		
	}

	public boolean isCorrecto() {
		return correcto;
	}
	
	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public String getErrorId() {
		return errorId;
	}



	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}



	public String getErrorNombre() {
		return errorNombre;
	}



	public void setErrorNombre(String errorNombre) {
		this.errorNombre = errorNombre;
	}



	public String getErrorPrecio() {
		return errorPrecio;
	}



	public void setErrorPrecio(String errorPrecio) {
		correcto = false;
		this.errorPrecio = errorPrecio;
	}



	public String getErrorDescuento() {
		return errorDescuento;
	}



	public void setErrorDescuento(String errorDescuento) {
		correcto = false;
		this.errorDescuento = errorDescuento;
	}



	public String getErrorAutor() {
		return errorAutor;
	}



	public void setErrorAutor(String errorAutor) {
		this.errorAutor = errorAutor;
	}



	public String getErrorImagen() {
		return errorImagen;
	}



	public void setErrorImagen(String errorImagen) {
		this.errorImagen = errorImagen;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((descuento == null) ? 0 : descuento.hashCode());
		result = prime * result + id;
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (descuento == null) {
			if (other.descuento != null)
				return false;
		} else if (!descuento.equals(other.descuento))
			return false;
		if (id != other.id)
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento + ", autor="
				+ autor + ", imagen=" + imagen + "]";
	}

}