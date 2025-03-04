package br.dev.hygino.repository;

import br.dev.hygino.dto.RequestProductDTO;
import br.dev.hygino.model.Product;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository {
    private static List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1, "Radio", 45.6),
                new Product(2, "TV", 900.45),
                new Product(3, "Ventilador", 124.95)));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product insert(RequestProductDTO dto) {
        int newId = (int) (Math.random() * 1000);
        Product product = new Product();
        product.setId(newId);
        dtoToModel(dto, product);
        products.add(product);

        return product;
    }

    private void dtoToModel(RequestProductDTO dto, Product product) {
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
    }

    public void delete(int id) {
        products.removeIf(x -> x.getId() == id);
    }

    public Product update(int id, RequestProductDTO dto) {
        Product res = products.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Não existe produto com o id: " + id));

        res.setName(dto.getName());
        res.setPrice(dto.getPrice());
        return res;
    }

    public Product findById(int id) {
        return products.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Não existe produto com o id: " + id));
    }
}