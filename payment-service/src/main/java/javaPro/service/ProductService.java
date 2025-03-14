package javaPro.service;

import javaPro.config.properties.IntegrationProperties;
import javaPro.dto.ProductDto;
import javaPro.response.PaymentResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class ProductService {
    private final IntegrationProperties integrationProperties;
    private final RestTemplate restTemplate;

    public ProductService(IntegrationProperties integrationProperties, RestTemplate restTemplate) {
        this.integrationProperties = integrationProperties;
        this.restTemplate = restTemplate;
    }

    public PaymentResponseDto getProductByUser(Long userId) {
        Map<String, String> uidParams = new HashMap<>();
        uidParams.put("uid", userId.toString());
        String property = integrationProperties.getPaymentsPayProperties().getAllPath() + integrationProperties.getPaymentsPayProperties().getUserId();
        PaymentResponseDto paymentResponseDto =  restTemplate.postForObject(
                property,
                null,
                PaymentResponseDto.class,
                uidParams
        );
        return paymentResponseDto;
    }

    public PaymentResponseDto getProductByProductIdAndUserId(Long productId, Long userId) {
        log.info("ProductService, start getProductByProductIdAndUserId, параметры: {} {}", productId, userId);
        Map<String, String> restTemplateParam = new HashMap<>();
        restTemplateParam.put("pid", productId.toString());
        restTemplateParam.put("uid", userId.toString());
        String property = integrationProperties.getPaymentsPayProperties().getAllPath()
                + integrationProperties.getPaymentsPayProperties().getProductId()
                + integrationProperties.getPaymentsPayProperties().getUserId();
        PaymentResponseDto paymentResponseDto =  restTemplate.postForObject(
                property,
                null,
                PaymentResponseDto.class,
                restTemplateParam
        );
        return paymentResponseDto;
    }

    public PaymentResponseDto updateBalance(ProductDto productDto) {
        HttpEntity<ProductDto> productHttpEntity = new HttpEntity<>(productDto);
        String property = integrationProperties.getPaymentsPayProperties().getAllPath()
                + integrationProperties.getPaymentsPayProperties().getPaymentMethod();
        PaymentResponseDto paymentResponseDto = restTemplate.postForObject(
                property,
                productHttpEntity,
                PaymentResponseDto.class
        );
        return paymentResponseDto;
    }

}
