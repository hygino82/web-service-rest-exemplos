package br.dev.hygino.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.dev.hygino.config.DatabaseConfig;
import br.dev.hygino.dto.RequestProductDTO;

import br.dev.hygino.model.Product;
import jakarta.enterprise.context.ApplicationScoped;
import java.sql.Statement;
import java.util.Optional;

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

    public Product insert(RequestProductDTO dto) {
        final String INSERT_PRODUCT = "INSERT INTO product (name, price) VALUES (?, ?)";
        try (Connection connection = DatabaseConfig.getDataSource().getConnection();
                PreparedStatement stmt = connection.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, dto.getName());
            stmt.setDouble(2, dto.getPrice());
            stmt.executeUpdate();
            connection.commit();
            // Recupera o ID do produto inserido
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    return new Product(id, dto.getName(), dto.getPrice());
                } else {
                    throw new SQLException("Não foi possível recuperar o ID gerado");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir produto: " + e.getMessage());
            return null;
        }
    }

    public Optional<Product> findById(int id) {
        var FIND_PRODUCT = "SELECT * FROM product WHERE id = ?";
        try (Connection connection = DatabaseConfig.getDataSource().getConnection();
                PreparedStatement stmt = connection.prepareStatement(FIND_PRODUCT)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapProduct(rs));
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao encontrar produto: " + e.getMessage());
            return null; // ou lança uma exceção se preferir
        }
    }

    public void delete(int id) {
        final String REMOVE_PRODUCT = "DELETE FROM product WHERE id = ?";
        try (Connection connection = DatabaseConfig.getDataSource().getConnection();
                PreparedStatement stmt = connection.prepareStatement(REMOVE_PRODUCT)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao remover produto: " + e.getMessage());
        }
    }

    public Product update(int id, RequestProductDTO dto) {
        final String UPDATE_PRODUCT = "UPDATE product SET name = ?, price = ? WHERE id = ?";
        try (Connection connection = DatabaseConfig.getDataSource().getConnection();
                PreparedStatement stmt = connection.prepareStatement(UPDATE_PRODUCT)) {
            stmt.setString(1, dto.getName());
            stmt.setDouble(2, dto.getPrice());
            stmt.setInt(3, id);
            stmt.executeUpdate();
            return findById(id).get();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
            return null;
        }
    }
}
