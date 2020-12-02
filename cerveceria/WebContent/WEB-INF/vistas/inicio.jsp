<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<c:forEach items="${cervezas}" var="cerveza">
	<div>
		<p>${cerveza.id}</p>
		<p>${cerveza.nombre}</p>
		<p>${cerveza.tipo}</p>
		<p>${cerveza.pais}</p>
		<p>${cerveza.descripcion}</p>
		<p>${cerveza.graduacion}</p>
		<p>${cerveza.precio}</p>
		<p>${cerveza.envase}</p>
		<p>${cerveza.capacidadEnvase}</p>
		<p>${cerveza.unidadesCaja}</p>
		<p>${cerveza.urlImagen}</p>
		<p>${cerveza.stock}</p>


	</div>
	<hr />
</c:forEach>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>