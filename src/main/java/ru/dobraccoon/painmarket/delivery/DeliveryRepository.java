package ru.dobraccoon.painmarket.delivery;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DeliveryRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    public DeliveryRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("deliveries")
                .usingGeneratedKeyColumns("id");
    }

    public void create(Delivery delivery) {
        simpleJdbcInsert.execute(
                new MapSqlParameterSource()
                        .addValue("orderId", delivery.getOrderId())
                        .addValue("customerId", delivery.getCustomerId())
                        .addValue("address", delivery.getAddress())
        );
    }

    public void deleteById(long id) {
        String sqlDeleteById = "DELETE FROM deliveries WHERE id = :id;";
        namedParameterJdbcTemplate.update(
                sqlDeleteById,
                new MapSqlParameterSource("id", id));
    }

    public void deleteByOrderIdAndCustomerId(long orderId, long customerId) {
        String sqlDeleteByOrderIdAndCustomerId =
                "DELETE FROM deliveries WHERE order_id = :orderId AND customer_id = :customerId;";

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("orderId", orderId)
                .addValue("customerId", customerId);

        namedParameterJdbcTemplate.update(sqlDeleteByOrderIdAndCustomerId, parameters);
    }

    public void deleteByAddress(String address) {
        String sqlDeleteByAddress = "DELETE FROM deliveries WHERE address = :address;";

        namedParameterJdbcTemplate.update(
                sqlDeleteByAddress,
                new MapSqlParameterSource("address", address));
    }

    public void update(Delivery delivery) {
        String sqlUpdate =
                "UPDATE deliveries " +
                        "SET order_id = :orderId, " +
                        "customer_id = :customerId," +
                        "address = '%s'WHERE id = :id;";

        namedParameterJdbcTemplate.update(
                sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("orderId", delivery.getOrderId())
                        .addValue("customerId", delivery.getCustomerId())
                        .addValue("id", delivery.getCustomerId())
        );

    }

    public Delivery loadById(long deliveryId) {
        String sqlLoadById = "SELECT * FROM deliveries WHERE id = :deliveryId;";

        return namedParameterJdbcTemplate.queryForObject(
                sqlLoadById,
                new MapSqlParameterSource("deliveryId", deliveryId),
                new DeliveryRowMapper());
    }

    public List<Delivery> loadAll() {
        String sqlLoadAll = "SELECT * FROM deliveries;";

        return namedParameterJdbcTemplate.query(sqlLoadAll, new DeliveryRowMapper());
    }

    public List<Delivery> loadByAddress(String address) {
        String sqlLoadByAddress = "SELECT * FROM deliveries WHERE address = :address;";

        return namedParameterJdbcTemplate.query(
                sqlLoadByAddress,
                new MapSqlParameterSource("address", address),
                new DeliveryRowMapper());
    }
}






