package ru.avsamoylov.painmarket.products;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Long saveProduct(Product product) {
        String sql = "INSERT INTO product(id, name, price, discount) VALUES " +
                "(nextval('products_sequens), ':name', :price, :discount);";
        return namedParameterJdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("name", product.getName())
                        .addValue("price", product.getPrice())
                        .addValue("discount", product.getDiscount()),
                Long.class);
    }

    public void updateProduct(Product product) {
        String sql = "UPDATE product SET name = ':name', price = :price, discount = :discount WHERE id = :id;";
        namedParameterJdbcTemplate.update(sql,
                new MapSqlParameterSource("id", product.getId())
                        .addValue("name", product.getName())
                        .addValue("price", product.getPrice())
                        .addValue("discount", product.getDiscount()));
    }
}
