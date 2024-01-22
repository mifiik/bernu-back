package ru.avsamoylov.painmarket.delivery;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DeliveryRepository {
    private NamedParameterJdbcTemplate namedParameterJDBCTemplate;

    public Long createDelivery(Delivery delivery) {
        String sql = "INSERT INTO delivery(id, order_id, customer_id, address) VALUE" +
                "(nextval('delivery_sequence'), :orderId, :customerId, ':address');";
        return namedParameterJDBCTemplate.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("orderId", delivery.getOrderId())
                        .addValue("customerId", delivery.getCustomerId())
                        .addValue("address", delivery.getAddress()),
        Long.class);
    }
}
