package javaPro.config;

import javaPro.config.properties.IntegrationProperties;
import javaPro.config.properties.RestTemplateProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(IntegrationProperties.class)
public class AppConfig {
    private final IntegrationProperties integrationProperties;


    public AppConfig(IntegrationProperties integrationProperties) {
        this.integrationProperties = integrationProperties;
    }

    @Bean
    public RestTemplate paymentsStructure() {
        RestTemplateProperties restTemplateProperties = integrationProperties.getPaymentsPayProperties();
        System.out.println("Uri = " + restTemplateProperties.getUri());
        System.out.println("product-id = " + restTemplateProperties.getProductId());
        System.out.println("user-id = " + restTemplateProperties.getUserId());
        System.out.println("sum = " + restTemplateProperties.getSum());
        System.out.println("account-number = " + restTemplateProperties.getAccountNumber());

        return new RestTemplateBuilder()
                .rootUri(restTemplateProperties.getUri())
                .connectTimeout(restTemplateProperties.getConnectTimeout())
                .readTimeout(restTemplateProperties.getReadTimeout())
//                .errorHandler(errorHandler) // позже передать в сигнатуре метода класс RestTemplateResponseErrorHandler
                .build();
    }

    public String getProductId() {
        return integrationProperties.getPaymentsPayProperties().getProductId();
    }
}
