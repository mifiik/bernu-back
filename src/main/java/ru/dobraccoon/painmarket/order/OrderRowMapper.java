package ru.dobraccoon.painmarket.order;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Order(
                rs.getLong("id"),
                rs.getLong("customer_id"),
                rs.getLong("status_id"),
                rs.getLong("price")
        );
    }
}
