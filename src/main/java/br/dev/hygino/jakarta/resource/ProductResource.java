package br.dev.hygino.jakarta.resource;

import java.util.List;

import br.dev.hygino.jakarta.model.Product;
import br.dev.hygino.jakarta.repository.ProductRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/product")
public class ProductResource {
    private final ProductRepository repository;

    @Inject
    public ProductResource(ProductRepository repository) {
        this.repository = repository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts() {
        System.out.println("Método getAllProducts() chamado!");
        return repository.getProducts();
    }
}
