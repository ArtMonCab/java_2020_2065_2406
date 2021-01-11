<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="login" method="post" class="needs-validation"
	novalidate>
	<div class="form-group row">
		<label for="email" class="col-sm-2 col-form-label">Email</label>
		<div class="col-sm-10">
			<input type="email" class="form-control ${usuario != null ? (usuario.errorEmail != null ? 'is-invalid' : 'is-valid') : ''}" id="email" name="email">
			<div class="valid-feedback">Email correcto</div>
			<div class="invalid-feedback">El email es obligatorio y debe al menos un nombre de usuario, una @, un nombre de dominio y un punto.. Ejemplo : usuario@dominio.com</div>
		</div>
	</div>
	<div class="form-group row">
		<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="password" name="password">
		</div>
	</div>

	
	<div class="form-group row">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Iniciar sesión</button>
		</div>
	</div>
</form>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
