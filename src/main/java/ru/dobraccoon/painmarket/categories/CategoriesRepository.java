package ru.dobraccoon.painmarket.categories;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CategoriesRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    private static final String sqlLoadAll = "SELECT * FROM categories;";
    private static final String sqlLoadById = "SELECT * FROM categories WHERE id = :hui;";

    private static final String sqlDeleteById = "DELETE FROM categories WHERE id = :catId;";

    private static final String sqlUpdate = "UPDATE categories" +
            " SET category_group_id = :categoryGroupId," +
            "name = :name WHERE id = :id;";

    private static final String sqlLoadByGroupId = "SELECT * FROM categories " +
            "WHERE category_group_id = :categoryGroupsId;";

    private static final String sqlLoadByCatalogId = """
            SELECT  c.* FROM categories c
            JOIN category_groups cg ON c.category_group_id = cg.id
            WHERE cg.catalog_id = :catalogId;
            """;


    public CategoriesRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("categories")
                .usingGeneratedKeyColumns("id");
    }

    public List<Categories> loadAll() {
        return namedParameterJdbcTemplate.query(sqlLoadAll, new CategoriesRowMapper());
    }

    public Categories loadById(long categoriesId) {
        return namedParameterJdbcTemplate.queryForObject(
                sqlLoadById,
                new MapSqlParameterSource("hui", categoriesId),
                new CategoriesRowMapper());
    }

    public void deleteById(long id) {
        namedParameterJdbcTemplate.update(
                sqlDeleteById,
                new MapSqlParameterSource("catId", id));
    }

    public void update(Categories categories) {
        namedParameterJdbcTemplate.update(
                sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("id", categories.getId())
                        .addValue("categoryGroupId", categories.getCategoryGroupId())
                        .addValue("name", categories.getName())
        );
    }

    public void create(Categories newCategories) {
        simpleJdbcInsert.execute(
                new MapSqlParameterSource()
                        .addValue("categoryGroupId", newCategories.getCategoryGroupId())
                        .addValue("name", newCategories.getName())
        );
    }

    public List<Categories> loadByGroupId(long categoryGroupsId) {
        return namedParameterJdbcTemplate.query(
                sqlLoadByGroupId,
                new MapSqlParameterSource("categoryGroupsId", categoryGroupsId),
                new CategoriesRowMapper()
        );
    }

    public List<Categories> loadByCatalogId(long catalogId) {
        return namedParameterJdbcTemplate.query(
                sqlLoadByCatalogId,
                new MapSqlParameterSource("catalogId", catalogId),
                new CategoriesRowMapper());
    }
}
