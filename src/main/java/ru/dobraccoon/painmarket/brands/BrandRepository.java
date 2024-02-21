package ru.dobraccoon.painmarket.brands;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;


@Repository
public class BrandRepository {
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    SimpleJdbcInsert simpleJdbcInsert;
    private static final String sqlLoadById = "SELECT * FROM brands WHERE id = :brandId;";
    private static final String sqlDeleteById = "DELETE FROM brands WHERE id = :brandId;";
    private static final String sqlUpdate = "UPDATE brands SET image_url = :imageUrl, name = :name " +
            "WHERE id = :brandId;";

    private static final String sqlLoadByNameSubStr = "SELECT * FROM brands " +
            "WHERE LOWER(name) LIKE LOWER(:nameSubStr)";


    public BrandRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("brands")
                .usingGeneratedKeyColumns("id");
    }

    public Brand create(Brand newBrand) {
        long newBrandId = simpleJdbcInsert.executeAndReturnKey(
                new MapSqlParameterSource()
                        .addValue("image_url", newBrand.getImageUrl())
                        .addValue("name", newBrand.getName())
        ).longValue();

        newBrand.setId(newBrandId);

        return newBrand;
    }

    public Brand loadById(long brandId) {
        return namedParameterJdbcTemplate.queryForObject(
                sqlLoadById,
                new MapSqlParameterSource("brandId", brandId),
                new BrandRowMapper());
    }

    public void update(Brand brand) {
        namedParameterJdbcTemplate.update(
                sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("brandId", brand.getId())
                        .addValue("imageUrl", brand.getImageUrl())
                        .addValue("name", brand.getName())
        );
    }

    public void deleteById(long id) {
        namedParameterJdbcTemplate.update(
                sqlDeleteById,
                new MapSqlParameterSource("brandId", id));
    }

    public List<Brand> loadByNameSubStr(String nameSubStr) {
        return namedParameterJdbcTemplate.query(
                sqlLoadByNameSubStr,
                new MapSqlParameterSource("nameSubStr", "%" + nameSubStr + "%"),
                new BrandRowMapper());
    }
}
