CREATE VIEW `facturas_completas` AS
SELECT c.id AS id_cliente,c.nombre AS nombre_cliente,apellidos,cif,fecha_nacimiento,f.id AS id_factura,codigo,fecha,fp.cantidad AS cantidad,p.id AS id_producto,p.nombre AS nombre_producto,descripcion,url_imagen,precio,descuento,unidad_medida,precio_unidad_medida,p.cantidad AS stock,departamentos_id
FROM clientes c
JOIN facturas f ON c.id = f.clientes_id
JOIN facturas_has_productos fp ON f.id = fp.facturas_id
JOIN productos p ON fp.productos_id = p.id
