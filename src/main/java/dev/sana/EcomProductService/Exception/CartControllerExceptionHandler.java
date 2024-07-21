package dev.sana.EcomProductService.Exception;

import dev.sana.EcomProductService.Controller.CartController;
import dev.sana.EcomProductService.DTO.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CartController.class)
public class CartControllerExceptionHandler {
    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity handleCartNotFoundException(CartNotFoundException ce){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                ce.getMessage(),
                404
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }
}
