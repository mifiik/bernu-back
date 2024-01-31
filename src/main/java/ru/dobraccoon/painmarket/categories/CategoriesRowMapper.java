package ru.dobraccoon.painmarket.categories;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriesRowMapper implements RowMapper<Categories> {
    @Override
    public Categories mapRow(ResultSet rs, int RowNum) throws SQLException {
        return new Categories(
                rs.getLong("id"),
                rs.getLong("category_group_id"),
                rs.getString("name")
        );
    }
}
