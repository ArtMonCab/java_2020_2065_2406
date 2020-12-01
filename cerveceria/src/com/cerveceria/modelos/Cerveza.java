package com.cerveceria.modelos;

import java.math.BigDecimal;

public class Cerveza {
	//Atributos
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
	
	//Constructor
	public Cerveza(long id, String nombre, String tipo, String pais, String descripcion, BigDecimal graduacion,
			BigDecimal precio, String envase, Integer capacidadEnvase, Integer unidadesCaja, String urlImagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.pais = pais;
		this.descripcion = descripcion;
		this.graduacion = graduacion;
		this.precio = precio;
		this.envase = envase;
		this.capacidadEnvase = capacidadEnvase;
		this.unidadesCaja = unidadesCaja;
		this.urlImagen = urlImagen;
	}
	
	
	//Getters y Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getGraduacion() {
		return graduacion;
	}
	
	public void setGraduacion(BigDecimal graduacion) {
		this.graduacion = graduacion;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	public String getEnvase() {
		return envase;
	}
	
	public void setEnvase(String envase) {
		this.envase = envase;
	}
	
	public Integer getCapacidadEnvase() {
		return capacidadEnvase;
	}
	
	public void setCapacidadEnvase(Integer capacidadEnvase) {
		this.capacidadEnvase = capacidadEnvase;
	}
	
	public Integer getUnidadesCaja() {
		return unidadesCaja;
	}
	
	public void setUnidadesCaja(Integer unidadesCaja) {
		this.unidadesCaja = unidadesCaja;
	}
	
	public String getUrlImagen() {
		return urlImagen;
	}
	
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capacidadEnvase == null) ? 0 : capacidadEnvase.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((envase == null) ? 0 : envase.hashCode());
		result = prime * result + ((graduacion == null) ? 0 : graduacion.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((unidadesCaja == null) ? 0 : unidadesCaja.hashCode());
		result = prime * result + ((urlImagen == null) ? 0 : urlImagen.hashCode());
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
		Cerveza other = (Cerveza) obj;
		if (capacidadEnvase == null) {
			if (other.capacidadEnvase != null)
				return false;
		} else if (!capacidadEnvase.equals(other.capacidadEnvase))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (envase == null) {
			if (other.envase != null)
				return false;
		} else if (!envase.equals(other.envase))
			return false;
		if (graduacion == null) {
			if (other.graduacion != null)
				return false;
		} else if (!graduacion.equals(other.graduacion))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (unidadesCaja == null) {
			if (other.unidadesCaja != null)
				return false;
		} else if (!unidadesCaja.equals(other.unidadesCaja))
			return false;
		if (urlImagen == null) {
			if (other.urlImagen != null)
				return false;
		} else if (!urlImagen.equals(other.urlImagen))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Cerveza [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", pais=" + pais + ", descripcion="
				+ descripcion + ", graduacion=" + graduacion + ", precio=" + precio + ", envase=" + envase
				+ ", capacidadEnvase=" + capacidadEnvase + ", unidadesCaja=" + unidadesCaja + ", urlImagen=" + urlImagen
				+ "]";
	}
	
	

	
	

}
