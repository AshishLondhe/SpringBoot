package com.cencora.springbootdata.repository;
import com.cencora.springbootdata.model.Ticket;
//import jakarta.transaction.Transactional;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


public interface TicketRepository extends CrudRepository<Ticket,Integer> {
    List<Ticket>findTicketByRaisedon(LocalDate date);
    long countByRaisedon(LocalDate date);
    List<Ticket> findFirst5TicketByIssue(String issue);
//    List<Ticket>getAllTicketsOrderById();
    @Query("select ticket from Ticket ticket where ticket.raisedon=:date")
    List<Ticket>getAllByRaisedon(@Param("date")LocalDate date);

    @Query("select ticket from Ticket ticket where ticket.id=:id")
    List<Ticket>findTickettById(@Param("id")Integer id);

    @Query("update Ticket ticket set ticket.issue=:new_issue where ticket.id=:id")
    @Modifying
    @Transactional
    public void updateTicketIssueById(@Param("id")int id,@Param("new_issue")String new_issue );

    public Iterable<Ticket> getByIssue(@Param("issue") String issue);
}
