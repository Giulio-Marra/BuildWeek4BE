package Giulio_Marra.Dao;

import Giulio_Marra.entities.Subscription;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class SubscriptionDAO {
    private final EntityManager em;
    public SubscriptionDAO(EntityManager em){
        this.em = em;
    }

    public void saveSubscription(Subscription subscription) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(subscription);
        transaction.commit();
        System.out.println("Il mezzo è partito da: " + subscription.getCard() + " è stato aggiunto correttamente al database");
    }
}
