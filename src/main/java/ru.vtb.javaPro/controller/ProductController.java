package ru.vtb.javaPro.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.vtb.javaPro.dto.ErrorResponseLocal;
import ru.vtb.javaPro.dto.ProductDto;
import ru.vtb.javaPro.dto.ProductResponse;
import ru.vtb.javaPro.service.ProductService;
import ru.vtb.javaPro.service.UserService;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/v1/api/products")
public class ProductController {

    private final ProductService productService;
    private final UserService userService;

    public ProductController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    // Образец: http://localhost:8989/products/v1/api/products/product/1
    @RequestMapping("/product/{id}")
    public ProductResponse findProductById(@PathVariable Long id) {
        return new ProductResponse(Collections.singletonList(productService.findProductById(id)));
    }

    // Образец: http://localhost:8989/products/v1/api/products/user/1
    @RequestMapping("/user/{uid}")
    public ProductResponse findByProductWithUser(@PathVariable Long uid) {
        return new ProductResponse(productService.findByProductWithUser(uid));
    }

    // Образец: http://localhost:8989/products/v1/api/products/product/1/user/1
    @RequestMapping("/product/{pid}/user/{uid}")
    public ProductResponse findProductByPidAndUid(@PathVariable Long pid, @PathVariable Long uid) {
        log.info("Запуск поиска продукта по id продукта и id юзера, метод findProductByPidAndUid: {} {}", pid, uid);
        ProductResponse productResponse = new ProductResponse(Collections.singletonList(productService.findProductByPidAndUid(pid, uid)));
        productResponse.productListDto().forEach(System.out::println);
        return productResponse;
    }

    @PostMapping("/create")
    public ProductResponse updateBalance(@RequestBody ProductDto productDto) {
        log.info("updateBalance: {}", productDto);
        return new ProductResponse(List.of(productService.create(productDto)));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponseLocal handlerEntityNotFoundException(EntityNotFoundException e){
        return  new ErrorResponseLocal(HttpStatus.NOT_FOUND.name(), "Product not found");
    }

}
