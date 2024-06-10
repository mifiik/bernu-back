package ru.dobraccoon.painmarket.promotions;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PromotionRowMapper implements RowMapper<Promotion> {
    @Override
    public Promotion mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new Promotion(
                rs.getLong("id"),
                rs.getString("image_url"),
                rs.getString("promotion_name"),
                rs.getString("promotion_description"),
                rs.getBoolean("is_promotion_actual")
        );
    }
}
