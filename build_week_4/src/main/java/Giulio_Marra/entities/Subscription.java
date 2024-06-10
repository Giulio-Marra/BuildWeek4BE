package Giulio_Marra.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Subscription {
    @GeneratedValue
    @Id
    @OneToOne
    private long id;
    private periodicity periodicity;



    public Subscription() {}

    public Subscription(Giulio_Marra.entities.periodicity periodicity) {
        this.periodicity = periodicity;
    }

    public Giulio_Marra.entities.periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Giulio_Marra.entities.periodicity periodicity) {
        this.periodicity = periodicity;
    }

    public long getId() {
        return id;
    }

}
