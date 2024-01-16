package com.dobraccon.painmarket.repository;

import com.dobraccon.painmarket.config.row_mapper.OrderRowMapper;
import com.dobraccon.painmarket.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class OrderRepository {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void createOrder(Order order) {
        String sql = String.format(
                "INSERT INTO orders(id, product_id, client_id, price) " +
                        "VALUES(nextval('orders_sequence'), '%s', '%s', '%s');",
                order.getProductId(),
                order.getClientId(),
                order.getPrice()
        );
        jdbcTemplate.execute(sql);
    }

    public Order findByOrderId(long id) {
        String sql = "SELECT * FROM orders WHERE id = :id";
        return namedParameterJdbcTemplate.queryForObject(
                sql,
                new MapSqlParameterSource("id", id),
                new OrderRowMapper()
        );
    }

    public List<Order> findAllOrders() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, new OrderRowMapper());
    }

    public List<Order> findOrdersByConsumerId(long customerId) {
        String sql = "SELECT * FROM orders WHERE client_id = :client_id;";
        return namedParameterJdbcTemplate.query(sql,
                new MapSqlParameterSource("client_id", customerId),
                new OrderRowMapper());
    }

    public void deleteOrder(long clientId) {
        String sql = "DELETE FROM orders WHERE client_id = :clientId;";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("clientId", clientId));
    }

    public void  deleteOrder(float price) {
        String sql = "DELETE FROM orders WHERE price = :price;";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("price", price));
    }
}
