package br.dev.hygino.jakarta.resource;

import java.util.List;

import br.dev.hygino.jakarta.dto.RequestProductDTO;
import br.dev.hygino.jakarta.model.Product;
import br.dev.hygino.jakarta.repository.ProductRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") int id) {
        return repository.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product insert(RequestProductDTO dto) {
        return repository.insert(dto);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product update(@PathParam("id") int id, RequestProductDTO dto) {
        return repository.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id) {
        repository.delete(id);
    }
}
