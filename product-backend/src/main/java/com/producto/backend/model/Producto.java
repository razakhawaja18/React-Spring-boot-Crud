package com.producto.backend.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "producto")
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Long productoId;
    @Column(name = "producto_nombre")
    private String productoNombre;
    @Column(name = "producto_descripcion")
    private String productoDescripcion;
    @Column(name = "producto_cantidad")
    private Long productoCantidad;
    @Column(name = "producto_ubicacion")
    private String productoUbicacion;
    @Column(nullable = false, updatable = false, name = "creado_en")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date creadoEn;
    @Column(nullable = false, name = "actualizado_aLas")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date actualizadoALas;
}
