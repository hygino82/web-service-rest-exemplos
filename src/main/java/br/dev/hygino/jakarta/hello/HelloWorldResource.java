package br.dev.hygino.jakarta.hello;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello") // Parâmetro de caminho
public class HelloWorldResource {

    @GET
   @ Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("name") String name) { // Alterado para @PathParam
        if ((name == null) || name.trim().isEmpty()) {
            name = "world";
        }

        return "Hello: " + name;
    }
}