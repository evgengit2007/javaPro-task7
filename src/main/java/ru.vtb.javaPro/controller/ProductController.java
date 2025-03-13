package ru.vtb.javaPro.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;
import ru.vtb.javaPro.dto.ProductResponse;
import ru.vtb.javaPro.entity.Product;
import ru.vtb.javaPro.service.ProductService;
import ru.vtb.javaPro.service.UserService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/products")
public class ProductController {

    private final ProductService productService;
    private final UserService userService;

    public ProductController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    // http://localhost:8989/products/v1/api/products/product/1
    @RequestMapping("/product/{id}")
    public ProductResponse findProductById(@PathVariable Long id) {
        return new ProductResponse(Collections.singletonList(productService.findProductById(id)));
    }

    // http://localhost:8989/products/v1/api/products/user/1
    @RequestMapping("/user/{uid}")
    public ProductResponse findByProductWithUser(@PathVariable Long uid) {
        List<Product> productList;
        try {
            productList = productService.findByProductWithUser(userService.findUserById(uid).getId());
        } catch (EntityNotFoundException exception) {
            productList = null;
        }
        ProductResponse productResponse = new ProductResponse(productList);
        return productResponse;
    }

    // http://localhost:8989/products/v1/api/products/product/1/user/1
    @RequestMapping("/product/{pid}/user/{uid}")
    public ProductResponse findProductByPidAndUid(@PathVariable Long pid, @PathVariable Long uid) {
        return new ProductResponse(Collections.singletonList(productService.findProductByPidAndUid(pid, uid)));
    }

    @PostMapping("/create")
    public ProductResponse updateBalance(@RequestBody Product product) {
        System.out.println(product);
        return new ProductResponse(List.of(productService.create(product)));
    }

}
