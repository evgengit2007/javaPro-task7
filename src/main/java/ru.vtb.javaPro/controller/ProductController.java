package ru.vtb.javaPro.controller;

import org.springframework.web.bind.annotation.*;
import ru.vtb.javaPro.dto.ProductResponse;
import ru.vtb.javaPro.service.ProductService;
import ru.vtb.javaPro.service.UserService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class ProductController {

    private final ProductService productService;
    private final UserService userService;

    public ProductController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    // http://localhost:8989/products/rest/product?id=1
    @GetMapping("/product")
    public ProductResponse findProductById(@RequestParam("id") Long id) {
        return new ProductResponse(Collections.singletonList(productService.findProductById(id)));
    }

    // http://localhost:8989/products/rest/user?id=1
    @GetMapping("/user")
    public ProductResponse findByProductWithUser(@RequestParam("id") Long id) {
        return new ProductResponse(productService.findByProductWithUser(userService.findUserById(id).getId()));
    }

}
