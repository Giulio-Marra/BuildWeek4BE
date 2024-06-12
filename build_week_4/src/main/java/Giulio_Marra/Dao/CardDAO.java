package Giulio_Marra.Dao;

import Giulio_Marra.entities.Card;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CardDAO {
    private final EntityManager em;

    public CardDAO(EntityManager em){
            this.em = em;
    }
    public void saveCard(Card card) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(card);
        transaction.commit();
        System.out.println("Il mezzo è partito da: " + card.getUser() + " è stato aggiunto correttamente al database");
    }
    public Card getCard(long id){
        return em.find(Card.class,id);
    }

}
