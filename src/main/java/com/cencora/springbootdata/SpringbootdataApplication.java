package com.cencora.springbootdata;

import com.cencora.springbootdata.model.Ticket;
import com.cencora.springbootdata.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cencora.springbootdata.repository.TicketRepository;

import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootdataApplication implements CommandLineRunner{

    @Autowired
//    private TicketRepository ticketRepository;
    private TicketService ticketService;
    public static void main(String[] args) {
        SpringApplication.run(SpringbootdataApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println(ticketRepository.findAll());
//    }
    @Override
    public void run(String... args) throws Exception {
//        ticketService.findAllTickets();
//            ticketService.findTicketById(121);
//            ticketService.saveTicket(new Ticket(0,"account not working", LocalDate.now() ));
//                ticketService.deleteTicketBYId(3);
//                ticketService.deleteTicket(new Ticket(11,"account not working",LocalDate.now()));
//                ticketService.deleteAllTicket();
//        Ticket ticket1 = new Ticket(111,"kkk",LocalDate.now());
//        Ticket ticket2 = new Ticket(112,"aaa",LocalDate.now());
//        List<Ticket>deleteTick=new ArrayList<>();
//        deleteTick.add(ticket1);
//        deleteTick.add(ticket2);
//        ticketService.deleteTickets(deleteTick);
//        ticketService.findTicketByRaisedon(LocalDate.of(2025,11,26));
//        ticketService.countByRaisedon(LocalDate.now());
//        ticketService.findFirstFiveTickets().forEach(System.out::println);
//        ticketService.findFirst5TicketByIssue("account failed");
//        ticketService.getAllTicketByRaisedon();
//        ticketService.findTickettById();
//        ticketService.updateTicketIssueById();
        ticketService.getByIssue();

    }



}
