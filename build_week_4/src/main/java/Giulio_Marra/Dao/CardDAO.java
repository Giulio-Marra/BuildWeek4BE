package Giulio_Marra.Dao;

import Giulio_Marra.entities.Card;
import Giulio_Marra.entities.Ticket;
import Giulio_Marra.entities.Transport;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

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

    public void renewCardExpiration(long card_id){
        TypedQuery<Card> query = em.createQuery("SELECT c FROM Card c WHERE c.id= :card_id", Card.class);
        query.setParameter("card_id", card_id);
        Card card = query.getSingleResult();
        LocalDate currentDate = LocalDate.now();
        LocalDate expirationDate = card.getExpiration_date();
        if(currentDate.isAfter(expirationDate)){
            LocalDate newExpirationDate = expirationDate.plusYears(1);
            card.setExpiration_date(newExpirationDate);
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(card);
            transaction.commit();
            System.out.println("La tessera è stata rinnovata correttamente");


        }
    }

}
