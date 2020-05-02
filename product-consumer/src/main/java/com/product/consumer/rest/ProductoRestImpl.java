package com.product.consumer.rest;

import com.product.consumer.dto.ProductoDto;
import com.product.consumer.dto.ProductoListResponseDto;
import com.product.consumer.dto.ProductoResponseDto;
import com.product.consumer.util.ConsumerConstants;
import com.product.consumer.util.ConsumerUtil;
import java.net.URI;
import java.net.URISyntaxException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ProductoRestImpl implements ProductoRest {

    private final RestTemplate restTemplate;

    public ProductoRestImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductoResponseDto findByProductoId(Long productoId) {
        log.info("In ProductoRestImpl -> findByProductoId() Called | ProductoId {}", productoId);
        ResponseEntity<ProductoResponseDto> response = null;
        String paramUrl = ConsumerUtil.getParametrizeString(ConsumerConstants.GET_PRODUCT_BY_ID, String.valueOf(productoId));
        try {
            response = restTemplate.getForEntity(String.valueOf(new URI(paramUrl)), ProductoResponseDto.class);
        } catch (URISyntaxException exception) {
            log.error("Exception Occurred while calling URL {}", paramUrl, exception);
        }
        return response != null ? response.getBody() : null;

    }

    @Override
    public ProductoResponseDto saveOrUpdateProducto(ProductoDto productoDto) {
        log.info("In ProductoRestImpl -> saveOrUpdateProducto() Called | productoDto {}", productoDto);
        ResponseEntity<ProductoResponseDto> response = null;
        try {
            response = restTemplate.postForEntity(String.valueOf(new URI(ConsumerConstants.SAVE_UPDATE_PRODUCTS)), productoDto, ProductoResponseDto.class);
        } catch (URISyntaxException exception) {
            log.error("Exception Occurred while calling URL {}", ConsumerConstants.GET_ALL_PRODUCTS, exception);
        }
        return response != null ? response.getBody() : null;
    }

    @Override
    public ProductoListResponseDto getAllProducto() {
        log.info("In ProductoRestImpl -> getAllProducto() Called");
        ResponseEntity<ProductoListResponseDto> response = null;
        try {
            response = restTemplate.getForEntity(String.valueOf(new URI(ConsumerConstants.GET_ALL_PRODUCTS)), ProductoListResponseDto.class);
        } catch (URISyntaxException exception) {
            log.error("Exception Occurred while calling URL {}", ConsumerConstants.GET_ALL_PRODUCTS, exception);
        }
        return response != null ? response.getBody() : null;
    }

    @Override
    public ProductoListResponseDto deleteProductoWithProductoId(Long productoId) {
        log.info("In ProductoRestImpl -> deleteProductoWithProductoId() Called | productoId {}", productoId);
        String paramUrl = ConsumerUtil.getParametrizeString(ConsumerConstants.DELETE_PRODUCT_BY_ID, String.valueOf(productoId));
        try {
            restTemplate.delete(String.valueOf(new URI(paramUrl)));
        } catch (URISyntaxException exception) {
            log.error("Exception Occurred while calling URL {}", paramUrl, exception);
        }
        return getAllProducto();
    }
}
