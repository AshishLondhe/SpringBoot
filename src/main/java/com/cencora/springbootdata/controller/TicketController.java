package com.cencora.springbootdata.controller;

import com.cencora.springbootdata.model.Ticket;
import com.cencora.springbootdata.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // 🔹 Get all tickets
//    @GetMapping("/get")
//    public void getAllTickets() {
//        ticketService.findAllTickets(); // prints to console
////        return ResponseEntity.ok("Fetched all tickets (check console/logs)");
//    }
@GetMapping("/get")
public List<Ticket> getAllTickets() {
    return ticketService.findAllTickets();
}

    // 🔹 Get ticket by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getTicketById(@PathVariable Integer id) {
        ticketService.findTicketById(id); // prints to console
        return ResponseEntity.ok("Fetched ticket with ID " + id + " (check console/logs)");
    }

    // 🔹 Save a new ticket
    @PostMapping
    public ResponseEntity<String> saveTicket(@RequestBody Ticket ticket) {
        ticketService.saveTicket(ticket);
        return ResponseEntity.ok("Ticket saved successfully!");
    }

    // 🔹 Update ticket (save with same ID)
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTicket(@PathVariable Integer id, @RequestBody Ticket ticket) {
        ticket.setId(id);
        ticketService.saveTicket(ticket);
        return ResponseEntity.ok("Ticket updated successfully!");
    }

    // 🔹 Delete ticket by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTicketById(@PathVariable Integer id) {
        ticketService.deleteTicketBYId(id);
        return ResponseEntity.ok("Ticket deleted successfully!");
    }

    // 🔹 Delete ticket by object
    @DeleteMapping("/delete/by-object")
    public ResponseEntity<String> deleteTicket(@RequestBody Ticket ticket) {
        ticketService.deleteTicket(ticket);
        return ResponseEntity.ok("Ticket deleted successfully!");
    }

    // 🔹 Delete multiple tickets
    @DeleteMapping("/delete/batch")
    public ResponseEntity<String> deleteTickets(@RequestBody List<Ticket> tickets) {
        ticketService.deleteTickets(tickets);
        return ResponseEntity.ok(tickets.size() + " tickets deleted successfully!");
     }

    // 🔹 Find tickets by date
    @GetMapping("get/by-date")
    public ResponseEntity<String> getTicketsByDate(@RequestParam String date) {
        LocalDate parsedDate = LocalDate.parse(date); // yyyy-MM-dd
        ticketService.findTicketByRaisedon(parsedDate); // prints to console
        return ResponseEntity.ok("Fetched tickets for date " + parsedDate + " (check console/logs)");
    }



}
