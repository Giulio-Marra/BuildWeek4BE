package Giulio_Marra.Dao;

import jakarta.persistence.EntityManager;

public class RouteDAO {
    private final EntityManager em;
    public RouteDAO(EntityManager em){
        this.em = em;
    }
}
