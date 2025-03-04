package br.dev.hygino.config;

import br.dev.hygino.resource.ProductResource;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("api")
public class AppConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(ProductResource.class);
        classes.add(JacksonJsonProvider.class); // Registrar o provedor JSON
        return classes;
    }
}
