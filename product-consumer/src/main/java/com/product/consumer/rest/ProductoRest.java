package com.product.consumer.rest;


import com.product.consumer.dto.ProductoDto;
import com.product.consumer.dto.ProductoListResponseDto;
import com.product.consumer.dto.ProductoResponseDto;

public interface ProductoRest {
    ProductoResponseDto findByProductoId(Long ProductoId);

    ProductoResponseDto saveOrUpdateProducto(ProductoDto productoDto);

    ProductoListResponseDto getAllProducto();

    ProductoListResponseDto deleteProductoWithProductoId(Long ProductoId);
}
