package Giulio_Marra.Dao;

import Giulio_Marra.entities.Person;
import Giulio_Marra.entities.Transport;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
}
