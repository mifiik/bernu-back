package ru.dobraccoon.painmarket.products;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product create(Product newProduct) {
        String sqlInsert = String.format("INSERT INTO product(id, name, price, discount) VALUES (%s,'%s',%s,%s);",
                "nextval('product_sequence')",
                newProduct.getName(),
                newProduct.getPrice(),
                newProduct.getDiscount());

        jdbcTemplate.execute(sqlInsert);
        return null;
    }

    public void update(Product product) {
        String sqlUpdate = String.format(
                """
                        UPDATE product
                        SET name     = '%s',
                            price    = %s,
                            discount = %s
                        WHERE id = %s;""",
                product.getName(),
                product.getPrice(),
                product.getDiscount(),
                product.getId()
        );

        jdbcTemplate.update(sqlUpdate);
    }

    public void deleteById(long productId) {
        String sqlDeleteById = String.format("DELETE FROM product WHERE id = %s;", productId);

        jdbcTemplate.execute(sqlDeleteById);
    }

    public void deleteByPriceAndDiscount(float price, int discount) {
        String sqlDeleteByPriceAndDiscount = String.format(
                "DELETE FROM product WHERE price = %s AND discount = %s;",
                price,
                discount
        );

        jdbcTemplate.execute(sqlDeleteByPriceAndDiscount);
    }

    public Product loadById(long productId) {
        String sqlLoadById = String.format("SELECT * FROM product WHERE id = %s", productId);

        return jdbcTemplate.queryForObject(sqlLoadById, new ProductRowMapper());
    }

    public List<Product> loadAll() {
        String sqlLoadAll = "SELECT * FROM product;";

        return jdbcTemplate.query(sqlLoadAll, new ProductRowMapper());
    }

    public List<Product> loadByDiscount(int discount) {
        String sqlLoadByDiscount = String.format("SELECT * FROM product WHERE discount = %s", discount);

        return jdbcTemplate.query(sqlLoadByDiscount, new ProductRowMapper());
    }
}
