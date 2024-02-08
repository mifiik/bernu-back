package ru.dobraccoon.painmarket.feedback;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class FeedbackRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    private static final String sqlLoadByProductId = "SELECT * FROM feedbacks WHERE product_id = :productId";

    public FeedbackRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("feedbacks")
                .usingGeneratedKeyColumns("id");
    }

    public Feedback create(Feedback newFeedback) {
        long newFeedbackId = simpleJdbcInsert.executeAndReturnKey(
                new MapSqlParameterSource()
                        .addValue("customerId", newFeedback.getCustomerId())
                        .addValue("productId", newFeedback.getProductId())
                        .addValue("caption", newFeedback.getCaption())
                        .addValue("feedbackText", newFeedback.getFeedbackText())
                        .addValue("rating", newFeedback.getRating())
        ).longValue();

        newFeedback.setId(newFeedbackId);

        return newFeedback;
    }

    public List<Feedback> loadByProductId(long productId) {
        return namedParameterJdbcTemplate.query(
                sqlLoadByProductId,
                new MapSqlParameterSource("productId", productId),
                new FeedbackRowMapper());
    }

}
