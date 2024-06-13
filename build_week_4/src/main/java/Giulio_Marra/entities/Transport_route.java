package Giulio_Marra.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Random;

@Entity
public class Transport_route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    private LocalDate date;
    private double total_time;
    private long frequency;

    public Transport_route() {

    }

    public Transport_route(Transport transport, Route route, LocalDate date) {
        this.transport = transport;
        this.route = route;
        this.date = date;
        this.total_time = randomVariation();
        this.frequency = frequency;
    }

    public int randomVariation() {
        int number = route.getAvg_travel_time();
        Random rand = new Random();
        double variation = -0.20 + (0.20 - (-0.20)) * rand.nextDouble();
        int result = (int) Math.round(number + (number * variation));
        return result;
    }

    public long getId() {
        return id;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotal_time() {
        return total_time;
    }

    public void setTotal_time(double total_time) {
        this.total_time = total_time;
    }

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Transport_route{" +
                "id=" + id +
                ", date=" + date +
                ", total_time=" + total_time +
                ", frequency=" + frequency +
                '}';
    }
}