package com.producto.backend.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductoResponseDto {

    private ProductoDto productoDto;
    private String responseMessage;

    public ProductoResponseDto(ProductoDto productoDto, String responseMessage) {
        this.productoDto = productoDto;
        this.responseMessage = responseMessage;
    }
}
