package oblig3.wepprog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketRepository {

    @Autowired
    private JdbcTemplate db;

    public List<Ticket> saveTickets( Ticket inTicket) {
        String sql = "INSERT INTO Ticket(movie,amount, firstName, lastName, phone, email  ) VALUES(?,?,?,?,?,?)";
        db.update(sql,inTicket.getMovie(), inTicket.getAmount(), inTicket.getFirstName(), inTicket.getLastName(), inTicket.getPhone(), inTicket.getEmail());

        String sqlreturn = "SELECT * FROM Ticket ORDER BY id DESC LIMIT 1";
        List<Ticket> currentTicket = db.query(sqlreturn, new BeanPropertyRowMapper(Ticket.class));
        return currentTicket;
    }

    public List<Ticket> loadTickets(){
        String sql = "SELECT * FROM Ticket";
        List<Ticket> allTickets = db.query(sql, new BeanPropertyRowMapper(Ticket.class));
        return allTickets;
    }

    public void deleteTickets(){
        String sql = "DELETE FROM Ticket";
        db.update(sql);
    }

}
