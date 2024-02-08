package ru.dobraccoon.painmarket.catalog;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CatalogRepository {
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    SimpleJdbcInsert simpleJdbcInsert;

    private static final String sqlLoadAll = "SELECT * FROM catalogs;";

    private static final String sqlLoadById = "SELECT * FROM catalogs WHERE id = :catalogId;";

    private static final String sqlDeleteById = "DELETE FROM catalogs WHERE id = :catalogId;";

    private static final String sqlUpdate = "UPDATE catalogs SET name = :name WHERE id = :catalogId;";

    public CatalogRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("catalogs")
                .usingGeneratedKeyColumns("id");
    }

    public List<Catalog> loadAll() {
        return namedParameterJdbcTemplate.query(sqlLoadAll, new CatalogRowMapper());
    }

    public Catalog loadById(long id) {
        return namedParameterJdbcTemplate.queryForObject(
                sqlLoadById,
                new MapSqlParameterSource("catalogId", id),
                new CatalogRowMapper());
    }

    public void deleteById(long id) {
        namedParameterJdbcTemplate.update(
                sqlDeleteById,
                new MapSqlParameterSource("catalogId", id));
    }

    public void update(Catalog catalog) {
        namedParameterJdbcTemplate.update(
                sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("catalogId", catalog.getId())
                        .addValue("name", catalog.getName())
        );
    }

    public void create(Catalog newCatalog) {
        simpleJdbcInsert.execute(
                new MapSqlParameterSource()
                        .addValue("name", newCatalog.getName())
        );
    }
}
