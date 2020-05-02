package com.producto.backend.util;

import com.producto.backend.dto.ProductoDto;
import com.producto.backend.model.Producto;
import java.util.ArrayList;
import java.util.List;

public class MockFactory {

    private MockFactory() {

    }

    public static ProductoDto productoDtoMock() {
        ProductoDto productoDto = new ProductoDto();
        productoDto.setProductoNombre("Test Product");
        productoDto.setProductoId(1L);
        return productoDto;
    }

    public static Producto productoMock() {
        Producto producto = new Producto();
        producto.setProductoNombre(TestConstant.NOMBRE);
        producto.setProductoId(1L);
        return producto;
    }

    public static List<Producto> productoList() {
        Producto producto = new Producto();
        producto.setProductoNombre(TestConstant.NOMBRE);
        List<Producto> productos = new ArrayList<>();
        productos.add(producto);
        return productos;
    }

}
