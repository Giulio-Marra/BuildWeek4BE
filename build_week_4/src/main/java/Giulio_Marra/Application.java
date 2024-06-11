package Giulio_Marra;

import Giulio_Marra.Dao.PersonDAO;
import Giulio_Marra.Dao.TicketDao;
import Giulio_Marra.entities.*;
import Giulio_Marra.enums.periodicity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("build_week_4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        PersonDAO pd = new PersonDAO(em);
        TicketDao TicketDao= new TicketDao(em);


        Person user1 = new Person("Carlo", "Patalano");
        Person user2 = new Person("Giulio", "Marra");
        Person user3 = new Person("Davide", "Prelati");
        //Salvo i 3 user
        pd.save(user1);
        pd.save(user2);
        pd.save(user3);
        //Setto i due tipi di distrubutori:
        Seller distributor=new Automatic_seller("Distrubutore Automatico",true);
        Seller authorizedSeller= new Seller("Negozio Autorizzato");

        em.getTransaction().begin();
        em.persist(distributor);
        em.persist(authorizedSeller);
        em.getTransaction().commit();


        //Il primo utente crea il ticket comprandolo al distrubutore automatico
        Transport transport1 = new Transport(transport_type.TRAM, true, 200, "Tram");

        em.getTransaction().begin();
        em.persist(transport1);
        em.getTransaction().commit();

        Ticket ticket_1 = new Ticket(false);
        ticket_1.setUser(user1);
        ticket_1.setSeller(distributor);
        ticket_1.setTransport(transport1);
        em.persist(ticket_1);


//Ho creato un secondo utente che compra il ticket ma dal negozio autorizzato

        Transport transport2= new Transport(transport_type.AUTOBUS,true,300,"AUTOBUS");
        em.getTransaction().begin();
        em.persist(transport2);
        em.getTransaction().commit();

        Ticket ticket_2 = new Ticket(false);
        ticket_2.setUser(user2);
        ticket_2.setSeller(authorizedSeller);
        ticket_2.setTransport(transport2);

        em.getTransaction().begin();
        em.persist(ticket_2);
        em.getTransaction().commit();

        Card card_1=new Card(LocalDate.now().plusYears(1),LocalDate.now(),user3);
        Subscription subscription = new Subscription(periodicity.MONTHLY, LocalDate.now(), card_1);
        card_1.setSubscription(subscription);
        em.getTransaction().begin();
        em.persist(card_1);
        em.persist(subscription);
        em.getTransaction().commit();


        System.out.println("Utente 1 ha comprato il biglietto dal distributore automatico: " + ticket_1);
        System.out.println("Utente 2 ha comprato il biglietto dal rivenditore autorizzato: " + ticket_2);
        System.out.println("Utente 3 ha una tessera con abbonamento: " + card_1 + " " + subscription);
    }
}
