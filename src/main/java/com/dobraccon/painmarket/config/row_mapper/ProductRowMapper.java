package com.dobraccon.painmarket.config.row_mapper;

import com.dobraccon.painmarket.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getFloat("price"),
                rs.getInt("discount")
        );
    }
}
