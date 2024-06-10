package Giulio_Marra.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Ticket {
    @GeneratedValue
    @Id
    @ManyToOne
    private long id;
    private boolean used;
    @ManyToOne
    private Seller seller;
    @ManyToOne
    private Transport transport;




    public Ticket() {
    }

    public Ticket(boolean used, Seller seller) {
        this.used = used;
        this.seller = seller;
    }


    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Transport getMeans_of_transport() {
        return transport;
    }

    public void setMeans_of_transport(Transport transport) {
        this.transport = transport;
    }

    public long getId() {
        return id;
    }

}
