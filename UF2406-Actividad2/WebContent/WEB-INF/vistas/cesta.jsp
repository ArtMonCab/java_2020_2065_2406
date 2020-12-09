<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Esta es su elección</h1>
<form action="inicio" method="post">

	<table class="table table-hover table-bordered">
		<thead>
			<tr class="table-dark">
				<th>Id</th>
				<th>Nombre del producto</th>
				<th>Precio unitario</th>
				<th>Unidades</th>
				<th>Precio total</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${cesta}" var="producto">
				<tr>
					<th>${producto.value.id}</th>
					<th>${producto.value.nombre}</th>
					<th><fmt:formatNumber type="currency"
							value="${producto.value.precio}" /></th>
					<th>${producto.value.cantidad}</th>
					<th><fmt:formatNumber type="currency"
							value="${producto.value.total}" /></th>
				</tr>
			</c:forEach>
			<tr class="table-info">
				<th colspan="4">Importe total de la compra</th>
				<td>
					<strong><fmt:formatNumber type="currency" value="${totalcompra}" /></strong>
          		</td>
			</tr>

		</tbody>
	</table>
	<button class="btn btn-primary btn-block mb-3">Terminar la compra</button>
</form>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>