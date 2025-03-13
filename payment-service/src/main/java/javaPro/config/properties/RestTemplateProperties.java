package javaPro.config.properties;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class RestTemplateProperties {

    private final String allPath;
    private final String uri;
    private final Duration connectTimeout;
    private final Duration readTimeout;
    private final String productId;
    private final String userId;
    private final String sum;
    private final String accountNumber;
    private final String paymentMethod;

    public RestTemplateProperties(String allPath,
                                  String uri,
                                  Duration connectTimeout,
                                  Duration readTimeout,
                                  String productId,
                                  String userId,
                                  String sum,
                                  String accountNumber,
                                  String paymentMethod)
    {
        this.allPath = allPath;
        this.uri = uri;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.productId = productId;
        this.userId = userId;
        this.sum = sum;
        this.accountNumber = accountNumber;
        this.paymentMethod = paymentMethod;
    }
}
