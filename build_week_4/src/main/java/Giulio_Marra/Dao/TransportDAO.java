package Giulio_Marra.Dao;

import jakarta.persistence.EntityManager;

public class TransportDAO {
    private final EntityManager em;
    public TransportDAO(EntityManager em){
        this.em = em;
    }
}
