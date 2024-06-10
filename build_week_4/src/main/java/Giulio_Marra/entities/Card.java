package Giulio_Marra.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate expiration_date;
    private LocalDate issue_date;

    @OneToOne
    @JoinColumn(name = "id_subscription")
    private Subscription subscription;

    @OneToOne
    @JoinColumn(name = "id_user")
    private Person user;


    public Card() {
    }

    public Card(LocalDate expiration_date, LocalDate issue_date) {
        this.expiration_date = expiration_date;
        this.issue_date = issue_date;
    }

    public long getId() {
        return id;
    }

    public LocalDate getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDate expiration_date) {
        this.expiration_date = expiration_date;
    }

    public LocalDate getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(LocalDate issue_date) {
        this.issue_date = issue_date;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", expiration_date=" + expiration_date +
                ", issue_date=" + issue_date +
                '}';
    }
}
