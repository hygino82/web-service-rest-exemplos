package br.dev.hygino.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.dev.hygino.config.DatabaseConfig;

import br.dev.hygino.model.Product;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository {

    private static final String SELECT_PRODUCTS = "SELECT * FROM product";

    public List<Product> getProducts() {
    System.out.println("Listando produtos");
    List<Product> products = new ArrayList<>();

    try (Connection connection = DatabaseConfig.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SELECT_PRODUCTS);
            ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            products.add(mapProduct(rs));
        }
    } catch (SQLException e) {
        // Lidar com a exceção de forma mais robusta
        System.err.println("Erro ao listar produtos: " + e.getMessage());
        // Você pode querer retornar uma lista vazia ou lançar uma exceção personalizada
        return new ArrayList<>();
    }

    return products;
}

    private Product mapProduct(ResultSet rs) throws SQLException {
        return new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDouble("price")
        );
    }
}
