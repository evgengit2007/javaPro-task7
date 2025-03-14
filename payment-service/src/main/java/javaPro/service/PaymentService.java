package javaPro.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import javaPro.dto.PaymentDto;
import javaPro.dto.ProductDto;
import javaPro.exception.ExceptionLowBalance;
import javaPro.exception.ExceptionPaymentParam;
import javaPro.exception.ExceptionProductNotFound;
import javaPro.response.PaymentResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class PaymentService {

    private final ProductService productService;

    public PaymentService(ProductService productService) {
        this.productService = productService;
    }

    public PaymentResponseDto executePayment(PaymentDto paymentDto) throws JsonProcessingException {
        log.info("Start executePayment");
        if ((paymentDto.getProductId() == null && paymentDto.getAccountNumber() == null)
            || paymentDto.getUserId() == null || paymentDto.getSumPay() == null) {
            throw new ExceptionPaymentParam("Invalid payment parameters");
        }
        List<ProductDto> productListDto = productService.getProductByProductIdAndUserId(paymentDto.getProductId(), paymentDto.getUserId()).getProductListDto();
        if (productListDto == null || productListDto.size() != 1) {
            throw new ExceptionProductNotFound("Product not found!");
        }
        ProductDto productDto = productListDto.get(0);
        BigDecimal balance = productDto.getBalance();
        if (Objects.isNull(balance) || balance.compareTo(paymentDto.getSumPay()) < 0) {
            throw new ExceptionLowBalance("The account balance is less than sum pay!");
        }
        productDto.setBalance(balance.subtract(paymentDto.getSumPay()));
        this.productService.updateBalance(productDto);

        return new PaymentResponseDto(List.of(productDto));
    }
}
