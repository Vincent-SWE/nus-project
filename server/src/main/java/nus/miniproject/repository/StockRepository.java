package nus.miniproject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nus.miniproject.Exception.ResourceNotFoundException;
import nus.miniproject.model.Stock;

@Repository
public class StockRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    // Write my SQL query statements here

    // Find all blood types
    private final String SQL_SELECT_ALL_BLOODTYPE = """
            select * from stock
            """;

    private final String SQL_SELECT_STOCK_BY_ID = """
            select * from stock where id = ?
            """;




    public List<Stock> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_BLOODTYPE, BeanPropertyRowMapper.newInstance(Stock.class));
    }

   
    public Stock findById(Integer id) throws DataAccessException {
        try {
            Stock stock = jdbcTemplate.queryForObject(SQL_SELECT_STOCK_BY_ID, BeanPropertyRowMapper.newInstance(Stock.class), id);
            return stock;
        } 
        catch (DataAccessException daex) {
            throw new ResourceNotFoundException("Blood type stock " + id + " not found !");
        }
    }





    
}
