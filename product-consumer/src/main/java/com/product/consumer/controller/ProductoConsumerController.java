package com.product.consumer.controller;

import com.product.consumer.dto.ProductoDto;
import com.product.consumer.dto.ProductoListResponseDto;
import com.product.consumer.dto.ProductoResponseDto;
import com.product.consumer.rest.ProductoRest;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/consumer/producto")
@Slf4j
public class ProductoConsumerController {

    private ProductoRest productoRest;

    public ProductoConsumerController(ProductoRest productoRest) {
        this.productoRest = productoRest;
    }

    @GetMapping
    public ProductoListResponseDto getAllProducto() {
        log.info("En ProductoConsumerController -> getAllProducto() Called");
        return productoRest
                .getAllProducto();
    }

    @GetMapping("/{productoId}")
    public ProductoResponseDto getProductoById(@PathVariable Long productoId) {
        log.info("En ProductoConsumerController -> getAllProducto() Called productoId {}", productoId);
        return productoRest
                .findByProductoId(productoId);
    }

    @PostMapping
    public ProductoResponseDto saveOrUpdateProducto(@Valid @RequestBody ProductoDto productoDto) {
        log.info("En ProductoConsumerController -> saveOrUpdateProducto() Called | productoDto {}", productoDto);
        return productoRest
                .saveOrUpdateProducto(productoDto);
    }

    @DeleteMapping("/{productoId}")
    public ProductoListResponseDto deleteProductoById(@PathVariable Long productoId) {
        log.info("En ProductoConsumerController -> deleteProductoById() Called productoId {}", productoId);
        return productoRest
                .deleteProductoWithProductoId(productoId);
    }

}
