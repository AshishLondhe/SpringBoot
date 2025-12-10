package com.cencora.springbootdata.service;

import com.cencora.springbootdata.model.Ticket;

import java.time.LocalDate;
import java.util.List;

public interface TicketService {
//    void findAllTickets();
List<Ticket> findAllTickets();
    void findTicketById(Integer id);
    void saveTicket(Ticket ticket);
    void deleteTicketBYId(Integer id);
    void deleteTicket(Ticket ticket);
//    void deleteAllTickets();
    void deleteTickets(List<Ticket> tickets);
    void findTicketByRaisedon(LocalDate date);
    void countByRaisedon(LocalDate date);
    void findFirst5TicketByIssue(String issue);
//    void getAllTicketsOrderById();
    void getAllTicketByRaisedon();
    void findTickettById();
    void updateTicketIssueById();
    void getByIssue();


}
