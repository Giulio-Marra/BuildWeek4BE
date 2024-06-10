package Giulio_Marra.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Transport {
    @GeneratedValue
    @Id
    @OneToMany
    private long id;
    private transport_type transport_type;
    @OneToMany
    private boolean state;
    private int capacity;
    @ManyToOne
    private Route route;
    private List<Maintenance> maintenance_list;


    public Transport(Giulio_Marra.entities.transport_type transport_type, boolean state, int capacity) {
        this.transport_type = transport_type;
        this.state = state;
        this.capacity = capacity;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
