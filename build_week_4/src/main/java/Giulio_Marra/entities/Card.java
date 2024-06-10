package Giulio_Marra.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

public class Card {
    @GeneratedValue
    @Id
    private long id;
    private LocalDate expiration_date;
    private LocalDate issue_date;
    @OneToOne
    @JoinColumn (name = "id_subscription")
    private long subscription_id;
    @OneToOne
    @JoinColumn (name = "id_user")
    private User user;



    public Card() {}

    public Card(LocalDate expiration_date, LocalDate issue_date, long subscription_id, User user) {
        this.expiration_date = expiration_date;
        this.issue_date = issue_date;
        this.subscription_id = subscription_id;
        this.user = user;
    }


    public long getId() {
        return id;
    }

    public LocalDate getData_scadenza() {
        return expiration_date;
    }

    public void setData_scadenza(LocalDate expiration_date) {
        this.expiration_date = expiration_date;
    }

    public LocalDate getData_emissione() {
        return issue_date;
    }

    public void setData_emissione(LocalDate issue_date) {
        this.issue_date = issue_date;
    }

    public long getId_abbonamento() {
        return subscription_id;
    }

    public void setId_abbonamento(long subscription_id) {
        this.subscription_id = subscription_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
