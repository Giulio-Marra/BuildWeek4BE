package Giulio_Marra;

import Giulio_Marra.Dao.*;
import Giulio_Marra.entities.*;
import Giulio_Marra.enums.Periodicity;
import Giulio_Marra.enums.Transport_type;
import com.sun.tools.javac.Main;
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

        //COLLEGAMENTI:
        //Trasporti
        Transport transporttrd = trd.getTransport(1);
        Transport transport1 = trd.getTransport(1);
        Transport transport2 = trd.getTransport(2);
        Transport transport3 = trd.getTransport(3);
        Transport transport6 = trd.getTransport(6);
        Transport transport7= trd.getTransport(18);
        Transport transport9=trd.getTransport(20);
        Transport transport8=trd.getTransport(19);
        Transport transport10=trd.getTransport(23);
        Transport transport11=trd.getTransport(24);
        Transport transport12=trd.getTransport(25);

        //Persone
        Person person_1 = pd.getPerson(1);
        Person person_2 = pd.getPerson(2);
        Person person_3 = pd.getPerson(3);
        Person person_4 = pd.getPerson(4);
Person person_5=pd.getPerson(20);
Person person_6=pd.getPerson(21);
        //Cards
        Card card1 = cd.getCard(1);
        //Routes
        Route route1Collegata = rd.getRoute(1);
        Route route2Collegata = rd.getRoute(2);
        Route route3Collegata = rd.getRoute(3);
        Route route4Collegata = rd.getRoute(4);
        Route routetrd = rd.getRoute(1);


        //Seller
        Seller seller_1 = sd.getSeller(1);
        Seller seller_2= sd.getSeller(2);
        Seller seller_3=sd.getSeller(5);
        Seller seller_5=sd.getSeller(10);
        Seller seller_4=sd.getSeller(3);
        //Ticket
        Ticket ticketFromDB = td.getTicket(4);


        //Creazione degli utenti:
        Person user_1 = new Person("Carlo", "Patalano");
        Person user_2 = new Person("Davide", "Prelati");
        Person user_3 = new Person("Giulio", "Marra");
        Person user_4 = new Person("Francesco", "Cossu");
        Person user_5 = new Person("Franco", " Franchi");
        Person user_6 = new Person("Enrico ", " Scotti");
        Person user_7 = new Person("Francisco", " Bianchi");
        Person user_15=new Person("Aldo ","Baglio");
        Person user_16=new Person("Stefano" , "Miceli");
        //Salvataggio Utenti:
        //pd.savePerson(user_1);
        //pd.savePerson(user_2);
        //pd.savePerson(user_3);
        //pd.savePerson(user_4);
        //pd.savePerson(user_5);
        //pd.savePerson(user_6);
        //pd.savePerson(user_7);
        //pd.savePerson(user_15);
        //pd.savePerson(user_16);

        //creazione Distrubutorì e negozio
        Seller distributor = new Automatic_seller("Distributore automatico", true);
        Seller authorized_seller = new Seller("Negozio Autorizzato");
        //Salvataggio:
        //sd.saveSeller(distributor);
        //sd.saveSeller(authorized_seller);

        //Rotta creata Numero1:
        Route route_1 = new Route("Napoli", "Roma", 2);
        Route route_2 = new Route("Napoli", "Milano", 6);
        Route route_3 = new Route("Verona", "Parma", 3);
        Route route_4 = new Route("Milano", "Scilla", 11);
        Route route_5 = new Route("Napoli", "Salerno", 120);
        //Salvataggio Rotta
        //rd.saveRoute(route_1);
        //rd.saveRoute(route_2);
        //rd.saveRoute(route_3);
        //rd.saveRoute(route_4);
        //rd.saveRoute(route_5);

        //Mezzo di trasporto
        Transport transport_1 = new Transport(Transport_type.AUTOBUS, false, "Tomas");
        Transport transport_6 = new Transport(Transport_type.AUTOBUS, false, "9483");
        Transport transport_7 = new Transport(Transport_type.TRAM, false, "To693");
        Transport transport_8 = new Transport(Transport_type.AUTOBUS, false, "28FMX");
        Transport transport_9 = new Transport(Transport_type.TRAM, false, "CD2");
        Transport transport_2 = new Transport(Transport_type.TRAM, false, "2");
        Transport transport_3 = new Transport(Transport_type.AUTOBUS, false, "5");
        Transport transport_4 = new Transport(Transport_type.TRAM, false, "8");
        Transport transport_5 = new Transport(Transport_type.TRAM, true, "9389ADD");
        Transport transport_10 = new Transport(Transport_type.AUTOBUS, true, "5389JDCJK");
        Transport transport_11 = new Transport(Transport_type.TRAM, true, "8D");
        Transport transport_12= new Transport(Transport_type.TRAM, true, "A2V31XV");
        //Salvataggio
        //trd.saveTrans(transport_1);
        //trd.saveTrans(transport_2);
        //trd.saveTrans(transport_3);
        //trd.saveTrans(transport_4);
        //trd.saveTrans(transport_5);
        //trd.saveTrans(transport_6);
        //trd.saveTrans(transport_7);
        //trd.saveTrans(transport_8);
        //trd.saveTrans(transport_9);
        //trd.saveTrans(transport_10);
        //trd.saveTrans(transport_11);
        //trd.saveTrans(transport_12);


        //Card
        Card card_1 = new Card(LocalDate.now().plusYears(1), LocalDate.now(), person_1);
        Card card_3 = new Card(LocalDate.now().plusYears(1), LocalDate.now(), user_4);
        Card card_4 = new Card(LocalDate.now().minusMonths(1), LocalDate.now().minusMonths(1), user_5);
        Card card_6=new Card( LocalDate.now().plusYears(1),LocalDate.now(),user_6);
        Card card_7=new Card(LocalDate.now().minusMonths(2),LocalDate.now().minusMonths(2),user_7);
        Card card_8 = new Card(LocalDate.now().plusYears(1), LocalDate.now(), person_3);
        Card card_9 = new Card(LocalDate.now().plusYears(1), LocalDate.now(), person_4);
        Card card_10 = new Card(LocalDate.now().plusYears(1), LocalDate.now(), person_2);

        //Salvataggio
        //cd.saveCard(card_1);
        //cd.saveCard(card_3);
        //cd.saveCard(card_4);
        //cd.saveCard(card_6);
        //cd.saveCard(card_7);
      // cd.saveCard(card_8);
       // cd.saveCard(card_9);
        //cd.saveCard(card_10);


        //Subscription
        Subscription subscription_1 = new Subscription(Periodicity.MONTHLY, LocalDate.now(), card_1, seller_1);
        Subscription subscription_3 = new Subscription(Periodicity.MONTHLY, LocalDate.now(), card_3, distributor);
        Subscription subscription_4 = new Subscription(Periodicity.MONTHLY, LocalDate.now().minusMonths(1), card_4, distributor);
        Subscription subscription_5=new Subscription(Periodicity.WEEKLY,LocalDate.now(),card_6,seller_1);
        Subscription subscription_6=new Subscription(Periodicity.MONTHLY,LocalDate.now(),card_7,seller_1);
        Subscription subscription_7=new Subscription(Periodicity.WEEKLY,LocalDate.now(),card_8,seller_5);
        Subscription subscription_8=new Subscription(Periodicity.MONTHLY,LocalDate.now(),card_9,seller_3);
        Subscription subscription_9=new Subscription(Periodicity.WEEKLY,LocalDate.now(),card_10,seller_3);




        //Salvataggio
        //sbd.saveSubscription(subscription_1);
        //sbd.saveSubscription(subscription_3);
        //sbd.saveSubscription(subscription_4);
        //sbd.saveSubscription(subscription_5);
        //sbd.saveSubscription(subscription_6);
        //sbd.saveSubscription(subscription_7);
        //sbd.saveSubscription(subscription_8);
        //sbd.saveSubscription(subscription_9);



        //Biglietti
        Ticket ticket_1=new Ticket(false, seller_1);
        Ticket ticket_2=new Ticket(false, seller_2);
        Ticket ticket_3=new Ticket(false, seller_2);
        Ticket ticket_4=new Ticket(false, seller_1);
        Ticket ticket_5=new Ticket(false, seller_1);
        Ticket ticket_6=new Ticket(false, seller_2);
        Ticket ticket_7=new Ticket(false, seller_1);
        Ticket ticket_8=new Ticket(false, seller_2);
        Ticket ticket_9=new Ticket(false, seller_1);
        Ticket ticket_10=new Ticket(false, seller_1);
        Ticket ticket_11=new Ticket(false, seller_2);
        Ticket ticket_12=new Ticket(false, seller_2);
        Ticket ticket_13=new Ticket(false, seller_3);
        Ticket ticket_14=new Ticket(false, seller_5);
        Ticket ticket_15=new Ticket(false, seller_5);
        Ticket ticket_16=new Ticket(false, seller_1);
        Ticket ticket_17=new Ticket(false, seller_3);
        Ticket ticket_18=new Ticket(false, seller_2);
        Ticket ticket_19=new Ticket(false, seller_2);
        Ticket ticket_20=new Ticket(false, seller_1);
        Ticket ticket_21=new Ticket(false, seller_5);
        Ticket ticket_22=new Ticket(false, seller_1);
        Ticket ticket_23=new Ticket(false, seller_5);
        Ticket ticket_24=new Ticket(false, seller_3);
        Ticket ticket_25=new Ticket(false, seller_3);
        //Salvataggio
       // td.saveTicket(ticket_1);
        //td.saveTicket(ticket_2);
        //td.saveTicket(ticket_3);
        //td.saveTicket(ticket_4);
        //td.saveTicket(ticket_5);
        //td.saveTicket(ticket_6);
        //td.saveTicket(ticket_7);
        //td.saveTicket(ticket_8);
       // td.saveTicket(ticket_9);
        //td.saveTicket(ticket_10);
        //td.saveTicket(ticket_11);
        //td.saveTicket(ticket_12);
        //td.saveTicket(ticket_13);
        //td.saveTicket(ticket_14);
        //td.saveTicket(ticket_15);
        //pd.saveTicket(ticket_16);
        //td.saveTicket(ticket_17);
        //pd.saveTicket(ticket_18);
        //pd.saveTicket(ticket_19);
        //pd.saveTicket(ticket_20);
        //td.saveTicket(ticket_21);
        //pd.saveTicket(ticket_22);
        //td.saveTicket(ticket_23);
        //td.saveTicket(ticket_24);
       // td.saveTicket(ticket_25);

        //Maintenences
        Maintenance maint_1 = new Maintenance(Date.valueOf("2021-01-02").toLocalDate(), Date.valueOf("2021-02-17").toLocalDate(), transport1);
        Maintenance maint_6=new Maintenance(Date.valueOf("2021-01-02").toLocalDate(), Date.valueOf("2021-02-17").toLocalDate(),transport7);
        Maintenance maint_7=new Maintenance(Date.valueOf("2021-01-02").toLocalDate(), Date.valueOf("2021-02-17").toLocalDate(),transport9);
        Maintenance maint_8=new Maintenance(Date.valueOf("2021-01-02").toLocalDate(), Date.valueOf("2021-02-17").toLocalDate(),transport8);
        Maintenance maint_2 = new Maintenance(Date.valueOf("2020-02-15").toLocalDate(), Date.valueOf("2020-07-21").toLocalDate(), transport6);
        Maintenance maint_3 = new Maintenance(Date.valueOf("2020-04-12").toLocalDate(), Date.valueOf("2020-05-01").toLocalDate(), transport3);
        Maintenance maint_4 = new Maintenance(Date.valueOf("2020-06-21").toLocalDate(), Date.valueOf("2020-06-24").toLocalDate(), transport2);
        Maintenance maint_5 = new Maintenance(Date.valueOf("2020-10-13").toLocalDate(), Date.valueOf("2020-11-20").toLocalDate(), transport1);
        Maintenance maint_10 = new Maintenance(Date.valueOf("2023-10-13").toLocalDate(), Date.valueOf("2025-11-20").toLocalDate(), transport10);
        Maintenance maint_11 = new Maintenance(Date.valueOf("2023-10-13").toLocalDate(), Date.valueOf("2025-11-20").toLocalDate(), transport11);
        Maintenance maint_12 = new Maintenance(Date.valueOf("2023-10-13").toLocalDate(), Date.valueOf("2025-11-20").toLocalDate(), transport12);
        //Salvataggio
        //trd.saveMaintenence(maint_6);
        //trd.saveMaintenence(maint_7);
        //trd.saveMaintenence(maint_8);
        //trd.saveMaintenence(maint_1);
        //trd.saveMaintenence(maint_2);
        //trd.saveMaintenence(maint_3);
        //trd.saveMaintenence(maint_4);
        //trd.saveMaintenence(maint_5);
        //trd.saveMaintenence(maint_10);
        //trd.saveMaintenence(maint_11);
        //trd.saveMaintenence(maint_12);
        //trd.getDateOfMaintenance(6);


        //Mezzo_tratta
        Transport_route transport_route = new Transport_route(transporttrd, routetrd, LocalDate.of(2024, 2, 12));
        Transport_route transportRoute_2=new Transport_route(transport11,route2Collegata,LocalDate.of(2024,4,15));
        Transport_route transportRoute_3=new Transport_route(transport11,route3Collegata,LocalDate.of(2024,4,15));
        Transport_route transportRoute_4=new Transport_route(transport11,route4Collegata,LocalDate.of(2024,4,15));
        //Salvataggio
       // trans_rD.saveTransportRoute(transport_route);
        trans_rD.saveTransportRoute(transportRoute_2);
        trans_rD.saveTransportRoute(transportRoute_3);
       trans_rD.saveTransportRoute(transportRoute_4);


        //td.stampTicket(ticketFromDB,transport1);


        //METODO PER IL CONTROLLO DEL ABBONAMENTO:
        long card_3_id = (17L);
        long card_4_id = (16L);
        boolean isCard3Valid = pd.isSubscriptionValid(card_3_id);
        boolean isCard4Valid = pd.isSubscriptionValid(card_4_id);
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
