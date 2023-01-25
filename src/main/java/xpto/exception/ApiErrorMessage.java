package xpto.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiErrorMessage {

    private HttpStatus status;
    private String error;

    public ApiErrorMessage(HttpStatus status, String error) {
        super();
        this.status = status;
        this.error = error;
    }
}
