package ru.dobraccoon.painmarket.feedback;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackRowMapper implements RowMapper<Feedback> {
    @Override
    public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Feedback(
                rs.getLong("id"),
                rs.getLong("customer_id"),
                rs.getLong("product_id"),
                rs.getTimestamp("creation_dt").toLocalDateTime(),
                rs.getString("caption"),
                rs.getString("feedback_text"),
                rs.getInt("rating")
        );
    }
}
