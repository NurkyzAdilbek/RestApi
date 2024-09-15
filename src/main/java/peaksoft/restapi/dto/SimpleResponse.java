package peaksoft.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@AllArgsConstructor
@Builder
public class SimpleResponse {
    public HttpStatus status;
    private String message;

}
