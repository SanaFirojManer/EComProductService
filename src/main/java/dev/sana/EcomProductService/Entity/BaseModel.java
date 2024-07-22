package dev.sana.EcomProductService.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @CreationTimestamp
    private Instant createdAt;  // number of seconds/nanoseconds since 1 Jan, 1970 UTC
    @UpdateTimestamp
    private Instant updatedAt; // number of seconds/nanoseconds since 1 Jan, 1970 UTC

}
