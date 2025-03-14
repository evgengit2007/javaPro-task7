package javaPro.config.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import javaPro.exception.ExceptionProductNotFound;
import javaPro.exception.ExceptionServer5xx;
import javaPro.exception.ExceptionIntegration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.net.URI;

@Slf4j
@Component
public class ErrorPathRestTemplate implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        log.info("Response error {} : {}", response.getStatusCode(), response.getStatusText());
        return response.getStatusCode().is5xxServerError() ||  response.getStatusCode().is4xxClientError();
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {

        if (response.getStatusCode().is5xxServerError()) {
            ObjectMapper mapper = new ObjectMapper();
            ExceptionServer5xx server5xx = mapper.readValue(response.getBody(), ExceptionServer5xx.class);
            throw new ExceptionIntegration("Error 5XX: ", server5xx);
        } else if (response.getStatusCode().is4xxClientError()) {
            throw new ExceptionProductNotFound("Error 4XX: Product not found");
        }
    }
}
