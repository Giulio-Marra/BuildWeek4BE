package Giulio_Marra.Dao;

import jakarta.persistence.EntityManager;

public class SubscriptionDAO {
    private final EntityManager em;
    public SubscriptionDAO(EntityManager em){
        this.em = em;
    }
}
