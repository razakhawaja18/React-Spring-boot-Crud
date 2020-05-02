package com.producto.backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.producto.backend.dto.ProductoListResponseDto;
import com.producto.backend.dto.ProductoResponseDto;
import com.producto.backend.model.Producto;
import com.producto.backend.repository.ProductoRepository;
import com.producto.backend.util.MockFactory;
import com.producto.backend.util.TestConstant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductoRepository productoRepository;
    private ProductoService productoService;

    @Before
    public void setUp() {
        productoService = new ProductoServiceImpl(productoRepository, new ObjectMapper());
    }

    @Test
    public void testGetProducto() {
        Mockito.doReturn(MockFactory.productoList()).when(productoRepository).findAll();
        ProductoListResponseDto productoListResponseDto = productoService
                .getAllProducto();
        assertEquals(TestConstant.NOMBRE, productoListResponseDto.getProductoDtoList().get(0).getProductoNombre());
    }

    @Test
    public void testSaveOrUpdateProducto() {
        when(productoRepository.save(any(Producto.class))).thenReturn(MockFactory.productoMock());
        ProductoResponseDto productoResponseDto = productoService
                .saveOrUpdateProducto(MockFactory.productoDtoMock());
        assertEquals(TestConstant.NOMBRE, productoResponseDto.getProductoDto().getProductoNombre());
    }

}
