package br.dev.hygino.jakarta.repository;

import java.util.Arrays;
import java.util.List;

import br.dev.hygino.jakarta.model.Product;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository {
    private static List<Product> products;

    public ProductRepository() {
        products = Arrays.asList(
                new Product(1, "Radio", 45.6),
                new Product(2, "TV", 900.45),
                new Product(3, "Ventilador", 124.95));
    }

    public List<Product> getProducts() {
        return products;
    }
}
