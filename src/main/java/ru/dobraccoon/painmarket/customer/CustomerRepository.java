package ru.dobraccoon.painmarket.customer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Customer create(Customer newCustomer) {
        String createSQL = String.format("INSERT INTO" +
                        " customers(id, image_url," +
                        "law_entity, email, phone_country_code, phone_number," +
                        "firstName, last_name, password, city, street, cityIndex)" +
                        " VALUES (%s, '%s', %s, '%s', %s, %s, '%s', '%s', '%s', '%s', '%s', %s)",
                "nextval('customers_sequence')",
                newCustomer.getImageUrl(),
                newCustomer.isLawEntity(),
                newCustomer.getEmail(),
                newCustomer.getPhoneCountryCode(),
                newCustomer.getPhoneNumber(),
                newCustomer.getFirstName(),
                newCustomer.getLastName(),
                newCustomer.getPassword(),
                newCustomer.getCity(),
                newCustomer.getStreet(),
                newCustomer.getCityIndex());

        jdbcTemplate.execute(createSQL);
        return null;
    }

    public void deleteById(long id) {
        String sqlDeleteById = String.format("DELETE FROM customers WHERE id = %s;", id);

        jdbcTemplate.execute(sqlDeleteById);
    }

    public void deleteByEmail(String email) {
        String sqlDeleteByEmail = String.format("DELETE FROM customers WHERE email = '%s';", email);
        jdbcTemplate.execute(sqlDeleteByEmail);
    }

    public void Update(Customer customer) {
        String sqlUpdate = String.format("""
                        UPDATE customers
                        SET email = '%s'
                        WHERE id = %s;""",
                customer.getEmail(),
                customer.getId()
        );
        jdbcTemplate.update(sqlUpdate);
    }

    public Customer loadById(long customerId) {
        String sqlLoadById = String.format("SELECT * FROM customers WHERE id = %s;", customerId);

        return jdbcTemplate.queryForObject(sqlLoadById, new CustomerRowMapper());
    }

    public List<Customer> loadAll() {
        String sqlLoadAll = "SELECT * FROM customers;";

        return jdbcTemplate.query(sqlLoadAll, new CustomerRowMapper());
    }
}
