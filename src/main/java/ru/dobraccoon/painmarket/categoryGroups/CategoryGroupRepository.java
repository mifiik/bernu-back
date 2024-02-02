package ru.dobraccoon.painmarket.categoryGroups;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CategoryGroupRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    SimpleJdbcInsert simpleJdbcInsert;

    private static final String sqlLoadById = "SELECT * FROM category_groups WHERE id = :id;";

    private static final String sqlDeleteById = "DELETE FROM category_groups WHERE id = :categoryGroupId;";

    private static final String sqlUpdate = "UPDATE category_groups" +
            " SET catalog_id = :catalogId," +
            "name = :name WHERE id = :id;";

    private static final String sqlLoadByCategoryGroupId = "SELECT * FROM category_groups " +
            "WHERE catalog_id = :catalogId;";

    public CategoryGroupRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("category_groups")
                .usingGeneratedKeyColumns("id");
    }

    public CategoryGroup loadById(long id) {
        return namedParameterJdbcTemplate.queryForObject(
                sqlLoadById,
                new MapSqlParameterSource("id", id),
                new CategoryGroupRowMapper());
    }

    public void deleteById(long id) {
        namedParameterJdbcTemplate.update(
                sqlDeleteById,
                new MapSqlParameterSource("categoryGroupId", id));
    }

    public void update(CategoryGroup categoryGroup) {
        namedParameterJdbcTemplate.update(
                sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("id", categoryGroup.getId())
                        .addValue("catalogId", categoryGroup.getCatalogId())
                        .addValue("name", categoryGroup.getName())
        );
    }

    public CategoryGroup create(CategoryGroup newCategoryGroup) {
        long newCategoryGroupId = simpleJdbcInsert.executeAndReturnKey(
                new MapSqlParameterSource()
                        .addValue("catalogId", newCategoryGroup.getCatalogId())
                        .addValue("name", newCategoryGroup.getName())
        ).longValue();

        newCategoryGroup.setId(newCategoryGroupId);

        return newCategoryGroup;
    }

    public List<CategoryGroup> loadByCategoryGroupId(long catalogId) {
        return namedParameterJdbcTemplate.query(
                sqlLoadByCategoryGroupId,
                new MapSqlParameterSource("catalogId", catalogId),
                new CategoryGroupRowMapper()
        );
    }
}
