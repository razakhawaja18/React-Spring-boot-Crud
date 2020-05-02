package com.product.consumer.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductoDto {
    private Long productoId;
    private String productoNombre;
    private String productoDescripcion;
    private Long productoCantidad;
    private String productoUbicacion;
    private Date creadoEn;
    private Date actualizadoALas;
}
