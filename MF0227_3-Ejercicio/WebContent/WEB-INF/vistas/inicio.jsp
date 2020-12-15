<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="agregarlibro" method="get">
	<div
		class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5">
		<c:forEach items="${libros}" var="libro">
			<div class="col mb-4">
				<div class="card h-100">
					
					<img src="${libro.imagen}" class="card-img-top" alt="img/default.png">
					

					<div class="card-body">
						<hr>
						<h5 class="card-title"></h5>
						<p class="card-text">${libro.nombre} <span class="glyphicon glyphicon-heart-empty"></span></p>
						<p class="card-text">
							<strong><h6>${libro.autor}</h6></strong>
						</p>
					</div>
					<div class="card-footer bg-primary p-0">
						<a href="inicio" class="btn btn-block text-white">Ver detalles</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>