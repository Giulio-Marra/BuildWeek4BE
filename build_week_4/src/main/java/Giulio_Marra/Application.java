package Giulio_Marra;

import Giulio_Marra.Dao.PersonDAO;
import Giulio_Marra.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("build_week_4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        PersonDAO pd = new PersonDAO(em);

        Person usertst = new Person("riccardo", "legit");

        System.out.println(usertst.getName());
        pd.save(usertst);

        System.out.println("Hello ciao buongioro0sdfsdfsdf!");

    }
}
