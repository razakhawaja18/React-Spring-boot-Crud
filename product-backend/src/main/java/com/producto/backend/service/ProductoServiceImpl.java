package com.producto.backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.producto.backend.dto.ProductoDto;
import com.producto.backend.dto.ProductoListResponseDto;
import com.producto.backend.dto.ProductoResponseDto;
import com.producto.backend.model.Producto;
import com.producto.backend.repository.ProductoRepository;
import com.producto.backend.util.BackendConstants;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService {

    private final ObjectMapper objectMapper;
    private ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository, ObjectMapper objectMapper) {
        this.productoRepository = productoRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public ProductoListResponseDto getAllProducto() {
        log.info("En ProductoServiceImpl -> getAllProducto()");
        Optional<List<Producto>> productoList = Optional.ofNullable(productoRepository.findAll());
        if (productoList.isPresent()) {
            List<ProductoDto> productoDto = productoList.get()
                    .stream().map(producto -> objectMapper.convertValue(producto, ProductoDto.class))
                    .collect(Collectors.toList());
            return new ProductoListResponseDto(productoDto, BackendConstants.SUCCESS_DATA_RETURNED_MESSAGE);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Override
    public ProductoResponseDto findByProductoId(Long productoId) {
        log.info("En ProductoServiceImpl -> findByProductoId() Called productoId {}", productoId);
        Optional<Producto> producto = productoRepository.findById(productoId);
        if (producto.isPresent()) {
            ProductoDto productoDto = objectMapper.convertValue(producto.get(), ProductoDto.class);
            return new ProductoResponseDto(productoDto, "Successfully object found With productoid" + productoId);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, BackendConstants.NO_DATA_FOUND_MESSAGE + productoId);
    }

    @Override
    public ProductoResponseDto saveOrUpdateProducto(ProductoDto productoDto) {
        log.info("En ProductoServiceImpl -> saveOrUpdateProducto()");
        Producto producto = objectMapper.convertValue(productoDto, Producto.class);
        producto = productoRepository.save(producto);
        ProductoDto convertedProductoDto = objectMapper.convertValue(producto, ProductoDto.class);
        return new ProductoResponseDto(convertedProductoDto, BackendConstants.SUCCESS_SAVE_UPDATE_MESSAGE);
    }

    @Override
    public ProductoListResponseDto deleteProductoWithProductoId(Long productoId) {
        log.info("En ProductoServiceImpl -> deleteProductoWithProductoId() Called productoId {}", productoId);
        Optional<Producto> producto = productoRepository.findById(productoId);
        if (producto.isPresent()) {
            productoRepository.delete(producto.get());
            return getAllProducto();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, BackendConstants.NO_DATA_FOUND_MESSAGE + productoId);
    }

}
