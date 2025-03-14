package javaPro.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import javaPro.dto.PaymentDto;
import javaPro.response.PaymentCheckResponse;
import javaPro.response.PaymentResponseDto;
import javaPro.service.PaymentService;
import javaPro.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/api/payments")
public class PaymentController {

    private final PaymentService paymentService;
    private final ProductService productService;

    public PaymentController(PaymentService paymentService, ProductService productService) {
        this.paymentService = paymentService;
        this.productService = productService;
    }

    // Образец: http://localhost:8990/v1/api/payments/user/1
    @GetMapping("/user/{userId}")
    public PaymentResponseDto getProductByUserId(@PathVariable Long userId) {
        return productService.getProductByUser(userId);
    }

    // Образец: http://localhost:8990/v1/api/payments/product/1/user/1
    @GetMapping("/product/{productId}/user/{userId}")
    public PaymentResponseDto getProductByProductIdAndUserId(@PathVariable Long productId, @PathVariable Long userId) {
        log.info("Старт поиска продукта по id продукта и id юзера: {} {} ", productId, userId);
        return productService.getProductByProductIdAndUserId(productId, userId);
    }

    // Образец
/*
{
    "product_id": 1,
    "user_id": 1,
    "account_number": "31321321",
    "sum_pay": 10.12
}
*/
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponseDto createPayment(@RequestBody PaymentDto paymentDto) throws JsonProcessingException {
        log.info("Start createPayment");
        return paymentService.executePayment(paymentDto);
    }
}
