package ru.dobraccoon.painmarket.products;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product create(Product newProduct) {
        String sqlInsert = String.format("INSERT INTO products(id, primary_price," +
                        " current_price,discount, is_new, image_url, description," +
                        "min_delivery_days, max_delivery_days, rating, review_count) VALUES (%s,%s,%s,%s,%s,'%s'," +
                        "'%s',%s,%s,%s,%s);",
                "nextval('products_sequence')",
                newProduct.getPrimaryPrice(),
                newProduct.getCurrentPrice(),
                newProduct.getDiscount(),
                newProduct.isNea(),
                newProduct.getImageUrl(),
                newProduct.getDescription(),
                newProduct.getMinDeliveryDays(),
                newProduct.getMaxDeliveryDays(),
                newProduct.getRating(),
                newProduct.getReviewCount());

        jdbcTemplate.execute(sqlInsert);
        return null;
    }

    public void update(Product product) {

        if (Objects.isNull(product.getId())) {
            throw new NullPointerException();
        }

        loadById(product.getId());

        String sqlUpdate = String.format(
                """
                        UPDATE products
                        SET primary_price = %s,
                            current_price = %s,
                            discount = %s,
                            is_new = %s,
                            image_url = '%s',
                            description = '%s',
                            min_delivery_days = %s,
                            max_delivery_days = %s,
                            rating = %s,
                            review_count = %s
                        WHERE id = %s;""",
                product.getPrimaryPrice(),
                product.getCurrentPrice(),
                product.getDiscount(),
                product.isNea(),
                product.getImageUrl(),
                product.getDescription(),
                product.getMinDeliveryDays(),
                product.getMaxDeliveryDays(),
                product.getRating(),
                product.getReviewCount(),
                product.getId()
        );

        jdbcTemplate.update(sqlUpdate);
    }

    public void deleteById(long productId) {
        String sqlDeleteById = String.format("DELETE FROM products WHERE id = %s;", productId);
        jdbcTemplate.execute(sqlDeleteById);
    }

    public void deleteByPrimaryPrice(float primaryPrice) {
        String sqlDeleteByPrimaryPrice = String.format("DELETE FROM products WHERE primary_price = %s;", primaryPrice);
        jdbcTemplate.execute(sqlDeleteByPrimaryPrice);
    }

    public void deleteByDescription(String description) {
        String sqlDeleteByDescription = String.format("DELETE FROM products WHERE description = '%s';", description);
        jdbcTemplate.execute(sqlDeleteByDescription);
    }

    public Product loadById(long productId) {
        String sqlLoadById = String.format("SELECT * FROM products WHERE id = %s;", productId);

        return jdbcTemplate.queryForObject(sqlLoadById, new ProductRowMapper());
    }

    public List<Product> loadAll() {
        String sqlLoadAll = "SELECT * FROM products;";

        return jdbcTemplate.query(sqlLoadAll, new ProductRowMapper());
    }

    public List<Product> loadByCurrentPrice(float currentPrice) {
        String sqlLoadByCurrentPrice = String.format("SELECT * FROM products WHERE current_price = %s;", currentPrice);

        return jdbcTemplate.query(sqlLoadByCurrentPrice, new ProductRowMapper());
    }

    public List<Product> loadByDiscount(int discount) {
        String sqlLoadByDiscount = String.format("SELECT * FROM products WHERE discount = %s;", discount);

        return jdbcTemplate.query(sqlLoadByDiscount, new ProductRowMapper());
    }

}
