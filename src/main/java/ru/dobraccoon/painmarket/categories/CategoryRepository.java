package ru.dobraccoon.painmarket.categories;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CategoryRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    private static final String sqlLoadById = "SELECT * FROM categories WHERE id = :categoryId;";

    private static final String sqlDeleteById = "DELETE FROM categories WHERE id = :categoryId;";

    private static final String sqlUpdate = "UPDATE categories" +
            " SET category_group_id = :categoryGroupId," +
            "name = :name WHERE id = :id;";

    private static final String sqlLoadByGroupId = "SELECT * FROM categories " +
            "WHERE category_group_id = :categoryGroupId;";

    private static final String sqlLoadByCatalogId = """
            SELECT  c.* FROM categories c
            JOIN category_groups cg ON c.category_group_id = cg.id
            WHERE cg.catalog_id = :catalogId;
            """;


    public CategoryRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("categories")
                .usingGeneratedKeyColumns("id");
    }


    public Category loadById(long categoryId) {
        return namedParameterJdbcTemplate.queryForObject(
                sqlLoadById,
                new MapSqlParameterSource("categoryId", categoryId),
                new CategoryRowMapper());
    }

    public void deleteById(long id) {
        namedParameterJdbcTemplate.update(
                sqlDeleteById,
                new MapSqlParameterSource("categoryId", id));
    }

    public void update(Category category) {
        namedParameterJdbcTemplate.update(
                sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("id", category.getId())
                        .addValue("categoryGroupId", category.getCategoryGroupId())
                        .addValue("name", category.getName())
        );
    }

    public Category create(Category newCategory) {
        long newCategoryId = simpleJdbcInsert.executeAndReturnKey(
                new MapSqlParameterSource()
                        .addValue("categoryGroupId", newCategory.getCategoryGroupId())
                        .addValue("name", newCategory.getName())
        ).longValue();


        newCategory.setId(newCategoryId);

        return newCategory;

    }

    public List<Category> loadByGroupId(long categoryGroupId) {
        return namedParameterJdbcTemplate.query(
                sqlLoadByGroupId,
                new MapSqlParameterSource("categoryGroupId", categoryGroupId),
                new CategoryRowMapper()
        );
    }

    public List<Category> loadByCatalogId(long catalogId) {
        return namedParameterJdbcTemplate.query(
                sqlLoadByCatalogId,
                new MapSqlParameterSource("catalogId", catalogId),
                new CategoryRowMapper());
    }
}
