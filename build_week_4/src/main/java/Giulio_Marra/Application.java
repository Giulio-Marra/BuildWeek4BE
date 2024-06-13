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


        //Creazione degli utenti:
        Person user_1 = new Person("Carlo", "Patalano");
        Person user_2 = new Person("Davide", "Prelati");
        Person user_3 = new Person("Giulio", "Marra");
        //Salvataggio Utenti:
        //pd.savePerson(user_1);
        //pd.savePerson(user_2);
        //pd.savePerson(user_3);

        //creazione Distrubutorì e negozio
        Seller distributor = new Automatic_seller("Distributore automatico", true);
        Seller authorized_seller = new Seller("Negozio Autorizzato");

        //Salvataggio:

        //pd.saveSeller(distributor);
        //pd.saveSeller(authorized_seller);

        //Rotta creata Numero1:
        Route route_1 = new Route("Napoli", "Roma", 2);
        //Salvataggio Rotta
        //pd.saveRoute(route_1);

        //Mezzo di trasporto con rotta:
        Route routeCollegata = rd.getRoute(1);
        Transport transport_1 = new Transport(Transport_type.AUTOBUS, false, "Tomas");
        //trd.saveTrans(transport_1);


        Person person_1 = pd.getPerson(1);
        Card Card_2 = cd.getCard(1);
        Seller seller_1 = sd.getSeller(1);
        Card card_1 = new Card(LocalDate.now().plusYears(1), LocalDate.now(), person_1);
        //pd.saveCard(card_1);
        Subscription subscription_1 = new Subscription(Periodicity.MONTHLY, LocalDate.now(), Card_2, seller_1);
        //pd.saveSubscription(subscription_1);

        Transport transport1 = trd.getTransport(1);
        Transport transport2 = trd.getTransport(2);
        Transport transport3 = trd.getTransport(3);

        Ticket ticket_1 = new Ticket(false, seller_1, person_1);
        //td.saveTicket(ticket_1);
        Ticket ticket_2 = new Ticket(false, seller_1, person_1);
        //td.saveTicket(ticket_2);

        Ticket ticket_3 = new Ticket(false, seller_1, person_1);
        //td.saveTicket(ticket_3);

        Ticket ticketFromDB = td.getTicket(4);
        //td.stampTicket(ticketFromDB,transport1);


        //METODO PER IL CONTROLLO DEL ABBONAMENTO:

        //Creazione Utenti
        Person user_4 = new Person("Francesco", "Cossu");
        Person user_5 = new Person("Franco", " Franchi");
        //pd.savePerson(user_4);
        //pd.savePerson(user_5);

        Card card_3 = new Card(LocalDate.now().plusYears(1), LocalDate.now(), user_4);
        Card card_4 = new Card(LocalDate.now().minusMonths(1), LocalDate.now().minusMonths(1), user_5);
        //pd.saveCard(card_3);
        //pd.saveCard(card_4);


        Subscription subscription_3 = new Subscription(Periodicity.MONTHLY, LocalDate.now(), card_3, distributor);
        Subscription subscription_4 = new Subscription(Periodicity.MONTHLY, LocalDate.now().minusMonths(1), card_4, distributor);
        //pd.saveSubscription(subscription_3);
        //pd.saveSubscription(subscription_4);

        Route route_2 = new Route("Napoli", "Milano", 6);
        Route route_3 = new Route("Verona", "Parma", 3);
        Route route_4 = new Route("Milano", "Scilla", 11);
        //pd.saveRoute(route_2);
        //pd.saveRoute(route_3);
        //pd.saveRoute(route_4);


        Route route2Collegata = rd.getRoute(2);
        Route route3Collegata = rd.getRoute(3);
        Route route4Collegata = rd.getRoute(4);

        Transport transport_2 = new Transport(Transport_type.TRAM, false, "2");
        Transport transport_3 = new Transport(Transport_type.AUTOBUS, false, "5");
        Transport transport_4 = new Transport(Transport_type.TRAM, false, "8");

        //trd.saveTrans(transport_2);
        //trd.saveTrans(transport_3);
        //(trd.saveTrans(transport_4);


        long card_3_id = (11L);
        long card_4_id = (12L);
        boolean isCard3Valid = pd.isSubscriptionValid(card_3_id);
        boolean isCard4Valid = pd.isSubscriptionValid(card_4_id);
        System.out.println("Validità degli abbonamenti:");
        if (isCard3Valid) {
            System.out.println("L'abbonamento di " + user_4.getName() + " " + user_4.getSurname() + " è valido.");
        } else {
            System.out.println("L'abbonamento di " + user_4.getName() + " " + user_4.getSurname() + " non è valido.");
        }

        if (isCard4Valid) {
            System.out.println("L'abbonamento di " + user_5.getName() + " " + user_5.getSurname() + " è valido.");
        } else {
            System.out.println("L'abbonamento di " + user_5.getName() + " " + user_5.getSurname() + " non è valido.");
        }

        System.out.println(" Numero di biglietti emessi: " + td.NumberOfTicketBySeller(seller_1) + " numero abbonamenti emessi: " + td.NumberOfSubscriptionBySeller(seller_1));
        System.out.println("Numero di biglietti emessi tra le due date:" + td.TicketsBetweenDates(Date.valueOf("2020-06-21").toLocalDate(), LocalDate.now()));
        System.out.println("Numero di abbonamenti emessi tra le due date:" + td.SubsBetweenDates(Date.valueOf("2020-06-21").toLocalDate(), LocalDate.now()));


        Transport transport_6 = trd.getTransport(6);
        Maintenance maint_1 = new Maintenance(Date.valueOf("2021-01-02").toLocalDate(), Date.valueOf("2021-02-17").toLocalDate(), transport1);
        Maintenance maint_2 = new Maintenance(Date.valueOf("2020-02-15").toLocalDate(), Date.valueOf("2020-07-21").toLocalDate(), transport_6);
        Maintenance maint_3 = new Maintenance(Date.valueOf("2020-04-12").toLocalDate(), Date.valueOf("2020-05-01").toLocalDate(), transport3);
        Maintenance maint_4 = new Maintenance(Date.valueOf("2020-06-21").toLocalDate(), Date.valueOf("2020-06-24").toLocalDate(), transport2);
        Maintenance maint_5 = new Maintenance(Date.valueOf("2020-10-13").toLocalDate(), Date.valueOf("2020-11-20").toLocalDate(), transport1);
        //trd.saveMaintenence(maint_1);
        //trd.saveMaintenence(maint_2);
        //trd.saveMaintenence(maint_3);
        //trd.saveMaintenence(maint_4);
        //trd.saveMaintenence(maint_5);
        //trd.getDateOfMaintenance(6);


        Route route5 = new Route("Napoli", "Salerno", 120);
        Transport transport_10 = new Transport(Transport_type.TRAM, false, "A231");

        trd.saveTrans(transport2);
        rd.saveRoute(route5);

        Route routetrd = rd.getRoute(1);
        Transport transporttrd = trd.getTransport(1);

        Transport_route transport_route = new Transport_route(transporttrd, routetrd, LocalDate.of(2024, 2, 12));

        trans_rD.saveTransportRoute(transport_route);

        System.out.println(trans_rD.countNumberOfTransportRoute(1, 1));
        System.out.println(trans_rD.allTotaleTimeTransportRoute(1, 1));


    }
}
