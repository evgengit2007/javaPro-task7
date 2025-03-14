package ru.vtb.javaPro.mapstructure;

import org.springframework.stereotype.Component;
import ru.vtb.javaPro.dto.ProductDto;
import ru.vtb.javaPro.entity.Product;

@Component
public class MaptoProduct implements MapRequestBody<ProductDto, Product>{

    @Override
    public Product mapper(ProductDto requestBody) {
        Product product = new Product();
        product.setId(requestBody.id());
        product.setAccountNumber(requestBody.accountNumber());
        product.setBalance(requestBody.balance());
        product.setTypeProducts(requestBody.typeProducts());
        product.setUser(requestBody.user());
        return product;
    }
}
