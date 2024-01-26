package com.dobraccon.painmarket.products;

import com.dobraccon.painmarket.config.row_mapper.ProductRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ProductRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Long saveProduct(Product product) {
        String sql = "INSERT INTO products(id, name, price, discount) VALUES " +
                "(nextval('products_sequence'), :name, :price, :discount) RETURNING id;";
        return namedParameterJdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("name", product.getName())
                        .addValue("price", product.getPrice())
                        .addValue("discount", product.getDiscount()),
                Long.class);
    }

    public Product findByProductId(long id) {
        String sql = "SELECT * FROM products WHERE id = :id;";
        return namedParameterJdbcTemplate.queryForObject(
                sql,
                new MapSqlParameterSource("id", id),
                new ProductRowMapper()
        );
    }

    public List<Product> findAllProducts() {
        String sql = "SELECT * FROM products";
        return namedParameterJdbcTemplate.query(sql, new ProductRowMapper());
    }

    public List<Product> findProductsByDiscount(int discount) {
        String sql = "SELECT * FROM products WHERE discount = :discount;";
        return namedParameterJdbcTemplate.query(sql,
                new MapSqlParameterSource("discount", discount),
                new ProductRowMapper());
    }

    public void updateProduct(Product product) {
        String sql = "UPDATE products SET name = :name, price = :price, discount = :discount WHERE id = :id;";
        namedParameterJdbcTemplate.update(sql,
                new MapSqlParameterSource("id", product.getId())
                        .addValue("name", product.getName())
                        .addValue("price", product.getPrice())
                        .addValue("discount", product.getDiscount()));
    }

    public void deleteProductByName(String name) {
        namedParameterJdbcTemplate.update("DELETE FROM products WHERE name = :name;",
                new MapSqlParameterSource("name", name));
    }

    public void deleteProductByDiscount(int discount) {
        namedParameterJdbcTemplate.update("DELETE FROM products WHERE discount = :discount;",
                new MapSqlParameterSource("discount", discount));
    }

    public void deleteProductByPriceAndDiscount(float price, int discount) {
        namedParameterJdbcTemplate.update("DELETE FROM products WHERE price = :price AND discount = :discount;",
                new MapSqlParameterSource()
                        .addValue("price", price)
                        .addValue("discount", discount));
    }
}
