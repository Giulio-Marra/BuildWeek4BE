package Giulio_Marra;

import Giulio_Marra.Dao.*;
import Giulio_Marra.entities.*;
import Giulio_Marra.enums.Periodicity;
import Giulio_Marra.enums.Transport_type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.sql.Date;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("build_week_4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        PersonDAO pd = new PersonDAO(em);
        TicketDAO td = new TicketDAO(em);
        CardDAO cd = new CardDAO(em);
        RouteDAO rd = new RouteDAO(em);
        SellerDAO sd = new SellerDAO(em);
        SubscriptionDAO sbd = new SubscriptionDAO(em);
        TransportDAO trd = new TransportDAO(em);
        Transport_routeDAO trans_rD = new Transport_routeDAO(em);

        

        //METODO PER IL CONTROLLO DEL ABBONAMENTO:
        long card_3_id = (17L);
        long card_4_id = (16L);
        boolean isCard3Valid = sbd.isSubscriptionValid(card_3_id);
        boolean isCard4Valid = sbd.isSubscriptionValid(card_4_id);
        System.out.println("Validità degli abbonamenti:");
        if (isCard3Valid) {
            System.out.println("L'abbonamento di " + user_6.getName() + " " + user_6.getSurname() + " è valido.");
        } else {
            System.out.println("L'abbonamento di " + user_6.getName() + " " + user_6.getSurname() + " non è valido.");
        }

        if (isCard4Valid) {
            System.out.println("L'abbonamento di " + user_7.getName() + " " + user_7.getSurname() + " è valido.");
        } else {
            System.out.println("L'abbonamento di " + user_7.getName() + " " + user_7.getSurname() + " non è valido.");
        }

        System.out.println(" Numero di biglietti emessi: " + td.NumberOfTicketBySeller(seller_1) + " numero abbonamenti emessi: " + td.NumberOfSubscriptionBySeller(seller_1));
        System.out.println("Numero di biglietti emessi tra le due date:" + td.TicketsBetweenDates(Date.valueOf("2020-06-21").toLocalDate(), LocalDate.now()));
        System.out.println("Numero di abbonamenti emessi tra le due date:" + td.SubsBetweenDates(Date.valueOf("2020-06-21").toLocalDate(), LocalDate.now()));

        System.out.println(trans_rD.countNumberOfTransportRoute(1, 1));
        System.out.println(trans_rD.allTotaleTimeTransportRoute(1, 1));


    }
}
