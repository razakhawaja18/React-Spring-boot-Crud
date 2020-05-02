package com.producto.backend.controller;

import com.producto.backend.dto.ProductoDto;
import com.producto.backend.dto.ProductoListResponseDto;
import com.producto.backend.dto.ProductoResponseDto;
import com.producto.backend.service.ProductoService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/backend/producto")
@Slf4j
public class ProductoBackendController {

    private ProductoService productoService;

    public ProductoBackendController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ProductoListResponseDto getAllProducto() {
        log.info("En ProductoBackendController -> getAllProducto() Called");
        return productoService
                .getAllProducto();
    }

    @GetMapping("/{productoId}")
    public ProductoResponseDto getProductoById(@PathVariable Long productoId) {
        log.info("En ProductoBackendController -> getAllProducto() Called productoId {}", productoId);
        return productoService
                .findByProductoId(productoId);
    }

    @PostMapping
    public ProductoResponseDto saveOrUpdateProducto(@Valid @RequestBody ProductoDto productoDto) {
        log.info("En ProductoBackendController -> saveOrUpdateProducto() Called | productoDto {}", productoDto);
        return productoService
                .saveOrUpdateProducto(productoDto);
    }

    @DeleteMapping("/{productoId}")
    public ProductoListResponseDto deleteProductoById(@PathVariable Long productoId) {
        log.info("En ProductoBackendController -> deleteProductoById() Called productoId {}", productoId);
        return productoService
                .deleteProductoWithProductoId(productoId);
    }

}
