package ru.dobraccoon.painmarket.categoryGroups;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CategoryGroupsRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    SimpleJdbcInsert simpleJdbcInsert;

    private static final String sqlLoadById = "SELECT * FROM category_groups WHERE id = :id;";

    private static final String sqlDeleteById = "DELETE FROM category_groups WHERE id = :catGroupID;";

    private static final String sqlUpdate = "UPDATE category_groups" +
            " SET catalog_id = :catalogId," +
            "name = :name WHERE id = :id;";

    private static final String sqlLoadByCategoryGroupsId = "SELECT * FROM category_groups " +
            "WHERE catalog_id = :catalogId;";

    public CategoryGroupsRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("category_groups")
                .usingGeneratedKeyColumns("id");
    }

    public CategoryGroups loadById(long id) {
        return namedParameterJdbcTemplate.queryForObject(
                sqlLoadById,
                new MapSqlParameterSource("id", id),
                new CategoryGroupsRowMapper());
    }

    public void deleteById(long id) {
        namedParameterJdbcTemplate.update(
                sqlDeleteById,
                new MapSqlParameterSource("catGroupID", id));
    }

    public void update(CategoryGroups categoryGroups) {
        namedParameterJdbcTemplate.update(
                sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("id", categoryGroups.getId())
                        .addValue("catalogId", categoryGroups.getCatalogId())
                        .addValue("name", categoryGroups.getName())
        );
    }

    public void create(CategoryGroups newCategoryGroups) {
        simpleJdbcInsert.execute(
                new MapSqlParameterSource()
                        .addValue("catalogId", newCategoryGroups.getCatalogId())
                        .addValue("name", newCategoryGroups.getName())
        );
    }

    public List<CategoryGroups> loadByCategoryGroupsId(long catalogId) {
        return namedParameterJdbcTemplate.query(
                sqlLoadByCategoryGroupsId,
                new MapSqlParameterSource("catalogId", catalogId),
                new CategoryGroupsRowMapper()
        );
    }
}
