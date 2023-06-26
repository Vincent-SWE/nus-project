package nus.miniproject.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import io.micrometer.common.lang.Nullable;
import nus.miniproject.Exception.ResourceNotFoundException;
import nus.miniproject.model.Customer;

@Repository
public class CustomerRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;


    // Write my SQL query statements here

    // GET all customer
    private final String SQL_SELECT_ALL_CUSTOMER = """
        select * from customer
        """;
    
    private final String SQL_SELECT_LATEST = """
            select * from customer order by id desc limit 1;
            """;

    // GET customer by id    
    private final String SQL_SELECT_CUSTOMER_BY_ID = """
            select * from customer where id = ?
            """;

    // INSERT new customer
    private final String SQL_INSERT_CUSTOMER = """
            insert into customer (first_name, last_name) values (?, ?)
            """;


    private final String SQL_DELETE_CUSTOMER = """
            delete from customer where id = ?
            """;


    private final String SQL_DELETE_CUSTOMER_FLNAME = """
            delete from customer where first_name = ? and last_name = ?
            """;



    public List<Customer> findAllCustomer() {
        return jdbcTemplate.query(SQL_SELECT_ALL_CUSTOMER, BeanPropertyRowMapper.newInstance(Customer.class));
    }

   
    public Customer findCustomerById(Integer id) throws DataAccessException {
        try {
            Customer customer = jdbcTemplate.queryForObject(SQL_SELECT_CUSTOMER_BY_ID, BeanPropertyRowMapper.newInstance(Customer.class), id);
            return customer;
        } 
        catch (DataAccessException daex) {
            throw new ResourceNotFoundException("Customer " + id + " not found !");
        }
    }


    public Boolean insertCustomer(Customer customer) {

        Boolean bSaved = false;

        PreparedStatementCallback<Boolean> psc = new PreparedStatementCallback<Boolean>() {
            
            @Override
            @Nullable
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1, customer.getFirstName());
                ps.setString(2, customer.getLastName());
                int rslt = ps.executeUpdate();
                return rslt > 0;
            }
        };

         bSaved = jdbcTemplate.execute(SQL_INSERT_CUSTOMER, psc);
        // if (bSaved =jdbcTemplate.execute(SQL_INSERT_CUSTOMER, psc)){
        //      return bSaved = true;
        // }
        // else 
        return bSaved;
    }


    public int deleteCustomerById(Integer id) {
        int bDeleted = 0;

        PreparedStatementSetter pss = new PreparedStatementSetter() {
            
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, id);
            }
        };

        bDeleted = jdbcTemplate.update(SQL_DELETE_CUSTOMER, pss);

        return bDeleted;    

    }


    public int deleteCustomerByFLName(String firstName, String lastName) {
        int bDeleted = 0;

        PreparedStatementSetter pss = new PreparedStatementSetter() {
            
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, firstName);
                ps.setString(2, lastName);
            }
        };

        bDeleted = jdbcTemplate.update(SQL_DELETE_CUSTOMER_FLNAME, pss);

        return bDeleted;    

    }


    public Customer findCustomerLatest() {
        Customer customer = jdbcTemplate.queryForObject(SQL_SELECT_LATEST, BeanPropertyRowMapper.newInstance(Customer.class));
        return customer;
    }



        
}