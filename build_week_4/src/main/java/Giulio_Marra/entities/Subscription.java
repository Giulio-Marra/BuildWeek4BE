package Giulio_Marra.entities;

import Giulio_Marra.enums.Periodicity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "id_card")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    private LocalDate start_subscription;
    private LocalDate renew_subscription;

    public Subscription() {
    }

    public Subscription(Periodicity periodicity, LocalDate start_subscription, Card card, Seller seller) {
        this.periodicity = periodicity;
        this.start_subscription = start_subscription;
        this.renew_subscription = calcDateRenew();
        this.card = card;
        this.seller = seller;
    }

    private LocalDate calcDateRenew() {
        if (periodicity == Periodicity.WEEKLY) {
            return start_subscription.plusDays(7);
        } else {
            return start_subscription.plusDays(30);
        }
    }

    public long getId() {
        return id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    public LocalDate getStart_subscription() {
        return start_subscription;
    }

    public void setStart_subscription(LocalDate start_subscription) {
        this.start_subscription = start_subscription;
    }

    public LocalDate getRenew_subscription() {
        return renew_subscription;
    }

    public void setRenew_subscription(LocalDate renew_subscription) {
        this.renew_subscription = renew_subscription;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", periodicity=" + periodicity +
                ", start_subscription=" + start_subscription +
                ", renew_subscription=" + renew_subscription +
                '}';
    }
}
