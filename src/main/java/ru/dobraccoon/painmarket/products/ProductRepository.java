package ru.dobraccoon.painmarket.products;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    private JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product create(Product newProduct) {
        String sqlInsert = String.format("INSERT INTO product(id, name, price, discount) VALUES (%s,'%s',%s,%s);", Math.random(), newProduct.getName(), newProduct.getPrice(), newProduct.getDiscount());
        jdbcTemplate.execute(sqlInsert);
        return null;
    }
}
