package oblig3.wepprog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TicketController {

    //private List<Ticket> savedTickets = new ArrayList<>();

    @Autowired
    private TicketRepository rep;


    @PostMapping("/save")
    public List<Ticket> saveTickets( Ticket inTicket){
        return rep.saveTickets(inTicket);
    }

    @GetMapping("/load")
    public List<Ticket> loadTickets(){
        return rep.loadTickets();
    }

    @GetMapping("/delete")
    public void deleteTickets(){
        rep.deleteTickets();


    }


}
