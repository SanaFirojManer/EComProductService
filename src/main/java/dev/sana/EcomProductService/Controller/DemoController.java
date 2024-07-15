package dev.sana.EcomProductService.Controller;

import dev.sana.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.sana.EcomProductService.ServiceImpl.FakeStoreProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {
    @GetMapping("/hello")
    public ResponseEntity hello(){
        return ResponseEntity.ok("Hello");
    }

    @DeleteMapping("/hi")
    public ResponseEntity hi(){
        return ResponseEntity.ok("Hi");
    }



}
