package Giulio_Marra.Dao;

import Giulio_Marra.entities.Card;
import Giulio_Marra.entities.Subscription;
import Giulio_Marra.entities.Ticket;
import Giulio_Marra.enums.Periodicity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;

public class SubscriptionDAO {
    private final EntityManager em;

    public SubscriptionDAO(EntityManager em) {
        this.em = em;
    }

    public void saveSubscription(Subscription subscription) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(subscription);
        transaction.commit();
        System.out.println("La sottoscrizione della tessera: " + subscription.getCard() + " è stata aggiunta correttamente al database");
    }

    public Subscription getSubscription(long id) {
        return em.find(Subscription.class, id);
    }


    public Card getCard(long cardNumber) {
        TypedQuery<Card> query = em.createQuery("SELECT c FROM Card c WHERE c.id= :cardNumber", Card.class);
        query.setParameter("cardNumber", cardNumber);
        return query.getSingleResult();
    }


    public Card getCardByNumber(long cardNumber) {
        TypedQuery<Card> query = em.createQuery("SELECT c FROM Card c WHERE c.id= :cardNumber", Card.class);
        query.setParameter("cardNumber", cardNumber);
        return query.getSingleResult();
    }

    public boolean isSubscriptionValid(long cardNumber) {
        Card card = getCardByNumber(cardNumber);
        if (card == null) {
            return false;
        }

        Subscription subscription = card.getSubscription();
        if (subscription == null) {
            return false;
        }

        LocalDate currentDate = LocalDate.now();
        LocalDate subscriptionRenewDate = subscription.getRenew_subscription();


        return currentDate.isBefore(subscriptionRenewDate) || currentDate.isEqual(subscriptionRenewDate);
    }

    public boolean subscriptionByCard(Card card) {
        if (card.getSubscription() == null) {
            return false;
        }
        return true;
    }

    public void getSubscriptionByCardID(long cardNumber) {
        Card card = getCardByNumber(cardNumber);
        Subscription subscription = card.getSubscription();
        if (subscription != null){
        System.out.println(subscription);
        }else {
            System.out.println("La tessera selezionata non esiste o non ha una sottoscrizione");
        }
    }

    public void renewMonthlySubscription (Subscription subscription) {
        TypedQuery<Subscription> query = em.createQuery("SELECT s FROM Subscription s WHERE s.card.id = :id", Subscription.class);
        query.setParameter("id", subscription.getId());
        Subscription result = query.getSingleResult();
        result.setPeriodicity(Periodicity.MONTHLY);
        result.setRenew_subscription(LocalDate.now().plusMonths(1));
        em.getTransaction().begin();
        em.merge(result);
        em.getTransaction().commit();
    }

    public void renewWeeklySubscription (Subscription subscription) {
        TypedQuery<Subscription> query = em.createQuery("SELECT s FROM Subscription s WHERE s.id_card = :id", Subscription.class);
        query.setParameter("id", subscription.getId());
        Subscription result = query.getSingleResult();
        result.setPeriodicity(Periodicity.WEEKLY);
        result.setRenew_subscription(LocalDate.now().plusWeeks(1));
        em.getTransaction().begin();
        em.merge(result);
        em.getTransaction().commit();
    }

    public boolean isSubscriptionExpired(Subscription subscription) {
        LocalDate currentDate = LocalDate.now();
        LocalDate subscriptionRenewDate = subscription.getRenew_subscription();
        return currentDate.isAfter(subscriptionRenewDate);
    }

    public Subscription returnSubscriptionByCardID(long cardNumber) {
        Card card = getCardByNumber(cardNumber);
        Subscription subscription = card.getSubscription();
        return subscription;
    }
}

