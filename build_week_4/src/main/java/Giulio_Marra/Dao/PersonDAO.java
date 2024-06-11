package Giulio_Marra.Dao;

import Giulio_Marra.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
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

    public void saveTrans(Transport transport) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(transport);
        transaction.commit();
        System.out.println("L'utente " + transport.getTransport_type() + " è stato aggiunto correttamente al database");
    }
    public void saveRoute(Route route) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(route);
        transaction.commit();
        System.out.println("Il mezzo è partito da: " + route.getStarting_area() + " è stato aggiunto correttamente al database");
    }
    public void saveSeller(Seller seller) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(seller);
        transaction.commit();
        System.out.println("Il biglietto è stato acquistato da: " + seller.getName() + " e ora è possibile usarlo");
    }
    public void saveCard(Card card) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(card);
        transaction.commit();
        System.out.println("Il mezzo è partito da: " + card.getUser() + " è stato aggiunto correttamente al database");
    }
    public Seller getSeller(long id) {
        return em.find(Seller.class, id);
    }
    public Card getCard(long id){
        return em.find(Card.class,id);
    }
    public void saveSubscription(Subscription subscription) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(subscription);
        transaction.commit();
        System.out.println("Il mezzo è partito da: " + subscription.getCard() + " è stato aggiunto correttamente al database");
    }
    public Route getRoute(long id){
        return em.find(Route.class,id);
    }

    public void saveTicket(Ticket ticket) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(ticket);
        transaction.commit();
        System.out.println("Il biglietto selezionato con l' id è: " + ticket.getId() + " è stato aggiunto correttamente al database");
    }
    public Transport getTransport(long id){
        return em.find(Transport.class,id);
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
