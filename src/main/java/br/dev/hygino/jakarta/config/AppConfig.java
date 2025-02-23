package br.dev.hygino.jakarta.config;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import br.dev.hygino.jakarta.resource.ProductResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class AppConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(ProductResource.class);
        classes.add(JacksonJsonProvider.class); // Registrar o provedor JSON
        return classes;
    }
}