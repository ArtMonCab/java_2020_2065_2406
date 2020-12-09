<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<h1>Haga su pedido</h1>
<form action="agregaracesta" method="post">

	<table class="table table-hover table-bordered">
		<thead>
			<tr class="table-dark">
				<th>Id</th>
				<th>Nombre del producto</th>
				<th>Precio Unitario</th>
				<th>Unidades</th>
			</tr>
		</thead>



		<tbody>
			<c:forEach items="${productos}" var="producto">
				<tr>
					<th>${producto.id}</th>
					<th>${producto.nombre}</th>
					<th><fmt:formatNumber type="currency"
							value="${producto.precio}" /></th>
					<th>
						<input type="number"
						class="form-control text-center font-weight-bold" placeholder=""
						aria-label="Cantidad" name="${producto.id}" value="${producto.cantidad}"  min="0" />
					</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button class="btn btn-primary btn-block mb-3">Agregar a la cesta</button>
</form>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>