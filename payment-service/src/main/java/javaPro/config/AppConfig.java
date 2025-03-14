package javaPro.config;

import javaPro.config.component.ErrorPathRestTemplate;
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
    public RestTemplate paymentsStructure(ErrorPathRestTemplate errorPathRestTemplate) {
        RestTemplateProperties restTemplateProperties = integrationProperties.getPaymentsPayProperties();

        return new RestTemplateBuilder()
                .rootUri(restTemplateProperties.getUri())
                .connectTimeout(restTemplateProperties.getConnectTimeout())
                .readTimeout(restTemplateProperties.getReadTimeout())
                .errorHandler(errorPathRestTemplate)
                .build();
    }

/*
    public String getProductId() {
        return integrationProperties.getPaymentsPayProperties().getProductId();
    }
*/
}
