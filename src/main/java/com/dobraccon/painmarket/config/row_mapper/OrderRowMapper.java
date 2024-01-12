package com.dobraccon.painmarket.config.row_mapper;

import com.dobraccon.painmarket.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Order(
                rs.getLong("id"),
                rs.getLong("product_id"),
                rs.getLong("client_id"),
                rs.getLong("price")
        );
    }
}
