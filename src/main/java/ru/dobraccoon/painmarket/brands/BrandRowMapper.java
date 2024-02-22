package ru.dobraccoon.painmarket.brands;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRowMapper implements RowMapper<Brand> {
    @Override
    public Brand mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Brand(
                rs.getLong("id"),
                rs.getString("image_url"),
                rs.getString("name")
        );
    }
}
