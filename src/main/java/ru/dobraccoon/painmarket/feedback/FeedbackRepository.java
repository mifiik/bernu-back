package ru.dobraccoon.painmarket.feedback;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository

public class FeedbackRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    private static final String sqlLoadByProductId = "SELECT * FROM feedbacks WHERE product_id = :productId";

    public FeedbackRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("feedbacks")
                .usingGeneratedKeyColumns("id");
    }

    public void create(Feedback feedback) {
        simpleJdbcInsert.execute(
                new MapSqlParameterSource()
                        .addValue("customerId", feedback.getCustomerId())
                        .addValue("productId", feedback.getProductId())
                        .addValue("caption", feedback.getCaption())
                        .addValue("feedbackText", feedback.getFeedbackText())
                        .addValue("rating", feedback.getRating())
        );
    }

    public List<Feedback> loadByProductId(long productId) {
        return namedParameterJdbcTemplate.query(
                sqlLoadByProductId,
                new MapSqlParameterSource("productId", productId),
                new FeedbackRowMapper());
    }

}
