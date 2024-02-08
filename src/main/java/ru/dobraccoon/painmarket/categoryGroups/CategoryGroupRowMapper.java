package ru.dobraccoon.painmarket.categoryGroups;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryGroupRowMapper implements RowMapper<CategoryGroup> {
    @Override
    public CategoryGroup mapRow(ResultSet rs, int RowNum) throws SQLException {
        return new CategoryGroup(
                rs.getLong("id"),
                rs.getLong("catalog_id"),
                rs.getString("name")
        );
    }

}