package com.ipartek.formacion.supermercado.modelos;

import java.time.LocalDate;

public class Cliente {
	
	private Long id;
	private String nombre, apellidos, cif;
	private LocalDate fechaNacimiento;
	
	private boolean correcto = true;
	
	private String errorId, errorNombre, errorApellidos, errorCif, errorFechaNacimiento;
	
	public Cliente(String id, String nombre, String apellidos, String cif, String fechaNacimiento) {
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
		setCif(cif);
		setFechaNacimiento(fechaNacimiento);
		

	}
	
	public Cliente(Long id, String nombre, String apellidos, String cif, LocalDate fechaNacimiento) {
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
		setCif(cif);
		setFechaNacimiento(fechaNacimiento);
		

	}

	public Long getId() {
		return id;	
	}

	public void setId(String id) {
		/*try {
			if (id != null) {
				setId(Long.parseLong(id));
			}else {
				setId((Long)null);
			}	
		}catch(NumberFormatException e) {
			setErrorId("El id debe ser numérico");
		}*/

		try {
			setId(id != null && id.trim().length() != 0? Long.parseLong(id) : null);	
		}catch(NumberFormatException e) {
			setErrorId("El id debe ser numérico");
		}
			
	}
	
	public void setId(Long id) {
		if(id != null && id < 1) {
			setErrorId("El id debe ser mayor que 0");
		}
		this.id = id;
	}

	public String getNombre() {
		if (nombre == null || !nombre.matches("\\p{Lu}\\p{L1}{2}[ \\p{L}]*")) { //nombre.trim().length() < 2) {
			setErrorNombre("El nombre es obligatorio, debe tener 2 caracteres y empezar con mayusculas");
		}
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		if (apellidos == null && apellidos.trim().length() == 0) {
			this.apellidos = null;
		}else if (this.apellidos == null  && !this.apellidos.matches("\\p{Lu}\\p{L1}{2}[ \\p{L}]*")) {
			setErrorApellidos("Los apellidos no deben ser obligatorios pero deben tener al menso 2 letras");
		}
		
		this.apellidos = apellidos;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		if (cif == null || !cif.matches("[ABCDEFGHJPQRSUVNW]\\D{8}|[KLMXYZ +\\D{7}[A-Z]|D{8}[A-Z]")) {
			setErrorCif("El CIF debe tener formato correcto como por ejemplo: B12345678 X1234567A 12345678Z");
		}
		this.cif = cif;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	
	public void setFechaNacimiento(String fechaNacimiento) {
		/*
		 Si fuera obligatorio:
		 if (fechanacimiento == null || fechanacimiento.trim().length() == 0) {setErrorFecha
		 */
		try {
			setFechaNacimiento(fechaNacimiento != null && fechaNacimiento.trim().length() > 0 ? LocalDate.parse(fechaNacimiento) : null);
		}catch (Exception e){
			setErrorFechaNacimiento("EL formato de la fecha de nacimiento no es correcto. Debe ser AAAA-MM-DD");
		}
		
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		
		if (fechaNacimiento.isAfter(LocalDate.now().minusYears(18))){
			setErrorFechaNacimiento("Debe ser mayor de edad");
		}
		this.fechaNacimiento = fechaNacimiento;
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

	public String getErrorSpellidos() {
		return errorApellidos;
	}

	public void setErrorApellidos(String errorSpellidos) {
		this.errorApellidos = errorSpellidos;
	}

	public String getErrorCif() {
		return errorCif;
	}

	public void setErrorCif(String errorCif) {
		this.errorCif = errorCif;
	}

	public String getErrorFechaNacimiento() {
		return errorFechaNacimiento;
	}

	public void setErrorFechaNacimiento(String errorFechaNAcimiento) {
		this.errorFechaNacimiento = errorFechaNAcimiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((cif == null) ? 0 : cif.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Cliente other = (Cliente) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (cif == null) {
			if (other.cif != null)
				return false;
		} else if (!cif.equals(other.cif))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
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
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", cif=" + cif
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	
	

}
