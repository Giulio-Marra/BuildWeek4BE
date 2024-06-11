package Giulio_Marra.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "transport")
    private List<Ticket> ticket;

    @Enumerated(EnumType.STRING)
    private transport_type transport_type;

    private boolean state;

    private int capacity;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @OneToMany(mappedBy = "transport")
    private List<Maintenance> maintenance_list;

public Transport(){

}
    public Transport(Giulio_Marra.entities.transport_type transport_type, boolean state, String name, Route route) {
        this.transport_type = transport_type;
        this.state = state;
        this.capacity = totCapacity();
        this.name = name;
        this.route=route;
    }

    public int totCapacity() {
        if (transport_type == Giulio_Marra.entities.transport_type.AUTOBUS) {
            return 30;
        } else {
            return 20;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }

    public long getId() {
        return id;
    }

    public Giulio_Marra.entities.transport_type getTransport_type() {
        return transport_type;
    }

    public void setTransport_type(Giulio_Marra.entities.transport_type transport_type) {
        this.transport_type = transport_type;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<Maintenance> getMaintenance_list() {
        return maintenance_list;
    }

    public void setMaintenance_list(List<Maintenance> maintenance_list) {
        this.maintenance_list = maintenance_list;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", transport_type=" + transport_type +
                ", state=" + state +
                ", capacity=" + capacity +
                '}';
    }
}
