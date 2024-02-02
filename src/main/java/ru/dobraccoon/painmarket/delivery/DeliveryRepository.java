package ru.dobraccoon.painmarket.delivery;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DeliveryRepository {
    private static final String sqlDeleteById = "DELETE FROM deliveries WHERE id = :id;";

    private static final String sqlDeleteByOrderId =
            "DELETE FROM deliveries WHERE order_id = :orderId;";

    private static final String sqlDeleteByPostcode =
            "DELETE FROM deliveries WHERE postcode = :postcode;";

    private static final String sqlUpdate = """
            UPDATE deliveries
            SET order_id        = :orderId,
                city            = :city,
                street          = :street,
                postcode        = :postcode,
                information_for_courier  = :informationForCourier,
                delivery_price  = :deliveryPrice,
                discount        = :discount,
                total_amount    = :totalAmount
            WHERE id = :id""";

    private static final String sqlLoadById =
            "SELECT * FROM deliveries WHERE id = :deliveryId;";

    private static final String sqlLoadByStatusId =
            "SELECT * FROM deliveries WHERE status_id = :statusId";

    private static final String sqlLoadAll =
            "SELECT * FROM deliveries;";

    private static final String sqlLoadByPostcode =
            "SELECT * FROM deliveries WHERE postcode = :postcode;";

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
                        .addValue("city", delivery.getCity())
                        .addValue("street", delivery.getStreet())
                        .addValue("postcode", delivery.getPostcode())
                        .addValue("informationForCourier", delivery.getInformationForCourier())
                        .addValue("deliveryPrice", delivery.getDeliveryPrice())
                        .addValue("discount", delivery.getDiscount())
                        .addValue("totalAmount", delivery.getTotalAmount())
        );
    }

    public void deleteById(long id) {
        namedParameterJdbcTemplate.update(
                sqlDeleteById,
                new MapSqlParameterSource("id", id));
    }

    public void deleteByOrderId(long orderId) {
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("orderId", orderId);

        namedParameterJdbcTemplate.update(sqlDeleteByOrderId, parameters);
    }

    public void deleteByPostcode(int postcode) {
        namedParameterJdbcTemplate.update(
                sqlDeleteByPostcode,
                new MapSqlParameterSource("postcode", postcode));
    }

    public void update(Delivery delivery) {
        namedParameterJdbcTemplate.update(
                sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("orderId", delivery.getOrderId())
                        .addValue("city", delivery.getCity())
                        .addValue("street", delivery.getStreet())
                        .addValue("postcode", delivery.getPostcode())
                        .addValue("informationForCourier", delivery.getInformationForCourier())
                        .addValue("deliveryPrice", delivery.getDeliveryPrice())
                        .addValue("discount", delivery.getDiscount())
                        .addValue("totalAmount", delivery.getTotalAmount())
        );

    }

    public Delivery loadById(long deliveryId) {
        return namedParameterJdbcTemplate.queryForObject(
                sqlLoadById,
                new MapSqlParameterSource("deliveryId", deliveryId),
                new DeliveryRowMapper());
    }

    public List<Delivery> loadAll() {
        return namedParameterJdbcTemplate.query(sqlLoadAll, new DeliveryRowMapper());
    }

    public List<Delivery> loadByStatusId(long statusId) {
        return namedParameterJdbcTemplate.query(
                sqlLoadByStatusId,
                new MapSqlParameterSource("statusId", statusId),
                new DeliveryRowMapper());
    }

    public List<Delivery> loadByPostcode(int postcode) {
        return namedParameterJdbcTemplate.query(
                sqlLoadByPostcode,
                new MapSqlParameterSource("postcode", postcode),
                new DeliveryRowMapper());
    }
}






