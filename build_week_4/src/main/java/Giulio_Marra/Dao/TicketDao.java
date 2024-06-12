package Giulio_Marra.Dao;

import Giulio_Marra.entities.Card;
import Giulio_Marra.entities.Seller;
import Giulio_Marra.entities.Subscription;
import Giulio_Marra.entities.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;

public class TicketDao {

    private final EntityManager em;

    public TicketDao(EntityManager em) {
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



    public Long NumberOfTicketBySeller (Seller seller) {
        Query query = em.createQuery("SELECT COUNT(t) FROM Ticket t WHERE t.seller = :seller");
        query.setParameter("seller", seller);
        return (Long) query.getSingleResult();
    }
    public Long TicketsBetweenDates (LocalDate date1, LocalDate date2) {
        Query query = em.createQuery("SELECT COUNT(t) FROM Ticket t WHERE t.emission_date BETWEEN :date1 AND :date2");
        query.setParameter("date1", date1);
        query.setParameter("date2", date2);
        return (Long) query.getSingleResult();
    }
    public Long SubsBetweenDates (LocalDate date1, LocalDate date2) {
        Query query = em.createQuery("SELECT COUNT(s) FROM Subscription s WHERE s.emission_date BETWEEN :date1 AND :date2");
        query.setParameter("date1", date1);
        query.setParameter("date2", date2);
        return (Long) query.getSingleResult();
    }
    public Long NumberOfSubscriptionBySeller (Seller seller) {
        Query query = em.createQuery("SELECT COUNT(s) FROM Subscription s WHERE s.seller = :seller");
        query.setParameter("seller", seller);
        return (Long) query.getSingleResult();
    }
    public void stampTicket (Ticket ticket) {
        TypedQuery<Ticket> query = em.createQuery("SELECT t FROM Ticket t WHERE t.id = :id", Ticket.class);
        query.setParameter("id", ticket.getId());
        Ticket result = query.getSingleResult();
        result.setUsed(true);
        result.setUsed_date(LocalDate.now());
        em.getTransaction().begin();
        em.merge(result);
        em.getTransaction().commit();

    }
    public Ticket getTicket(long id){
        return em.find(Ticket.class,id);
    }
}
