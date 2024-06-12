package Giulio_Marra;

import Giulio_Marra.Dao.Transport_routeDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("build_week_4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        Transport_routeDAO trd = new Transport_routeDAO(em);

        //Route route2 = new Route("Napoli", "Salerno", 2.10);
        //Transport transport2 = new Transport(Transport_type.TRAM, false, "A231");

        //trd.saveTransport(transport2);
        //trd.saveRoute(route2);


        //trd.saveTransportRoute(transport_route1);

        System.out.println(trd.countNumberOfTransportRoute(1, 1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 12)));


    }
}
