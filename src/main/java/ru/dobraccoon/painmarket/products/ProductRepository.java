package ru.dobraccoon.painmarket.products;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    public ProductRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSourcet) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSourcet)
                .withTableName("products")
                .usingGeneratedKeyColumns("id");
    }

    public void create(Product newProduct) {
        simpleJdbcInsert.execute(
                new MapSqlParameterSource()
                        .addValue("primaryPrice", newProduct.getPrimaryPrice())
                        .addValue("currentPrice", newProduct.getCurrentPrice())
                        .addValue("discount", newProduct.getDiscount())
                        .addValue("new_product", newProduct.isNewProduct())
                        .addValue("imageUrl", newProduct.getImageUrl())
                        .addValue("description", newProduct.getDescription())
                        .addValue("minDeliveryDays", newProduct.getMinDeliveryDays())
                        .addValue("maxDeliveryDays", newProduct.getMaxDeliveryDays())
                        .addValue("rating", newProduct.getRating())
                        .addValue("reviewCount", newProduct.getReviewCount())
        );
    }

    public void update(Product product) {

        if (Objects.isNull(product.getId())) {
            throw new NullPointerException();
        }

        loadById(product.getId());


        String sqlUpdate = "UPDATE products SET primary_price = :primaryPrice, current_price = :currentPrice," +
                " discount = :discount, new_product = :new_product, image_url = :imageUrl,  description = :description," +
                "min_delivery_days = :minDeliveryDays, max_delivery_days = :maxDeliveryDays," +
                "rating = :rating, review_count = :reviewCount" +
                " WHERE id = :id;";

        namedParameterJdbcTemplate.update(
                sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("primaryPrice", product.getPrimaryPrice())
                        .addValue("currentPrice", product.getCurrentPrice())
                        .addValue("discount", product.getDiscount())
                        .addValue("new_product", product.isNewProduct())
                        .addValue("imageUrl", product.getImageUrl())
                        .addValue("description", product.getDescription())
                        .addValue("minDeliveryDays", product.getMinDeliveryDays())
                        .addValue("maxDeliveryDays", product.getMaxDeliveryDays())
                        .addValue("rating", product.getRating())
                        .addValue("reviewCount", product.getReviewCount())
        );
    }

    public void deleteById(long productId) {
        String sqlDeleteById = "DELETE FROM products WHERE id = :productId;";
        namedParameterJdbcTemplate.update(
                sqlDeleteById,
                new MapSqlParameterSource("productId", productId));
    }

    public void deleteByPrimaryPrice(float primaryPrice) {
        String sqlDeleteByPrimaryPrice = "DELETE FROM products WHERE primary_price = :primaryPrice;";
        namedParameterJdbcTemplate.update(
                sqlDeleteByPrimaryPrice,
                new MapSqlParameterSource("primary_price", primaryPrice));
    }

    public void deleteByDescription(String description) {
        String sqlDeleteByDescription = "DELETE FROM products WHERE description = :description;";
        namedParameterJdbcTemplate.update(
                sqlDeleteByDescription,
                new MapSqlParameterSource("description", description));
    }

    public Product loadById(long productId) {
        String sqlLoadById = "SELECT * FROM products WHERE id = :productId;";

        return namedParameterJdbcTemplate.queryForObject(
                sqlLoadById,
                new MapSqlParameterSource("productId", productId),
                new ProductRowMapper());
    }

    public List<Product> loadAll() {
        String sqlLoadAll = "SELECT * FROM products;";

        return namedParameterJdbcTemplate.query(sqlLoadAll, new ProductRowMapper());
    }

    public List<Product> loadByCurrentPrice(float currentPrice) {
        String sqlLoadByCurrentPrice = "SELECT * FROM products WHERE current_price = :currentPrice;";

        return namedParameterJdbcTemplate.query(
                sqlLoadByCurrentPrice,
                new MapSqlParameterSource("currentPrice", currentPrice),
                new ProductRowMapper());
    }

    public List<Product> loadByDiscount(int discount) {
        String sqlLoadByDiscount = "SELECT * FROM products WHERE discount = :discount;";

        return namedParameterJdbcTemplate.query(
                sqlLoadByDiscount,
                new MapSqlParameterSource("discount", discount),
                new ProductRowMapper());
    }

}
