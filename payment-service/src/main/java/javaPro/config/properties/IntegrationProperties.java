package javaPro.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "service.integration")
public class IntegrationProperties {

    private final RestTemplateProperties restTemplateProperties;

    public IntegrationProperties(RestTemplateProperties paymentsClient) {
        this.restTemplateProperties = paymentsClient;
    }

    public RestTemplateProperties getPaymentsPayProperties() {
        return restTemplateProperties;
    }
}
