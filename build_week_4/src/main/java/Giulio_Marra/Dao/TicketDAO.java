package Giulio_Marra.Dao;

import Giulio_Marra.entities.Card;
import Giulio_Marra.entities.Subscription;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TicketDAO {

    private final EntityManager em;

    public TicketDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Card card) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(card);
        transaction.commit();
        System.out.println("L'utente " + card.getUser() + " è stato aggiunto correttamente al database");
    }

    public Card getCard(long id) {
        return em.find(Card.class, id);
    }

    public void saveSub(Subscription subscription) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(subscription);
        transaction.commit();
        System.out.println("L'utente " + subscription.getCard() + " è stato aggiunto correttamente al database");
    }

    public Subscription getSub(long id) {
        return em.find(Subscription.class, id);
    }
}
