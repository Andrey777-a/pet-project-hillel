package com.example.springhillel.repository.jdbcRepository;

import com.example.springhillel.model.dto.TicketDTO;
import com.example.springhillel.model.entity.Ticket;
import com.example.springhillel.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public class JdbcTicketRepositoryImpl implements TicketRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Ticket> getAllTask() {
        return null;
    }

    @Override
    public void createTask(TicketDTO taskAttribute) {
        jdbcTemplate.update("insert into ticket_user (name, description, user_id, status_id, priority, time_spent, " +
                        "time_estimated, created_on_date, type_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                taskAttribute.getName(), taskAttribute.getDescription(), taskAttribute.getAssignee(),
                taskAttribute.getStatus(), taskAttribute.getPriority(), taskAttribute.getTimeSpent(),
                taskAttribute.getTimeEstimated(), LocalDateTime.now(), taskAttribute.getTypeTicket());

    }

    @Override
    public void updateTask(Ticket ticket) {
        jdbcTemplate.update("UPDATE ticket_user SET description = ?, status_id = ?, priority = ?, time_spent = ? " +
                        "where id = ?", ticket.getDescription(), ticket.getStatus(), ticket.getPriority(),
                ticket.getTimeSpent(), ticket.getId());

    }

    @Override
    public List<Ticket> getTaskUser(int user) {

        List<Ticket> strLst  = jdbcTemplate.query("select * from ticket_user where user_id = " + user,
                new RowMapper<Ticket>() {
                    @Override
                    public Ticket mapRow(ResultSet rs, int i) throws SQLException {
                        return new Ticket(rs.getInt("id"),rs.getString("name"),
                                rs.getString("description"), null/*rs.getInt("assignee")*/,
                                null/*rs.getInt("status")*/, rs.getInt("priority"),
                                rs.getDouble("time_spent"),
                                LocalDateTime.of(rs.getDate("time_estimated").toLocalDate(), rs.getTime("time_estimated").toLocalTime()),
                                LocalDateTime.of(rs.getDate("created_on_date").toLocalDate(), rs.getTime("created_on_date").toLocalTime()),
                                null/*rs.getInt("type")*/);
                    }
                });

        for(Ticket ticket : strLst){
            System.out.println(ticket);
        }

        return strLst;
    }

    @Override
    public Ticket getTask(long id) {
        return null;
    }

    @Override
    public void deleteTask(long idTask) {

    }

}
