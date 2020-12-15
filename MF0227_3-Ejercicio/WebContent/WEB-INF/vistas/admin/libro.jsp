<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>


<div class="container-fluid">
    <h1>Insertar o modificar libro</h1>

    <form action="admin/index" class="needs-validation" novalidate>
    
    	<div class="form-group row">
            <label for="nombre" class="col-sm-2 col-form-label">Id</label>
            <div class="col-sm-10">
				<input type="number" class="form-control" id="id" name="id"
				readonly placeholder="Id autoincremental">
			<div class="valid-feedback">Id correcto</div>
			<div class="invalid-feedback">El ID no es correcto</div>
		</div>
		</div>
        <div class="form-group row">
            <label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="nombre" required minlength="2" maxlenght="150">
                <div class="valid-feedback">Nombre correcto</div>
                <div class="invalid-feedback">El título debe tener entre 2 y 150 caracteres</div>
            </div>
        </div>

        <div class="form-group row">
            <label for="precio" class="col-sm-2 col-form-label">Precio</label>
            <div class="input-group col-sm-10">
                <input type="number" class="form-control" id="precio" required>

                <div class="input-group-append">
                    <span class="input-group-text rounded-right" id="basic-addon2">€</span>
                </div>

                <div class="valid-feedback">Precio correcto</div>
                <div class="invalid-feedback">Debe rellenarse y ser mayor que 0</div>
            </div>
        </div>
        

        <div class="form-group row">
            <label for="descuento" class="col-sm-2 col-form-label">Descuento</label>
            <div class="input-group col-sm-10">
                <input type="number" class="form-control" id="precio" required value='0'>

                <div class="input-group-append">
                    <span class="input-group-text rounded-right" id="basic-addon2">%</span>
                </div>

                <div class="valid-feedback">Descuento correcto</div>
                <div class="invalid-feedback">Debe rellenarse y estar entre 0 y 100</div>
            </div>
        </div>  
        
        
        <div class="form-group row">
            <label for="autor" class="col-sm-2 col-form-label">Autor</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="autor" required value='Anónimo'>
                <div class="valid-feedback">Autor correcto</div>
                <div class="invalid-feedback">Se pondrá el autor por defecto</div>
            </div>
        </div>
        
        <div class="form-group row">
            <label for="imagen" class="col-sm-2 col-form-label">URL Imagen</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="imagen" value='img/default.png'>
                <div class="valid-feedback">Imagen correcta</div>
                <div class="invalid-feedback">Hay que meter la URL de la imagen</div>
            </div>
        </div>
        <div class="form-group row">
            <div class="offset-sm-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Aceptar</button>
            </div>
        </div>
    </form>

    <script src="js/jquery-3.5.1.slim.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>

    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict';
            window.addEventListener('load', function () {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>
</div>


<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>