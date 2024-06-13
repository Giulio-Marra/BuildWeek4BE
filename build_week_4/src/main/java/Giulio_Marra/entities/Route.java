package Giulio_Marra.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "route")
    private List<Transport_route> transport_routes;

    @OneToMany(mappedBy = "route")
    private List<Transport> transports;

    @OneToMany(mappedBy = "route")
    private List<Ticket> tickets;

    private String starting_area;
    private String terminal_area;
    private int avg_travel_time;


    public Route() {
    }

    public Route(String starting_area, String terminal_area, int avg_travel_time) {
        this.starting_area = starting_area;
        this.terminal_area = terminal_area;
        this.avg_travel_time = avg_travel_time;
    }

    public long getId() {
        return id;
    }

    public List<Transport_route> getTransport_routes() {
        return transport_routes;
    }

    public void setTransport_routes(List<Transport_route> transport_routes) {
        this.transport_routes = transport_routes;
    }

    public String getStarting_area() {
        return starting_area;
    }

    public void setStarting_area(String starting_area) {
        this.starting_area = starting_area;
    }

    public String getTerminal_area() {
        return terminal_area;
    }

    public void setTerminal_area(String terminal_area) {
        this.terminal_area = terminal_area;
    }

    public int getAvg_travel_time() {
        return avg_travel_time;
    }

    public void setAvg_travel_time(int avg_travel_time) {
        this.avg_travel_time = avg_travel_time;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", starting_area='" + starting_area + ' ' +
                ", terminal_area='" + terminal_area + ' ' +
                ", avg_travel_time=" + avg_travel_time +
                '}';
    }
}