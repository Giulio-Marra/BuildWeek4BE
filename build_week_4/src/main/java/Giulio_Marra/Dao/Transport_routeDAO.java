package Giulio_Marra.Dao;

import Giulio_Marra.entities.Route;
import Giulio_Marra.entities.Transport;
import Giulio_Marra.entities.Transport_route;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Transport_routeDAO {

    private final EntityManager em;

    public Transport_routeDAO(EntityManager em) {
        this.em = em;
    }

    public void saveTransportRoute(Transport_route transport_route) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(transport_route);
        System.out.println("Il percorso della  " + transport_route.getRoute() + " è stato aggiunto correttamente al database");

        long transportId = transport_route.getTransport().getId();
        long routeId = transport_route.getRoute().getId();
        long frequency = countByTransportIdAndRouteId(transportId, routeId);
        transport_route.setFrequency(frequency);

        transaction.commit();
    }

    public long countByTransportIdAndRouteId(long transportId, long routeId) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT (tr) FROM Transport_route tr WHERE tr.transport.id = :transportId AND tr.route.id = :routeId", Long.class);
        query.setParameter("transportId", transportId);
        query.setParameter("routeId", routeId);
        return query.getSingleResult();
    }

    public long countNumberOfTransportRoute(long transportId, long routeId) {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(ts) FROM Transport_route ts WHERE ts.route.id = :routeId AND ts.transport.id = :transportId ", Long.class);
        query.setParameter("routeId", routeId);
        query.setParameter("transportId", transportId);
        return query.getSingleResult();
    }

    public List<Double> allTotaleTimeTransportRoute(long transportId, long routeId) {
        TypedQuery<Double> query = em.createQuery("SELECT ts.total_time FROM Transport_route ts WHERE ts.route.id = :routeId AND ts.transport.id = :transportId", Double.class);
        query.setParameter("routeId", routeId);
        query.setParameter("transportId", transportId);
        return query.getResultList();
    }

    public void saveRoute(Route route) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(route);
        transaction.commit();
        System.out.println("La rotta: " + route.getTransport_routes() + " è stato aggiunta correttamente al database");
    }

    public Route getRoute(long id) {
        return em.find(Route.class, id);
    }

    public void saveTransport(Transport transport) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(transport);
        transaction.commit();
        System.out.println("Il biglietto selezionato con l' id è: " + transport.getName() + " è stato aggiunto correttamente al database");
    }

    public Transport getTransport(long id) {
        return em.find(Transport.class, id);
    }


}
