package ru.dobraccoon.painmarket.customer;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CustomerRepository {

    private static final String sqlDeleteById = "DELETE FROM customers WHERE id = :id;";

    private static final String sqlDeleteByEmail = "DELETE FROM customers WHERE email = :email;";
    private static final String sqlUpdate = "UPDATE customers  SET" +
            " image_url = :imageUrl, law_entity = :lawEntity, email = :email," +
            "phone_country_code = :phoneCountryCode, phone_number = :phoneNumber," +
            "first_name = :firstName, last_name = :lastName, password = :password," +
            "city = :city, street = :street, city_index = :cityIndex" +
            "   WHERE id = :id";
    private static final String sqlLoadById = "SELECT * FROM customers WHERE id = :customerId;";
    private static final String sqlLoadAll = "SELECT * FROM customers;";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public CustomerRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("customers")
                .usingGeneratedKeyColumns("id");
    }

    public Customer create(Customer newCustomer) {
        long newCustomerId = simpleJdbcInsert.executeAndReturnKey(
                new MapSqlParameterSource()
                        .addValue("imageUrl", newCustomer.getImageUrl())
                        .addValue("lawEntity", newCustomer.isLawEntity())
                        .addValue("email", newCustomer.getEmail())
                        .addValue("phoneCountryCode", newCustomer.getPhoneCountryCode())
                        .addValue("phoneNumber", newCustomer.getPhoneNumber())
                        .addValue("firstName", newCustomer.getFirstName())
                        .addValue("lastName", newCustomer.getLastName())
                        .addValue("password", newCustomer.getPassword())
                        .addValue("city", newCustomer.getCity())
                        .addValue("street", newCustomer.getStreet())
                        .addValue("cityIndex", newCustomer.getCityIndex())
        ).longValue();

        newCustomer.setId(newCustomerId);

        return newCustomer;
    }

    public void deleteById(long id) {
        namedParameterJdbcTemplate.update(
                sqlDeleteById,
                new MapSqlParameterSource("id", id));
    }

    public void deleteByEmail(String email) {
        namedParameterJdbcTemplate.update(
                sqlDeleteByEmail,
                new MapSqlParameterSource("email", email));
    }

    public void update(Customer customer) {
        namedParameterJdbcTemplate.update(
                sqlUpdate,
                new MapSqlParameterSource()
                        .addValue("imageUrl", customer.getImageUrl())
                        .addValue("lawEntity", customer.isLawEntity())
                        .addValue("email", customer.getEmail())
                        .addValue("phoneCountryCode", customer.getPhoneCountryCode())
                        .addValue("phoneNumber", customer.getPhoneNumber())
                        .addValue("firstName", customer.getFirstName())
                        .addValue("lastName", customer.getLastName())
                        .addValue("password", customer.getPassword())
                        .addValue("city", customer.getCity())
                        .addValue("street", customer.getStreet())
                        .addValue("cityIndex", customer.getCityIndex())
                        .addValue("id", customer.getId())
        );
    }

    public Customer loadById(long customerId) {
        return namedParameterJdbcTemplate.queryForObject(
                sqlLoadById,
                new MapSqlParameterSource("customerId", customerId),
                new CustomerRowMapper());

    }

    public List<Customer> loadAll() {
        return namedParameterJdbcTemplate.query(sqlLoadAll, new CustomerRowMapper());
    }
}
