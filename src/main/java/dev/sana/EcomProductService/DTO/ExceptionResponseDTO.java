package dev.sana.EcomProductService.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class ExceptionResponseDTO {
    private String message;
    private int code;

    public ExceptionResponseDTO(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
