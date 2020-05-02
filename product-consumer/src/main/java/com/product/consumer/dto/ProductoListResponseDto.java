package com.product.consumer.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductoListResponseDto {

    private List<ProductoDto> productoDtoList;
    private String message;

    public ProductoListResponseDto(List<ProductoDto> productoDtoList, String message) {
        this.productoDtoList = productoDtoList;
        this.message = message;
    }
}
