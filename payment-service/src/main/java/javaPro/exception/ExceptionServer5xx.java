package javaPro.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExceptionServer5xx {
    private String path;
    private String error;
    private String status;
    private Timestamp timestamp;


    public String getPath() {
        return path;
    }

    public String getError() {
        return error;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
