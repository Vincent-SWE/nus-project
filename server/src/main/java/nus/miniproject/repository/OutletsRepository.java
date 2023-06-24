package nus.miniproject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nus.miniproject.Exception.ResourceNotFoundException;
import nus.miniproject.model.Outlets;


@Repository
public class OutletsRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    // Write my SQL query statements here

    // GET all outlets
    private final String SQL_SELECT_ALL_OUTLETS = """
            select * from outlets
            """;

    // GET outlets by id
    private final String SQL_SELECT_OUTLETS_BY_ID = """
        select * from outlets where id = ?
        """;


    // Method to GET all outlets
    public List<Outlets> findAllOutlets() {
        return jdbcTemplate.query(SQL_SELECT_ALL_OUTLETS, BeanPropertyRowMapper.newInstance(Outlets.class));
    }


    public Outlets findOutletsById(Integer id) throws DataAccessException {
        try {
            Outlets outlets = jdbcTemplate.queryForObject(SQL_SELECT_OUTLETS_BY_ID, BeanPropertyRowMapper.newInstance(Outlets.class), id);
            return outlets;
        } 
        catch (DataAccessException daex) {
            throw new ResourceNotFoundException("Outlets id:  " + id + " not found !");
        }
    }




}
