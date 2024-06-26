package Giulio_Marra.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Transport transport;

    private LocalDate starting_date;
    private LocalDate ending_date;

    public Maintenance() {
    }

    public Maintenance(LocalDate starting_date, LocalDate ending_date, Transport transport) {
        this.starting_date = starting_date;
        this.ending_date = ending_date;
        this.transport = transport;
    }

    public long getId() {
        return id;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transports) {
        this.transport = transports;
    }

    public LocalDate getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(LocalDate starting_date) {
        this.starting_date = starting_date;
    }

    public LocalDate getEnding_date() {
        return ending_date;
    }

    public void setEnding_date(LocalDate ending_date) {
        this.ending_date = ending_date;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "id=" + id +
                ", starting_date=" + starting_date +
                ", ending_date=" + ending_date +
                '}';
    }
}