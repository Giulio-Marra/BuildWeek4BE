package Giulio_Marra.entities;

import Giulio_Marra.enums.Transport_type;
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
    private Transport_type transport_type;

    private boolean state;

    private int capacity;

    @OneToMany(mappedBy = "transport")
    private List<Transport_route> transport_route;

    @OneToMany(mappedBy = "transport")
    private List<Maintenance> maintenance_list;

    public Transport() {

    }

    public Transport(Transport_type transport_type, boolean state, String name) {
        this.transport_type = transport_type;
        this.state = state;
        this.capacity = totCapacity();
        this.name = name;
    }

    public int totCapacity() {
        if (transport_type == Transport_type.AUTOBUS) {
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

    public Transport_type getTransport_type() {
        return transport_type;
    }

    public void setTransport_type(Transport_type transport_type) {
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

    public List<Transport_route> getTransport_route() {
        return transport_route;
    }

    public void setTransport_route(List<Transport_route> transport_route) {
        this.transport_route = transport_route;
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
