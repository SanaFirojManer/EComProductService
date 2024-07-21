package dev.sana.EcomProductService.Exception;

import dev.sana.EcomProductService.Controller.ProductController;
import dev.sana.EcomProductService.DTO.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductServiceExceptionHandler {

    @ExceptionHandler({ProductNotFoundException.class,NoProductPresentException.class})
    public ResponseEntity handleNoProductException(ProductNotFoundException pe){
    ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
            pe.getMessage(),
            404
    );
    return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
}


    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity handleProductNotFoundException(InvalidInputException ie){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                ie.getMessage(),
                400
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
    }


}
