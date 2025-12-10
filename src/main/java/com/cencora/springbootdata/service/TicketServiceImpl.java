package com.cencora.springbootdata.service;

import com.cencora.springbootdata.model.Ticket;
import com.cencora.springbootdata.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

//    public void findAllTickets() {
//        System.out.println("foundAllTickets"+ticketRepository.findAll());
//    }
@Override
public List<Ticket> findAllTickets() {
    return (List<Ticket>) ticketRepository.findAll();
}

    public void findTicketById(Integer id) {
//        System.out.println("foundTicketById"+ticketRepository.findById(id).get());
        Optional<Ticket> ticket = ticketRepository.findById(id);
        ticket.ifPresentOrElse(System.out::println,()->{System.out.println("Ticket not found");}) ;
        }

        public void saveTicket(Ticket ticket) {

            System.out.println("Ticket saved : "+ticketRepository.save(ticket));
        }

    @Override
    public void deleteTicketBYId(Integer id) {
        ticketRepository.deleteById(id);
    }

    public void deleteTicket(Ticket ticket) {
        ticketRepository.delete(ticket);
    }

//    public void deleteAllTickets() {
//        ticketRepository.deleteAll();
//    }
    public void deleteTickets(List<Ticket> tickets) {
            ticketRepository.deleteAll(tickets);
    }

    @Override
    public void findTicketByRaisedon(LocalDate date) {
        /* System.out.println("Enter date :"); */
        System.out.println(ticketRepository.findTicketByRaisedon(date));

    }
//    public void findTicketsByDate() {
//        System.out.println("Enter date");
//        ticketRepository.findAllByRaisedon(LocalDate.parse(new Scanner(System.in).nextLine(),DateTimeFormatter.ofPattern("dd-MM-yyyy"))).forEach(System.out::println);
//    }
    public void countByRaisedon(LocalDate date) {
        long count = ticketRepository.countByRaisedon(date);
        System.out.println("Tickets on " + date + " = " + count);
    }

    @Override
    public void findFirst5TicketByIssue(String issue) {
        System.out.println(ticketRepository.findFirst5TicketByIssue(issue));
    }

    public void getAllTicketByRaisedon() {
        ticketRepository.getAllByRaisedon(LocalDate.of(2025,12,1)).forEach(System.out::println);
    }

    public void findTickettById(){
       System.out.println(ticketRepository.findTickettById(4)) ;
    }

    @Override
    public void updateTicketIssueById() {
        ticketRepository.updateTicketIssueById(4,"test");
//        System.out.println() ;
        Ticket updatedTicket = ticketRepository.findById(4).orElse(null);

        // Print to console
        System.out.println(updatedTicket);
    }

    public void getByIssue(){
        ticketRepository.getByIssue("account failed").forEach(System.out::println);
    }

}

