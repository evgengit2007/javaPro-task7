package javaPro.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import javaPro.config.properties.IntegrationProperties;
import javaPro.dto.Product;
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

    public PaymentResponseDto getProductByUser(Long userId) throws JsonProcessingException {
        Map<String, String> uidParams = new HashMap<>();
        uidParams.put("uid", userId.toString());
        System.out.println("Start getProductByUser");
        String property = integrationProperties.getPaymentsPayProperties().getAllPath() + integrationProperties.getPaymentsPayProperties().getUserId();
        System.out.println("getProductByUser, user-id = " + property);
        PaymentResponseDto paymentResponseDto =  restTemplate.postForObject(
                property,
                null,
                PaymentResponseDto.class,
                uidParams
        );
        return paymentResponseDto;
    }

    public PaymentResponseDto getProductByProductIdAndUserId(Long productId, Long userId) throws JsonProcessingException {
        Map<String, String> uidParams = new HashMap<>();
        uidParams.put("pid", productId.toString());
        uidParams.put("uid", userId.toString());
        System.out.println("Start getProductByProductIdAndUserId");
        String property = integrationProperties.getPaymentsPayProperties().getAllPath()
                + integrationProperties.getPaymentsPayProperties().getProductId()
                + integrationProperties.getPaymentsPayProperties().getUserId();
        System.out.println("getProductByProductIdAndUserId, product-and-user-id = "
                + property);
        PaymentResponseDto paymentResponseDto =  restTemplate.postForObject(
                property,
                null,
                PaymentResponseDto.class,
                uidParams
        );
        return paymentResponseDto;
    }

    public PaymentResponseDto updateBalance(Product product) {
        HttpEntity<Product> productHttpEntity = new HttpEntity<>(product);
        String property = integrationProperties.getPaymentsPayProperties().getAllPath()
                + integrationProperties.getPaymentsPayProperties().getProductId()
                + integrationProperties.getPaymentsPayProperties().getUserId();
        System.out.println("updateBalance: " + property);
        PaymentResponseDto paymentResponseDto = restTemplate.postForObject(
                property,
                productHttpEntity,
                PaymentResponseDto.class
        );
        return paymentResponseDto;
    }

}
