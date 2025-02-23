package br.dev.hygino.jakarta.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
public class Product {
    private Integer id;
    private String name;
    private Double price;
}
