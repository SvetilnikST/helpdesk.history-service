package innowise.helpdesk.historyservice.exception;

import innowise.helpdesk.historyservice.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HistoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleHistoryNotFoundException(HistoryNotFoundException exception){
        return ErrorResponse.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
