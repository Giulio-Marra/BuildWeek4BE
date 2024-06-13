package Giulio_Marra.Dao;

import Giulio_Marra.entities.Route;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RouteDAO {
    private final EntityManager em;

    public RouteDAO(EntityManager em) {
        this.em = em;
    }

    public void saveRoute(Route route) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(route);
        transaction.commit();
        System.out.println("La rotta che parte da: " + route.getStarting_area() + " a: " + route.getTerminal_area() + " è stata aggiunta correttamente al database");
    }

    public void printAllRoutes() {
        for (Route route : em.createQuery("SELECT r FROM Route r", Route.class).getResultList()) {
            System.out.println(route);
        }
    }

    public Route getRoute(long id) {
        return em.find(Route.class, id);
    }
}
