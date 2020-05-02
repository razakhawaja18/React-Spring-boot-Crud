package com.producto.backend.service;

import com.producto.backend.dto.ProductoDto;
import com.producto.backend.dto.ProductoListResponseDto;
import com.producto.backend.dto.ProductoResponseDto;

public interface ProductoService {

    ProductoResponseDto findByProductoId(Long ProductoId);

    ProductoResponseDto saveOrUpdateProducto(ProductoDto productoDto);

    ProductoListResponseDto getAllProducto();

    ProductoListResponseDto deleteProductoWithProductoId(Long ProductoId);
}
