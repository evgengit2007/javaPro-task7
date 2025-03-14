package ru.vtb.javaPro.mapstructure;

import org.springframework.stereotype.Component;
import ru.vtb.javaPro.dto.ProductDto;
import ru.vtb.javaPro.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class MaptoProductDto implements MapRequestBody<Product, ProductDto>{
    @Override
    public ProductDto mapper(Product requestBody) {
        ProductDto productDto = new ProductDto(
                requestBody.getId(),
                requestBody.getAccountNumber(),
                requestBody.getBalance(),
                requestBody.getTypeProducts(),
                requestBody.getUser()
        );
        return productDto;
    }

    public List<ProductDto> mapperList(List<Product> productList) {
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product: productList) {
            productDtoList.add(mapper(product));
            System.out.println(product);
        }
        return productDtoList;
    }
}
