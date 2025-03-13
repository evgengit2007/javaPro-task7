package ru.vtb.javaPro.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.vtb.javaPro.dto.ProductDto;
import ru.vtb.javaPro.entity.Product;
import ru.vtb.javaPro.repository.ProductRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findByProductWithUser(Long id) {
        return productRepository.findByUser(id);
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Product findProductByPidAndUid(Long pid, Long uid) {
        return productRepository.findByIdAndUser(pid, uid)
                .orElseThrow(EntityNotFoundException::new);
    }

    public ProductDto create(Product product) {
        ProductMapper
    }
}
