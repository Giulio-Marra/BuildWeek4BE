package Giulio_Marra;

import Giulio_Marra.Dao.Transport_routeDAO;
import Giulio_Marra.entities.Route;
import Giulio_Marra.entities.Transport;
import Giulio_Marra.entities.Transport_route;
import Giulio_Marra.enums.Transport_type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("build_week_4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        Transport_routeDAO trd = new Transport_routeDAO(em);

        Route route2 = new Route("Napoli", "Salerno", 120);
        Transport transport2 = new Transport(Transport_type.TRAM, false, "A231");

        //trd.saveTransport(transport2);
        //trd.saveRoute(route2);

        Route routetrd = trd.getRoute(1);
        Transport transporttrd = trd.getTransport(1);

        Transport_route transport_route = new Transport_route(transporttrd, routetrd, LocalDate.of(2024, 02, 12));

        trd.saveTransportRoute(transport_route);

        System.out.println(trd.countNumberOfTransportRoute(1, 1));
        System.out.println(trd.allTotaleTimeTransportRoute(1, 1));


    }
}
