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
import jakarta.ws.rs.core.Response;
import java.util.Optional;

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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(JsonObject jsonData) {
        RequestProductDTO dto = new RequestProductDTO();
        dto.setName(jsonData.getString("name"));
        dto.setPrice(jsonData.getJsonNumber("price").doubleValue());
        Product product = repository.insert(dto);
        return Response.status(Response.Status.CREATED).entity(product).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") int id) {
        Optional<Product> res = repository.findById(id);

        if (res.isPresent()) {
            return Response.status(Response.Status.OK).entity(res.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Produto não encontrado").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id) {
        repository.delete(id);
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
}
