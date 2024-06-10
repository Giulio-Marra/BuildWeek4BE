package Giulio_Marra.Dao;

import Giulio_Marra.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonDAO {

    private final EntityManager em;

    public PersonDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Person utente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println("L'utente " + utente.getName() + " è stato aggiunto correttamente al database");
    }

    public Person getetUtente(long id) {
        return em.find(Person.class, id);
    }
}
