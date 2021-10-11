package application.program.middlewares;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleAPIException(Exception exception, WebRequest request) {
        return new ResponseEntity<>(
                exception, new HttpHeaders(), HttpStatus.BAD_REQUEST
        );
    }
}
