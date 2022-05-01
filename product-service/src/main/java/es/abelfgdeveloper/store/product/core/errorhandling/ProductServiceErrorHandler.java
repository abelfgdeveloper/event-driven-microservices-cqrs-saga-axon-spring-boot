package es.abelfgdeveloper.store.product.core.errorhandling;

import java.util.Date;
import org.axonframework.commandhandling.CommandExecutionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ProductServiceErrorHandler {

  @ExceptionHandler(value = {IllegalArgumentException.class})
  public ResponseEntity<Object> handleIllegalArgumentException(
      IllegalArgumentException ex, WebRequest request) {

    ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());

    return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = {Exception.class})
  public ResponseEntity<Object> handleOtherException(Exception ex, WebRequest request) {
    ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
    return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = {CommandExecutionException.class})
  public ResponseEntity<Object> handleCommandExecutionException(
      CommandExecutionException ex, WebRequest request) {
    ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
    return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
