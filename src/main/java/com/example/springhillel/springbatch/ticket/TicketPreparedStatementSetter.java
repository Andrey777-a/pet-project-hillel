package com.example.springhillel.springbatch.ticket;

import com.example.springhillel.model.dto.TicketDTO;
import com.example.springhillel.model.entity.Ticket;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketPreparedStatementSetter implements ItemPreparedStatementSetter<TicketDTO> {

    @Override
    public void setValues(TicketDTO ticket, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, 5);
        preparedStatement.setLong(2, ticket.getId());
    }
}
