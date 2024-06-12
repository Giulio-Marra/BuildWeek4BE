package Giulio_Marra.Dao;

import jakarta.persistence.EntityManager;

public class SellerDAO {
    private final EntityManager em;
    public SellerDAO(EntityManager em){
        this.em = em;
    }
}
