<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<form action="admin/cliente" method="post">
	<input type="number" min="1"  name="id" placeholder="Id" value="${cliente.id}" />
	<div>${cliente.errorId}</div>
	<input type="text" name="nombre" placeholder="Nombre" value="${cliente.nombre}" required patter="\p{Lu}\p{Ll}{2}[ \\p{L}]*"/>
	<div>${cliente.errorNombre}</div>
	<input type="text" name="apellidos" placeholder="Apellidos" value="${cliente.apellidos}" patter="\p{Lu}\p{Ll}{2}[ \\p{L}]*"/>
	<div>${cliente.errorApellidos}</div>
	<input type="text" name="cif" placeholder="CIF" value="${cliente.cif}" required  patter="[ABCDEFGHJPQRSUVNW]\d{8}|[XYZ]\\d{7}[A-Z]|\d{8}[A-Z]"/>
	<div>${cliente.errorCif}</div>
	<input type="date" max="<%=java.time.LocalDate.now().minusYears(18)%>"  name="fecha-nacimiento" placeholder="Fecha de nacimiento" value="${cliente.fechaNacimiento}" />
	<div>${cliente.errorFechaNacimiento}</div>
	<button>Aceptar</button>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>