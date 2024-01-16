package com.dobraccon.painmarket.repository;

import com.dobraccon.painmarket.config.row_mapper.OrderRowMapper;
import com.dobraccon.painmarket.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class OrderRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Long createOrder(Order order) {
        String sql = "INSERT INTO orders(id, product_id, client_id, price) VALUES " +
                "(nextval('orders_sequence'), :productId, :clientId, :price);";
        return namedParameterJdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("productId", order.getProductId())
                        .addValue("clientId", order.getClientId())
                        .addValue("price", order.getPrice()),
                Long.class);
    }

    public Order findById(long id) {
        String sql = "SELECT * FROM orders WHERE id = :id";
        return namedParameterJdbcTemplate.queryForObject(
                sql,
                new MapSqlParameterSource("id", id),
                new OrderRowMapper()
        );
    }

    public List<Order> findAll() {
        String sql = "SELECT * FROM orders";
        return namedParameterJdbcTemplate.query(sql, new OrderRowMapper());
    }

    public List<Order> findByCustomerId(long customerId) {
        String sql = "SELECT * FROM orders WHERE client_id = :clientId;";
        return namedParameterJdbcTemplate.query(sql,
                new MapSqlParameterSource("clientId", customerId),
                new OrderRowMapper());
    }

    public void deleteByCustomerId(long customerId) {
        String sql = "DELETE FROM orders WHERE client_id = :customerId;";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("clientId", customerId));
    }

    public void deleteByPrice(float price) {
        String sql = "DELETE FROM orders WHERE price = :price;";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("price", price));
    }
}
