package com.dobraccon.painmarket.repository;

import com.dobraccon.painmarket.config.row_mapper.ProductRowMapper;
import com.dobraccon.painmarket.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductRepository {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void saveProduct(Product product) {
        String sql = String.format(
                "INSERT INTO products(id, name, price, discount) " +
                        "VALUES(nextval('products_sequence'), '%s', '%s', '%s');",
                product.getName(),
                product.getPrice(),
                product.getDiscount());
        jdbcTemplate.execute(sql);
    }

    public Product findByProductId(long id) {
        String sql = "SELECT * FROM product WHERE id = :id";
        return namedParameterJdbcTemplate.queryForObject(
                sql,
                new MapSqlParameterSource("id", id),
                new ProductRowMapper()
        );
    }
}
