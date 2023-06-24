package nus.miniproject.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import nus.miniproject.model.Appointments;
import nus.miniproject.model.AppointmentsComplete;
import nus.miniproject.model.Customer;
import nus.miniproject.model.Outlets;


@Repository
public class AppointmentsRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Write my SQL query statements here

    // Find all appointments
    private final String SQL_FIND_ALL_APPOINTMENTS = """
            select * from appointments;
        """;

    private final String SQL_FIND_ALL_APPOINTMENTS_RS = """
            select cust.id as customer_id, outt.id as outlets_id, cust.first_name, cust.last_name, outt.building_name, outt.address, appt.appointments_date
from customer as cust
inner join appointments as appt on cust.id = appt.customer_id
inner join outlets as outt on outt.id = appt.outlets_id
            """;


        // Find appointment by id
    private final String SQL_FIND_APPOINTMENT_BY_ID = """
            select cust.id as customer_id, outt.id as outlets_id, cust.first_name, cust.last_name, outt.building_name, outt.address, appt.appointments_date
from customer as cust
inner join appointments as appt on cust.id = appt.customer_id
inner join outlets as outt on outt.id = appt.outlets_id
where appt.id = ?;
            """;

    // Create an appointment
    private final String SQL_INSERT_APPOINTMENTS = """
            insert into appointments (customer_id, outlets_id, appointments_date) values (?, ?, ?);
            """;


        


    // Basic GET all appointments
    public List<Appointments> findAllAppointments() {
        return jdbcTemplate.query(SQL_FIND_ALL_APPOINTMENTS, BeanPropertyRowMapper.newInstance(Appointments.class));
    }



    public List<AppointmentsComplete> findAllAppointmentsRS() {

        List<AppointmentsComplete> appointments = new ArrayList<AppointmentsComplete>();

        appointments = jdbcTemplate.query(SQL_FIND_ALL_APPOINTMENTS_RS, new ResultSetExtractor<List<AppointmentsComplete>>() {

            @Override
            public List<AppointmentsComplete> extractData(ResultSet rs) throws SQLException, DataAccessException {

                List<AppointmentsComplete> appts = new ArrayList<AppointmentsComplete>();
        

                while(rs.next()) {
                    AppointmentsComplete apptscplt = new AppointmentsComplete();
                    apptscplt.setAppointmentsDate(rs.getDate("appointments_date"));
            
                    Customer cust = new Customer();
                    cust.setId(rs.getInt("customer_id"));
                    cust.setFirstName(rs.getString("first_name"));
                    cust.setLastName(rs.getString("last_name"));
                    apptscplt.setCustomer(cust);

                    Outlets outt = new Outlets();
                    outt.setId(rs.getInt("outlets_id"));
                    outt.setBuildingName(rs.getString("building_name"));
                    outt.setAddress(rs.getString("address"));
                    apptscplt.setOutlets(outt);              
                    
                    appts.add(apptscplt);
                }

                return appts;
            }
        });

        return appointments;
    }


    public AppointmentsComplete findAppointmentsById(Integer id) {

            AppointmentsComplete appointments = new AppointmentsComplete();

              PreparedStatementSetter pss = new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setInt(1, id);
                    }
                };

            appointments = jdbcTemplate.query(SQL_FIND_APPOINTMENT_BY_ID, pss, new ResultSetExtractor<AppointmentsComplete>() {

                @Override
                public AppointmentsComplete extractData(ResultSet rs) throws SQLException, DataAccessException {
            
                    AppointmentsComplete apptscplt = new AppointmentsComplete();

                    if (rs.next()) {
                        apptscplt.setAppointmentsDate(rs.getDate("appointments_date"));
                
                        Customer cust = new Customer();
                        cust.setId(rs.getInt("customer_id"));
                        cust.setFirstName(rs.getString("first_name"));
                        cust.setLastName(rs.getString("last_name"));
                        apptscplt.setCustomer(cust);

                        Outlets outt = new Outlets();
                        outt.setId(rs.getInt("outlets_id"));
                        outt.setBuildingName(rs.getString("building_name"));
                        outt.setAddress(rs.getString("address"));
                        apptscplt.setOutlets(outt);              
                    }

                    return apptscplt;
                }
            });

            return appointments;
        }



}
