package ru.dobraccoon.painmarket.categories;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int RowNum) throws SQLException {
        return new Category(
                rs.getLong("id"),
                rs.getLong("category_group_id"),
                rs.getString("name")
        );
    }
}
