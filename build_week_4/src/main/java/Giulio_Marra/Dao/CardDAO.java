package Giulio_Marra.Dao;

import Giulio_Marra.entities.Card;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CardDAO {
    private final EntityManager em;

    public CardDAO(EntityManager em) {
        this.em = em;
    }

    public void saveCard(Card card) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(card);
        transaction.commit();
        System.out.println("La card associata all utente: " + card.getUser() + " è stata aggiunta correttamente al database");
    }

    public Card getCard(long id) {
        return em.find(Card.class, id);
    }

}
