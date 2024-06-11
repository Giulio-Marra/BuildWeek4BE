package Giulio_Marra;

import Giulio_Marra.Dao.PersonDAO;
import Giulio_Marra.entities.Transport;
import Giulio_Marra.entities.transport_type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("build_week_4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        PersonDAO pd = new PersonDAO(em);

        System.out.println("Hello ciao buongioro0sdfsdfsdf!");

        Transport transport1 = new Transport(transport_type.TRAM, false, "THOMAS");

        pd.saveTrans(transport1);

    }
}
