package javaPro.controller;

import javaPro.dto.PaymentDto;
import javaPro.response.PaymentCheckResponse;
import javaPro.response.PaymentResponseDto;
import javaPro.service.PaymentService;
import javaPro.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    // http://localhost:8990/v1/api/payments/create?user_id=1
    @GetMapping("/{user_id}")
    public PaymentResponseDto getProductByUserId(@RequestParam("user_id") Long userId) {
        return productService.getProductByUser(userId);
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
    public PaymentCheckResponse createPayment(@RequestBody PaymentDto paymentDto) {
        logger.info("Start createPayment");
        System.out.println("Start createPayment");
        System.out.println(paymentDto.toString());
        var response = paymentService.executePayment(paymentDto);
        return new PaymentCheckResponse("Result: " + response);
    }
}
