package ru.dobraccoon.painmarket.promotions;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.dobraccoon.painmarket.products.Product;
import ru.dobraccoon.painmarket.products.ProductRowMapper;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PromotionRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    private static final String sqlLoadById = "SELECT * FROM promotions WHERE id = :promotionId;";
    private static final String sqlUpdate = "UPDATE promotions SET image_url = :imageUrl, promotion_name = :promotionName," +
            "promotion_description = :promotionDescription, is_promotion_actual = :isPromotionActual" +
            " WHERE id = :promotionId;";
    private static final String sqlDeleteById = "DELETE FROM promotions WHERE id = :promotionId;";

    private static final String sqlAddProductIdToPromotion = "INSERT INTO xref_promotions_2_products(promotion_id, product_id)\n" +
            "VALUES (:promotionId, :productId);";

    private static final String sqlLoadAll = "SELECT * FROM promotions;";

    private static final String sqlLoadAllActualPromotions = "SELECT * FROM promotions WHERE is_promotion_actual = true;";

    private static final String sqlLoadAllProductsByPromotionId = "SELECT *\n" +
            "FROM products p\n" +
            "         LEFT JOIN xref_promotions_2_products xp2p ON p.id = xp2p.product_id\n" +
            "WHERE xp2p.promotion_id = :promotionId;";

    public PromotionRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("promotions")
                .usingGeneratedKeyColumns("id");
    }

    public Promotion create(Promotion newPromotion) {
        long newPromotionId = simpleJdbcInsert.executeAndReturnKey(
                new MapSqlParameterSource()
                        .addValue("imageUrl", newPromotion.getImageUrl())
                        .addValue("promotionName", newPromotion.getPromotionName())
                        .addValue("promotionDescription", newPromotion.getPromotionDescription())
                        .addValue("isPromotionActual", newPromotion.isPromotionActual())
        ).longValue();

        newPromotion.setId(newPromotionId);

        return newPromotion;
    }

    public Promotion loadById(long promotionId) {
        return namedParameterJdbcTemplate.queryForObject(
                sqlLoadById,
                new MapSqlParameterSource("promotionId", promotionId),
                new PromotionRowMapper());
    }

    public List<Promotion> loadAll() {
        return namedParameterJdbcTemplate.query(
                sqlLoadAll,
                new PromotionRowMapper());
    }

    public List<Promotion> loadAllActualPromotions() {
        return namedParameterJdbcTemplate.query(
                sqlLoadAllActualPromotions,
                new PromotionRowMapper());
    }

    public List<Product> loadAllProductsByPromotionId(long promotionId) {
        return namedParameterJdbcTemplate.query(
                sqlLoadAllProductsByPromotionId,
                new MapSqlParameterSource()
                        .addValue("promotionId", promotionId),
                new ProductRowMapper());
    }

    public void update(Promotion promotion) {
        namedParameterJdbcTemplate.update(
                sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("promotionId", promotion.getId())
                        .addValue("imageUrl", promotion.getImageUrl())
                        .addValue("promotionName", promotion.getPromotionName())
                        .addValue("promotionDescription", promotion.getPromotionDescription())
                        .addValue("isPromotionActual", promotion.isPromotionActual())
        );
    }

    public void deleteById(long promotionId) {
        namedParameterJdbcTemplate.update(
                sqlDeleteById,
                new MapSqlParameterSource("promotionId", promotionId));
    }

    public void addListOfProductsToPromotion(ProductsToPromotionInput productsToPromotionInput) {
        productsToPromotionInput.getProductsIds().forEach(productId -> {
                    namedParameterJdbcTemplate.update(
                            sqlAddProductIdToPromotion,
                            new MapSqlParameterSource()
                                    .addValue("promotionId", productsToPromotionInput.getPromotionId())
                                    .addValue("productId", productId)
                    );
                }
        );
    }
}
