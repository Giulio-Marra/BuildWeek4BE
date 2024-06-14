package Giulio_Marra.Dao;

import Giulio_Marra.entities.Seller;
import Giulio_Marra.entities.Ticket;
import Giulio_Marra.entities.Transport;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class TicketDAO {

    private final EntityManager em;

    public TicketDAO(EntityManager em) {
        this.em = em;
    }

    public void saveTicket(Ticket ticket) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(ticket);
        transaction.commit();
        System.out.println("Il biglietto selezionato con l' id : " + ticket.getId() + " è stato aggiunto correttamente al database");
    }

    public Long NumberOfTicketBySeller(Seller seller) {
        Query query = em.createQuery("SELECT COUNT(t) FROM Ticket t WHERE t.seller = :seller");
        query.setParameter("seller", seller);
        return (Long) query.getSingleResult();
    }

    public Long TicketsBetweenDates(LocalDate date1, LocalDate date2) {
        Query query = em.createQuery("SELECT COUNT(t) FROM Ticket t WHERE t.emission_date BETWEEN :date1 AND :date2");
        query.setParameter("date1", date1);
        query.setParameter("date2", date2);
        return (Long) query.getSingleResult();
    }

    public Long SubsBetweenDates(LocalDate date1, LocalDate date2) {
        Query query = em.createQuery("SELECT COUNT(s) FROM Subscription s WHERE s.emission_date BETWEEN :date1 AND :date2");
        query.setParameter("date1", date1);
        query.setParameter("date2", date2);
        return (Long) query.getSingleResult();
    }

    public Long NumberOfSubscriptionBySeller(Seller seller) {
        Query query = em.createQuery("SELECT COUNT(s) FROM Subscription s WHERE s.seller = :seller");
        query.setParameter("seller", seller);
        return (Long) query.getSingleResult();
    }

    public void stampTicket(Ticket ticket, Transport transport) {
        TypedQuery<Ticket> query = em.createQuery("SELECT t FROM Ticket t WHERE t.id = :id", Ticket.class);
        query.setParameter("id", ticket.getId());
        Ticket result = query.getSingleResult();
        result.setUsed(true);
        result.setUsed_date(LocalDate.now());
        result.setTransport(transport);
        em.getTransaction().begin();
        em.merge(result);
        em.getTransaction().commit();

    }

    public Ticket getTicket(long id) {
        return em.find(Ticket.class, id);
    }

    public void printTicketsByRouteID(long id) {
        TypedQuery<Ticket> query = em.createQuery("SELECT t FROM Ticket t WHERE t.route.id = :id AND used = false", Ticket.class);
        query.setParameter("id", id);
        List<Ticket> result = query.getResultList();
        for (Ticket ticket : result) {
            System.out.println(ticket);
        }
    }
}
