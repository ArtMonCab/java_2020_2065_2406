package com.uf2406_actividad3.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Libro implements Serializable{
	
	private static final long serialVersionUID = 5452816664057554386L;
	
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private Integer descuento;

	private boolean correcto = true;

	private String errorId;
	private String errorNombre;
	private String errorPrecio;
	private String errorDescuento;
	
	public Libro(String id, String nombre, String precio, String descuento) {
		
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setDescuento(descuento);
	}


	private void setId(String id) {
		try {
			setId(id.trim().length() != 0 ? Long.parseLong(id) : null);
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


	public Libro(Long id, String nombre, BigDecimal precio, Integer descuento) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setDescuento(descuento);
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		if (id != null && id <= 0) {
			setErrorId("No se admiten ids inferiores o iguales a 0");
		}
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		if (nombre.isEmpty() || nombre.length() < 2 || nombre.length() > 150) {
			setErrorNombre("El título debe contener entre 2 y 150 caracteres");
		}
		this.nombre = nombre;
	}


	public BigDecimal getPrecio() {
		return precio;
	}


	public void setPrecio(BigDecimal precio) {
		if (precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
			setErrorPrecio("Debe rellenarse y ser mayor que 0");
		}

		this.precio = precio;
	}


	public Integer getDescuento() {
		return descuento;
	}


	public void setDescuento(Integer descuento) {
		if (descuento == null || (descuento < 0 || descuento > 100)) {
			setErrorDescuento("El descuento debe estar comprendido entre 0 y 100");
		}
		this.descuento = descuento;
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
		correcto = false;
		this.errorId = errorId;
	}

	public String getErrorNombre() {
		return errorNombre;
	}

	public void setErrorNombre(String errorNombre) {
		correcto = false;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descuento == null) ? 0 : descuento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (descuento == null) {
			if (other.descuento != null)
				return false;
		} else if (!descuento.equals(other.descuento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento
				+ ", correcto=" + correcto + ", errorId=" + errorId + ", errorNombre=" + errorNombre + ", errorPrecio="
				+ errorPrecio + ", errorDescuento=" + errorDescuento + "]";
	}
	
	


	
	

}
