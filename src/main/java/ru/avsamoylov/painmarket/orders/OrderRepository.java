package ru.avsamoylov.painmarket.orders;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class OrderRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Long createOrder(Order order) {
        String sql = "INSERT INTO orders(id, product_id, customer_id, price) VALUES " +
                "(naxtval('orders_sequence'), :productId, :customerId, price);";
        return namedParameterJdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("productId", order.getProductId())
                        .addValue("customerId", order.getCustomerId())
                        .addValue("price", order.getPrice()),
                Long.class);
    }

    public Order findById(long id) {
        String sql = "SELECT * FROM orders WHERE id = :id";
        return namedParameterJdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource("id", id),
                new OrderRowMapper()
        );
    }
}
