package com.dobraccon.painmarket.orders;

import com.dobraccon.painmarket.config.row_mapper.OrderRowMapper;
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
        String sql = "INSERT INTO orders(id, product_id, customerId, price) VALUES " +
                "(nextval('orders_sequence'), :productId, :customerId, :price);";
        return namedParameterJdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("productId", order.getProductId())
                        .addValue("customerId", order.getCustomerId())
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
        String sql = "SELECT * FROM orders WHERE customerId = :customerId;";
        return namedParameterJdbcTemplate.query(sql,
                new MapSqlParameterSource("customerId", customerId),
                new OrderRowMapper());
    }

    public void deleteByCustomerId(long customerId) {
        String sql = "DELETE FROM orders WHERE customerId = :customerId;";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("customerId", customerId));
    }

    public void deleteByPrice(float price) {
        String sql = "DELETE FROM orders WHERE price = :price;";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("price", price));
    }
}
