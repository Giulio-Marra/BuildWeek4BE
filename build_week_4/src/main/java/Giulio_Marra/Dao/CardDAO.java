package Giulio_Marra.Dao;

import jakarta.persistence.EntityManager;

public class CardDAO {
    private final EntityManager em;

    public CardDAO(EntityManager em){
            this.em = em;
    }

}
