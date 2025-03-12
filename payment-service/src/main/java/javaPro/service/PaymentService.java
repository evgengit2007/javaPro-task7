package javaPro.service;

import javaPro.dto.PaymentDto;
import javaPro.dto.ProductDto;
import javaPro.exception.PaymentParamException;
import javaPro.response.PaymentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final ProductService productService;

    public PaymentService(ProductService productService) {
        this.productService = productService;
    }
/*
    private final String paymentMethod;
    private final RestTemplate restTemplate;

    public PaymentService(RestTemplate restTemplate,
                          @Value("${service.integration.payments-client.payment-method}") String paymentMethod) {
        this.restTemplate = restTemplate;
        this.paymentMethod = paymentMethod;
    }
*/

    public PaymentResponseDto executePayment(PaymentDto paymentDto) {
        System.out.println("Start executePayment");
        if ((paymentDto.getProductId() == null && paymentDto.getAccountNumber() == null)
            || paymentDto.getUserId() == null || paymentDto.getSumPay() == null) {
            throw new PaymentParamException("Неверные параметры платежа");
        }
        return this.productService.getProductByUser(paymentDto.getProductId());


/*
        return restTemplate.postForObject(
                paymentMethod,
                null,
                PaymentResponseDto.class
        );
*/
    }
}
