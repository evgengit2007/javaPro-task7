package ru.vtb.javaPro.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import ru.vtb.javaPro.mapstructure.MaptoProduct;
import ru.vtb.javaPro.mapstructure.MaptoProductDto;
import org.springframework.stereotype.Service;
import ru.vtb.javaPro.dto.ProductDto;
import ru.vtb.javaPro.repository.ProductRepository;

import java.util.List;

@Slf4j
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final MaptoProduct maptoProduct;
    private final MaptoProductDto maptoProductDto;

    public ProductService(ProductRepository productRepository,
                          MaptoProduct maptoProduct,
                          MaptoProductDto maptoProductDto) {
        this.productRepository = productRepository;
        this.maptoProduct = maptoProduct;
        this.maptoProductDto = maptoProductDto;
    }

    public List<ProductDto> findByProductWithUser(Long id) {
        List<ProductDto> productDtoList = maptoProductDto.mapperList(productRepository.findByUser(id).orElseThrow(EntityNotFoundException::new));
        return productDtoList;
    }

    public ProductDto findProductById(Long id) {
        return maptoProductDto.mapper(productRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }

    public ProductDto findProductByPidAndUid(Long pid, Long uid) {
        return maptoProductDto.mapper(productRepository.findByIdAndUser(pid, uid)
                .orElseThrow(EntityNotFoundException::new));
    }

    public ProductDto create(ProductDto productDto) {
        return maptoProductDto.mapper(productRepository.save(maptoProduct.mapper(productDto)));
    }
}
