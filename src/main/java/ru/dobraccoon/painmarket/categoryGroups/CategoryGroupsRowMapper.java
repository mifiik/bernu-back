package ru.dobraccoon.painmarket.categoryGroups;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryGroupsRowMapper implements RowMapper<CategoryGroups> {
    @Override
    public CategoryGroups mapRow(ResultSet rs, int RowNum) throws SQLException {
        return new CategoryGroups(
                rs.getLong("id"),
                rs.getLong("catalog_id"),
                rs.getString("name")
        );
    }

}
