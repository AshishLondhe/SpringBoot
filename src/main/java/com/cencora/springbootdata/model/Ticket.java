package com.cencora.springbootdata.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "ticket")
@NamedQuery(name="Ticket.getByIssue",query="select ticket from Ticket ticket where ticket.issue=:issue")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String issue;
    private LocalDate raisedon;

    public Ticket() {}

    public Ticket(int id, String issue, LocalDate raisedon) {
        super();
        this.id = id;
        this.issue = issue;
        this.raisedon = raisedon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public LocalDate getRaisedon() {
        return raisedon;
    }

    public void setRaisedon(LocalDate raisedon) {
        this.raisedon = raisedon;
    }

    @Override
    public String toString() {
        return "Ticket [id=" + id + ", issue=" + issue + ", raisedon=" + raisedon + "]";
    }

}