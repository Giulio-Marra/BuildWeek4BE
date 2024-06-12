package Giulio_Marra.entities;

import Giulio_Marra.enums.periodicity;
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
    private periodicity periodicity;

    private LocalDate start_subscription;
    private LocalDate renew_subscription;
    private LocalDate emission_date;
    public Subscription() {
    }

    public Subscription(Giulio_Marra.enums.periodicity periodicity, LocalDate start_subscription, Card card, Seller seller) {
        this.periodicity = periodicity;
        this.start_subscription = start_subscription;
        this.renew_subscription = calcDateRenew();
        this.card = card;
        this.seller = seller;
        this.emission_date = calculateEmissionDate(seller);
    }
    private LocalDate calcDateRenew() {
        if (periodicity == Giulio_Marra.enums.periodicity.WEEKLY) {
            return start_subscription.plusWeeks(1);
        } else if (periodicity == Giulio_Marra.enums.periodicity.MONTHLY) {
            return start_subscription.plusMonths(1);
        } else {

            return start_subscription;
        }
    }
    private LocalDate calculateEmissionDate(Seller seller) {
        return LocalDate.now();
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

    public Giulio_Marra.enums.periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Giulio_Marra.enums.periodicity periodicity) {
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
