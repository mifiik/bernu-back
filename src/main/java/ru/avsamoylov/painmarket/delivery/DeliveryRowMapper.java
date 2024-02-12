package ru.avsamoylov.painmarket.delivery;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryRowMapper implements RowMapper<Delivery> {
    @Override
    public Delivery mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Delivery(
                rs.getLong("id"),
                rs.getLong("order_id"),
                rs.getLong("customer_id"),
                rs.getString("address")
        );
    }
}
