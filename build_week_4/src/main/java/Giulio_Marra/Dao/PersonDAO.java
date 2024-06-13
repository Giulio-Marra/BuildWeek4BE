package Giulio_Marra.Dao;

import Giulio_Marra.entities.Card;
import Giulio_Marra.entities.Person;
import Giulio_Marra.entities.Subscription;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;

public class PersonDAO {

    private final EntityManager em;

    public PersonDAO(EntityManager em) {
        this.em = em;
    }

    public void savePerson(Person person) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(person);
        transaction.commit();
        System.out.println("L'utente " + person.getName() + " è stato aggiunto correttamente al database");
    }

    public Person getPerson(long id) {
        return em.find(Person.class, id);
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

}
