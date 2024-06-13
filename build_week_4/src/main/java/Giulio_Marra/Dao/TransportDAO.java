package Giulio_Marra.Dao;

import Giulio_Marra.entities.Transport;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TransportDAO {
    private final EntityManager em;
    public TransportDAO(EntityManager em){
        this.em = em;
    }
    public Transport getTransport(long id){
        return em.find(Transport.class,id);
    }
    public void saveTrans(Transport transport) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(transport);
        transaction.commit();
        System.out.println("L'utente " + transport.getTransport_type() + " è stato aggiunto correttamente al database");
    }
}
