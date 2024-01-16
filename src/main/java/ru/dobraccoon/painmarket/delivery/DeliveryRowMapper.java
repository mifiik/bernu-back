package ru.dobraccoon.painmarket.delivery;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryRowMapper implements RowMapper<Delivery> {
    @Override
    public Delivery mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Delivery(
                rs.getLong("id"),
                rs.getLong("order_id"),
                rs.getBoolean("required_fields"),
                rs.getString("city"),
                rs.getString("street"),
                rs.getInt("postcode"),
                rs.getString("text_area"),
                rs.getFloat("delivery_price"),
                rs.getInt("discount"),
                rs.getFloat("total_amount")

        );
    }
}
