package dev.sana.EcomProductService.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Product {
    private int productId;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private String rating;
}
