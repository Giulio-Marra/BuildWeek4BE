package Giulio_Marra.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Route {
    @GeneratedValue
    @Id
    @OneToMany
    private long id;
    private String starting_area;
    private String terminal_area;
    private double avg_travel_time;


    public Route() {}


    public Route(String starting_area, String terminal_area, double avg_travel_time) {
        this.starting_area = starting_area;
        this.terminal_area = terminal_area;
        this.avg_travel_time = avg_travel_time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getAvg_travel_time() {
        return avg_travel_time;
    }

    public void setAvg_travel_time(double avg_travel_time) {
        this.avg_travel_time = avg_travel_time;
    }
}
