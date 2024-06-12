package Giulio_Marra.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Person user;

    private boolean used;

    private LocalDate used_date;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

    private LocalDate emission_date;
    public Ticket() {
    }

    public Ticket(boolean used, Seller seller, Person person, Transport transport  ) {
        this.used = used;
        this.used_date = used_date_date();
        this.seller = seller;
        this.user = person;
        this.transport=transport;
        this.emission_date = calculateEmissionDate(seller);
    }

    public LocalDate used_date_date() {
        if (used == true) {
            return LocalDate.now();
        } else {
            return null;
        }
    }

    private LocalDate calculateEmissionDate(Seller seller) {
        return LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public LocalDate getUsed_date() {
        return used_date;
    }

    public void setUsed_date(LocalDate used_date) {
        this.used_date = used_date;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", used=" + used +
                ", used_date=" + used_date +
                ", emission_date=" + emission_date +
                '}';
    }
}
