<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/cliente" method="post">
	
	<div class="form-group row">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" min="1" name="id"
				placeholder="Id" value="${cliente.id}" />
		</div>
	</div>

	<div class="form-group row">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="nombre" id="nombre"
				placeholder="Nombre" value="${cliente.nombre}" required
				pattern="\p{Lu}\p{Ll}{2}[ \p{L}]*" />
		</div>
	</div>
	<div class="form-group row">
		<label for="apellidos" class="col-sm-2 col-form-label">Apellidos</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="apellidos"
				name="apellidos" placeholder="Apellidos"
				value="${cliente.apellidos}" pattern="\p{Lu}\p{Ll}{2}[ \p{L}]*" />
		</div>
	</div>
	<div class="form-group row">
		<label for="cif" class="col-sm-2 col-form-label">CIF</label>
		<div class="col-sm-10">
			<input class="form-control" id="cif" type="text" name="cif"
				placeholder="CIF" value="${cliente.cif}" required
				pattern="[ABCDEFGHJPQRSUVNW]\d{8}|[XYZ]\d{7}[A-Z]|\d{8}[A-Z]" />
		</div>
	</div>
	<div class="form-group row">
		<label for="fecha-nacimiento" class="col-sm-2 col-form-label">Fecha
			de nacimiento</label>
		<div class="col-sm-10">
			<input class="form-control" id="fecha-nacimiento" type="date"
				max="<%=java.time.LocalDate.now().minusYears(18)%>"
				name="fecha-nacimiento" placeholder="Fecha de nacimiento"
				value="${cliente.fechaNacimiento}" />
		</div>
	</div>

	<div class="form-group row">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-primary">Aceptar</button>
		</div>
	</div>
	
	<div class="text-danger">${cliente.errorId}</div>
	<div class="text-danger">${cliente.errorNombre}</div>
	<div class="text-danger">${cliente.errorApellidos}</div>
	<div class="text-danger">${cliente.errorCif}</div>
	<div class="text-danger">${cliente.errorFechaNacimiento}</div>
	
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>