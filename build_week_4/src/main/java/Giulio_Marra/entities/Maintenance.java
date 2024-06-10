package Giulio_Marra.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class Maintenance {
    @GeneratedValue
    @Id
    @ManyToOne
    private long id;
    private LocalDate starting_date;
    private LocalDate ending_date;
    private boolean maintenance_state;
    private Transport transport_id;


    public Maintenance() {
    }

    public Maintenance(LocalDate starting_date, boolean maintenance_state, LocalDate ending_date) {
        this.starting_date = starting_date;
        this.maintenance_state = maintenance_state;
        this.ending_date = ending_date;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(LocalDate starting_date) {
        this.starting_date = starting_date;
    }

    public boolean isMaintenance_state() {
        return maintenance_state;
    }

    public void setMaintenance_state(boolean maintenance_state) {
        this.maintenance_state = maintenance_state;
    }

    public LocalDate getEnding_date() {
        return ending_date;
    }

    public void setEnding_date(LocalDate ending_date) {
        this.ending_date = ending_date;
    }

    public Transport getTransport_id() {
        return transport_id;
    }

    public void setTransport_id(Transport transport_id) {
        this.transport_id = transport_id;
    }
}
