package Giulio_Marra.Dao;

import Giulio_Marra.entities.Card;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;

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


    public boolean isCardExpired(long card_id){
        Card card = getCard(card_id);
        if(card == null){
            return true;
        }
        LocalDate currentDate = LocalDate.now();
        LocalDate expirationDate = card.getExpiration_date();
        return currentDate.isAfter(expirationDate);
    }

}
