package br.dev.hygino.resource;

import br.dev.hygino.dto.RequestProductDTO;
import br.dev.hygino.model.Product;
import br.dev.hygino.repository.ProductRepository;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("product")
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
    
   /* @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product insert(JsonObject jsonData) {
        RequestProductDTO dto = new RequestProductDTO();
        dto.setName(jsonData.getString("name"));
        dto.setPrice(jsonData.getJsonNumber("price").doubleValue());
        return repository.insert(dto);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product update(@PathParam("id") int id, JsonObject jsonData) {
        RequestProductDTO dto = new RequestProductDTO();
        dto.setName(jsonData.getString("name"));
        dto.setPrice(jsonData.getJsonNumber("price").doubleValue());
        return repository.update(id, dto);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") int id) {
        return repository.findById(id);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id) {
        repository.delete(id);
    }*/
}