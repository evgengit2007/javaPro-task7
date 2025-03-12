package javaPro.service;

import javaPro.config.properties.IntegrationProperties;
import javaPro.response.PaymentResponseDto;
import lombok.extern.slf4j.Slf4j;
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
        return restTemplate.postForObject(
                integrationProperties.getPaymentsPayProperties().getPaymentMethod(),
                null,
                PaymentResponseDto.class,
                uidParams
        );
    }


}
