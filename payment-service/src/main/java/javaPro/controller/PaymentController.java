package javaPro.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import javaPro.dto.PaymentDto;
import javaPro.response.PaymentCheckResponse;
import javaPro.response.PaymentResponseDto;
import javaPro.service.PaymentService;
import javaPro.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


@Slf4j
@RestController
@RequestMapping("/v1/api/payments")
public class PaymentController {
    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    private final PaymentService paymentService;
    private final ProductService productService;

    public PaymentController(PaymentService paymentService, ProductService productService) {
        this.paymentService = paymentService;
        this.productService = productService;
    }

    // так работает
    // http://localhost:8990/v1/api/payments/user/1
    @GetMapping("/user/{userId}")
    public PaymentResponseDto getProductByUserId(@PathVariable Long userId) throws JsonProcessingException {
        System.out.println("Start PaymentController, getProductByUserId: " + userId);
        return productService.getProductByUser(userId);
    }

    @GetMapping("/product/{productId}/user/{userId}")
    public PaymentResponseDto getProductByProductIdAndUserId(@PathVariable Long productId, @PathVariable Long userId) throws JsonProcessingException {
        System.out.println("Start PaymentController, getProductByProductIdAndUserId: userId = " + userId + ", productId = " + productId);
        return productService.getProductByProductIdAndUserId(productId, userId);
    }

    // рабочий пример
/*
    {
        "product_id": 1,
            "user_id": 1,
            "account_number": "31321321",
            "sum_pay": 123.12
    }
*/
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentCheckResponse createPayment(@RequestBody PaymentDto paymentDto) throws JsonProcessingException {
        logger.info("Start createPayment");
        System.out.println("Start createPayment");
        System.out.println(paymentDto.toString());
        var response = paymentService.executePayment(paymentDto);
        return new PaymentCheckResponse("Result: " + response);
    }
}
