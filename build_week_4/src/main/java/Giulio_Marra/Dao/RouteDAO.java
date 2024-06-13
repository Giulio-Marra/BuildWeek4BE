package Giulio_Marra.Dao;

import Giulio_Marra.entities.Route;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RouteDAO {
    private final EntityManager em;
    public RouteDAO(EntityManager em){
        this.em = em;
    }
    public void saveRoute(Route route) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(route);
        transaction.commit();
        System.out.println("Il mezzo è partito da: " + route.getStarting_area() + " è stato aggiunto correttamente al database");
    }
    public Route getRoute(long id){
        return em.find(Route.class,id);
    }
}
