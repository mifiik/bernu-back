package ru.dobraccoon.painmarket.products;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(
                rs.getLong("id"),
                rs.getFloat("primary_price"),
                rs.getFloat("current_price"),
                rs.getBoolean("is_new"),
                rs.getString("image_url"),
                rs.getString("description"),
                rs.getInt("mindelivery_days"),
                rs.getInt("maxdelivery_days"),
                rs.getFloat("rating"),
                rs.getInt("review_count")
        );
    }
}
