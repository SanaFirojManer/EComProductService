package dev.sana.EcomProductService.Exception;

public class NoProductPresentException extends RuntimeException{
    public NoProductPresentException(String message) {
        super(message);
    }
}
