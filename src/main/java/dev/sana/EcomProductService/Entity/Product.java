package dev.sana.EcomProductService.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "ECOM_PRODUCT")
@SequenceGenerator(name = "product_seq", sequenceName = "hibernate_sequence", allocationSize = 1)
public class Product extends BaseModel{
    private String title;
    private double price;
    private String description;

    @ManyToOne
    private Category category;
    private String imageURL;
    private String rating;
}
