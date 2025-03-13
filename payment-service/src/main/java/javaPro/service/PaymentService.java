package javaPro.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import javaPro.dto.PaymentDto;
import javaPro.dto.Product;
import javaPro.exception.LowBalanceException;
import javaPro.exception.PaymentParamException;
import javaPro.exception.ProductNotFoundException;
import javaPro.response.PaymentResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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

    public PaymentResponseDto executePayment(PaymentDto paymentDto) throws JsonProcessingException {
        System.out.println("Start executePayment");
        if ((paymentDto.getProductId() == null && paymentDto.getAccountNumber() == null)
            || paymentDto.getUserId() == null || paymentDto.getSumPay() == null) {
            throw new PaymentParamException("Неверные параметры платежа");
        }
        List<Product> productList = productService.getProductByProductIdAndUserId(paymentDto.getProductId(), paymentDto.getUserId()).getProductList();
        if (productList == null || productList.size() != 1) {
            throw new ProductNotFoundException("Product not found!");
        }
        Product product = productList.get(0);
        BigDecimal balance = product.getBalance();
        if (Objects.isNull(balance) || balance.compareTo(paymentDto.getSumPay()) < 0) {
            throw new LowBalanceException("Low balance!");
        }
        product.setBalance(balance.subtract(paymentDto.getSumPay()));
        this.productService.updateBalance(product);

        return new PaymentResponseDto(List.of(product));
    }
}
