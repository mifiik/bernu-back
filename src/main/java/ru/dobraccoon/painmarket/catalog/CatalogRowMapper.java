package ru.dobraccoon.painmarket.catalog;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CatalogRowMapper implements RowMapper<Catalog> {
    @Override
    public Catalog mapRow(ResultSet rs, int RowNum) throws SQLException {
        return new Catalog(
                rs.getLong("id"),
                rs.getString("name")
        );
    }
}
