package Giulio_Marra;

import Giulio_Marra.Dao.*;
import Giulio_Marra.entities.*;
import Giulio_Marra.enums.Periodicity;
import Giulio_Marra.enums.Transport_type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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


        //CREAZIONE UTENTI
       /* Person giulio = new Person("giulio", "Marra");
        Person carlo = new Person("carlo", "patalano");
        Person francesco = new Person("francesco", "cossu");
        Person davide = new Person("davide", "prelati");
        Person alivewater = new Person("jhosef", "alivewater");

        pd.savePerson(giulio);
        pd.savePerson(carlo);
        pd.savePerson(francesco);
        pd.savePerson(davide);
        pd.savePerson(alivewater);

        Person person_1 = pd.getPerson(1);
        Person person_2 = pd.getPerson(2);
        Person person_3 = pd.getPerson(3);
        Person person_4 = pd.getPerson(4);
        Person person_5 = pd.getPerson(5);

        //CREAZIONE VENDUIITORI
        Seller seller_1 = new Seller("Tabbaccheria da pippo");
        Seller seller_2 = new Seller("Bar peppino ghost");
        Automatic_seller automaticSeller_1 = new Automatic_seller("Maachinetta a342", true);
        Automatic_seller automaticSeller_2 = new Automatic_seller("Maachinetta 223io", false);
        Automatic_seller automaticSeller_3 = new Automatic_seller("Maachinetta 23213f", true);
        Automatic_seller automaticSeller_4 = new Automatic_seller("Maachinetta asd23", false);

        sd.saveSeller(seller_1);
        sd.saveSeller(seller_2);
        sd.saveSeller(automaticSeller_1);
        sd.saveSeller(automaticSeller_2);
        sd.saveSeller(automaticSeller_3);
        sd.saveSeller(automaticSeller_4);

        Seller seller_dao_1 = sd.getSeller(1);
        Seller seller_dao_2 = sd.getSeller(2);
        Seller seller_dao_3 = sd.getSeller(3);
        Seller seller_dao_4 = sd.getSeller(4);
        Seller seller_dao_5 = sd.getSeller(5);
        Seller seller_dao_6 = sd.getSeller(6);

        //CREAZIONE ROTTE
        Route route_1 = new Route("Naples", "Rome", 120);
        Route route_2 = new Route("Milano", "Rome", 220);
        Route route_3 = new Route("Roma", "casa di peppino", 20);
        Route route_4 = new Route("Firenza", "Bergamo", 72);
        Route route_5 = new Route("Udine", "Acquaviva", 94);

        rd.saveRoute(route_1);
        rd.saveRoute(route_2);
        rd.saveRoute(route_3);
        rd.saveRoute(route_4);
        rd.saveRoute(route_5);

        Route route_dao_1 = rd.getRoute(1);
        Route route_dao_2 = rd.getRoute(2);
        Route route_dao_3 = rd.getRoute(3);
        Route route_dao_4 = rd.getRoute(4);
        Route route_dao_5 = rd.getRoute(5);

        //CREAZIONE TICKET
        Ticket ticket_1 = new Ticket(seller_dao_1, route_dao_1);
        Ticket ticket_2 = new Ticket(seller_dao_2, route_dao_4);
        Ticket ticket_3 = new Ticket(seller_dao_3, route_dao_5);
        Ticket ticket_4 = new Ticket(seller_dao_4, route_dao_3);
        Ticket ticket_5 = new Ticket(seller_dao_5, route_dao_5);
        Ticket ticket_6 = new Ticket(seller_dao_1, route_dao_1);
        Ticket ticket_7 = new Ticket(seller_dao_2, route_dao_3);
        Ticket ticket_8 = new Ticket(seller_dao_3, route_dao_4);
        Ticket ticket_9 = new Ticket(seller_dao_4, route_dao_2);
        Ticket ticket_10 = new Ticket(seller_dao_5, route_dao_4);
        Ticket ticket_11 = new Ticket(seller_dao_1, route_dao_1);
        Ticket ticket_12 = new Ticket(seller_dao_2, route_dao_3);
        Ticket ticket_13 = new Ticket(seller_dao_3, route_dao_2);
        Ticket ticket_14 = new Ticket(seller_dao_4, route_dao_1);
        Ticket ticket_15 = new Ticket(seller_dao_5, route_dao_2);
        Ticket ticket_16 = new Ticket(seller_dao_6, route_dao_5);
        Ticket ticket_17 = new Ticket(seller_dao_6, route_dao_4);

        td.saveTicket(ticket_1);
        td.saveTicket(ticket_2);
        td.saveTicket(ticket_3);
        td.saveTicket(ticket_4);
        td.saveTicket(ticket_5);
        td.saveTicket(ticket_6);
        td.saveTicket(ticket_7);
        td.saveTicket(ticket_8);
        td.saveTicket(ticket_9);
        td.saveTicket(ticket_10);
        td.saveTicket(ticket_11);
        td.saveTicket(ticket_12);
        td.saveTicket(ticket_13);
        td.saveTicket(ticket_14);
        td.saveTicket(ticket_15);
        td.saveTicket(ticket_16);
        td.saveTicket(ticket_17);

        Ticket ticket_dao_1 = td.getTicket(1);
        Ticket ticket_dao_2 = td.getTicket(2);
        Ticket ticket_dao_3 = td.getTicket(3);
        Ticket ticket_dao_4 = td.getTicket(4);
        Ticket ticket_dao_5 = td.getTicket(5);
        Ticket ticket_dao_6 = td.getTicket(6);
        Ticket ticket_dao_7 = td.getTicket(7);
        Ticket ticket_dao_8 = td.getTicket(8);
        Ticket ticket_dao_9 = td.getTicket(9);
        Ticket ticket_dao_10 = td.getTicket(10);
        Ticket ticket_dao_11 = td.getTicket(11);
        Ticket ticket_dao_12 = td.getTicket(12);
        Ticket ticket_dao_13 = td.getTicket(13);
        Ticket ticket_dao_14 = td.getTicket(14);
        Ticket ticket_dao_15 = td.getTicket(15);
        Ticket ticket_dao_16 = td.getTicket(16);
        Ticket ticket_dao_17 = td.getTicket(17);

        //CREAZIONE TRANSPORTI
        Transport transport1 = new Transport(Transport_type.TRAM, false, "A241", route_dao_1);
        Transport transport2 = new Transport(Transport_type.AUTOBUS, false, "A11", route_dao_2);
        Transport transport3 = new Transport(Transport_type.TRAM, false, "A22", route_dao_3);
        Transport transport4 = new Transport(Transport_type.AUTOBUS, true, "A33", route_dao_4);
        Transport transport5 = new Transport(Transport_type.TRAM, true, "A124", route_dao_5);
        Transport transport6 = new Transport(Transport_type.TRAM, false, "A3423", route_dao_5);
        Transport transport7 = new Transport(Transport_type.AUTOBUS, false, "APEPPINO", route_dao_4);
        Transport transport8 = new Transport(Transport_type.TRAM, true, "A342", route_dao_3);
        Transport transport9 = new Transport(Transport_type.AUTOBUS, false, "A54734", route_dao_2);
        Transport transport10 = new Transport(Transport_type.TRAM, false, "A534253", route_dao_1);

        trd.saveTrans(transport1);
        trd.saveTrans(transport2);
        trd.saveTrans(transport3);
        trd.saveTrans(transport4);
        trd.saveTrans(transport5);
        trd.saveTrans(transport6);
        trd.saveTrans(transport7);
        trd.saveTrans(transport8);
        trd.saveTrans(transport9);
        trd.saveTrans(transport10);

        Transport transport_1_dao = trd.getTransport(1);
        Transport transport_2_dao = trd.getTransport(2);
        Transport transport_3_dao = trd.getTransport(3);
        Transport transport_4_dao = trd.getTransport(4);
        Transport transport_5_dao = trd.getTransport(5);
        Transport transport_6_dao = trd.getTransport(6);
        Transport transport_7_dao = trd.getTransport(7);
        Transport transport_8_dao = trd.getTransport(8);
        Transport transport_9_dao = trd.getTransport(9);
        Transport transport_10_dao = trd.getTransport(10);

        //CREAZIONE CARD

        Card card1 = new Card(LocalDate.of(2024, 4, 10), LocalDate.of(2023, 4, 10), person_5);
        Card card2 = new Card(LocalDate.of(2024, 10, 23), LocalDate.of(2023, 10, 23), person_4);
        Card card3 = new Card(LocalDate.of(2024, 8, 12), LocalDate.of(2023, 8, 12), person_3);
        Card card4 = new Card(LocalDate.of(2025, 1, 4), LocalDate.of(2024, 1, 4), person_2);
        Card card5 = new Card(LocalDate.of(2024, 11, 2), LocalDate.of(2023, 11, 2), person_1);

        cd.saveCard(card1);
        cd.saveCard(card2);
        cd.saveCard(card3);
        cd.saveCard(card4);
        cd.saveCard(card5);

        Card card_dao_1 = cd.getCard(1);
        Card card_dao_2 = cd.getCard(2);
        Card card_dao_3 = cd.getCard(3);
        Card card_dao_4 = cd.getCard(4);
        Card card_dao_5 = cd.getCard(5);

        //CREAZIONE ABBONAMENTI
        Subscription subscription1 = new Subscription(Periodicity.WEEKLY, LocalDate.now(), card_dao_1, seller_dao_1);
        Subscription subscription2 = new Subscription(Periodicity.MONTHLY, LocalDate.of(2024, 6, 2), card_dao_2, seller_dao_2);
        Subscription subscription3 = new Subscription(Periodicity.MONTHLY, LocalDate.of(2024, 6, 12), card_dao_3, seller_dao_3);
        Subscription subscription4 = new Subscription(Periodicity.WEEKLY, LocalDate.of(2024, 6, 6), card_dao_4, seller_dao_4);

        sbd.saveSubscription(subscription1);
        sbd.saveSubscription(subscription2);
        sbd.saveSubscription(subscription3);
        sbd.saveSubscription(subscription4);

        /*Subscription subscription_dao_1 = sbd.getSubscription(1);
        Subscription subscription_dao_2 = sbd.getSubscription(2);
        Subscription subscription_dao_3 = sbd.getSubscription(3);
        Subscription subscription_dao_4 = sbd.getSubscription(4);*/

        //CREAZIONE MANUTENZIONI
       /* Maintenance maintenance1 = new Maintenance(LocalDate.now(), null, transport_4_dao);
        Maintenance maintenance2 = new Maintenance(LocalDate.of(2024, 5, 1), null, transport_5_dao);
        Maintenance maintenance3 = new Maintenance(LocalDate.of(2024, 2, 12), null, transport_8_dao);
        Maintenance maintenance4 = new Maintenance(LocalDate.of(2023, 12, 3), LocalDate.of(2024, 2, 4), transport_1_dao);
        Maintenance maintenance5 = new Maintenance(LocalDate.of(2023, 12, 3), LocalDate.of(2024, 2, 4), transport_2_dao);
        Maintenance maintenance6 = new Maintenance(LocalDate.of(2001, 12, 3), LocalDate.of(2003, 4, 12), transport_3_dao);
        Maintenance maintenance7 = new Maintenance(LocalDate.of(2020, 12, 3), LocalDate.of(2021, 10, 4), transport_6_dao);
        Maintenance maintenance8 = new Maintenance(LocalDate.of(2023, 12, 3), LocalDate.of(2024, 2, 4), transport_7_dao);
        Maintenance maintenance9 = new Maintenance(LocalDate.of(2021, 3, 3), LocalDate.of(2022, 4, 27), transport_3_dao);
        Maintenance maintenance10 = new Maintenance(LocalDate.of(2023, 12, 3), LocalDate.of(2024, 12, 6), transport_4_dao);
        Maintenance maintenance11 = new Maintenance(LocalDate.of(1998, 12, 3), LocalDate.of(2000, 6, 4), transport_7_dao);
        Maintenance maintenance12 = new Maintenance(LocalDate.of(2023, 12, 3), LocalDate.of(2024, 2, 4), transport_8_dao);
        Maintenance maintenance13 = new Maintenance(LocalDate.of(2002, 12, 3), LocalDate.of(2004, 2, 4), transport_7_dao);
        Maintenance maintenance14 = new Maintenance(LocalDate.of(2023, 6, 2), LocalDate.of(2023, 8, 3), transport_2_dao);

        trd.saveMaintenence(maintenance1);
        trd.saveMaintenence(maintenance2);
        trd.saveMaintenence(maintenance3);
        trd.saveMaintenence(maintenance4);
        trd.saveMaintenence(maintenance5);
        trd.saveMaintenence(maintenance6);
        trd.saveMaintenence(maintenance7);
        trd.saveMaintenence(maintenance8);
        trd.saveMaintenence(maintenance9);
        trd.saveMaintenence(maintenance10);
        trd.saveMaintenence(maintenance11);
        trd.saveMaintenence(maintenance12);
        trd.saveMaintenence(maintenance13);
        trd.saveMaintenence(maintenance14);

        //MEZZO_TRATTA
        Transport_route transport_route1 = new Transport_route(transport_1_dao, route_dao_1, LocalDate.of(2024, 1, 21));
        Transport_route transport_route2 = new Transport_route(transport_1_dao, route_dao_1, LocalDate.of(2024, 2, 12));
        Transport_route transport_route3 = new Transport_route(transport_1_dao, route_dao_1, LocalDate.of(2024, 3, 10));
        Transport_route transport_route4 = new Transport_route(transport_2_dao, route_dao_2, LocalDate.of(2024, 1, 12));
        Transport_route transport_route5 = new Transport_route(transport_2_dao, route_dao_2, LocalDate.of(2024, 1, 21));
        Transport_route transport_route6 = new Transport_route(transport_3_dao, route_dao_3, LocalDate.of(2024, 2, 12));
        Transport_route transport_route7 = new Transport_route(transport_3_dao, route_dao_3, LocalDate.of(2024, 2, 1));
        Transport_route transport_route8 = new Transport_route(transport_3_dao, route_dao_3, LocalDate.of(2024, 3, 6));
        Transport_route transport_route9 = new Transport_route(transport_4_dao, route_dao_4, LocalDate.of(2024, 1, 12));
        Transport_route transport_route10 = new Transport_route(transport_4_dao, route_dao_4, LocalDate.of(2024, 1, 4));
        Transport_route transport_route11 = new Transport_route(transport_4_dao, route_dao_4, LocalDate.of(2024, 2, 12));
        Transport_route transport_route12 = new Transport_route(transport_4_dao, route_dao_4, LocalDate.of(2024, 4, 12));
        Transport_route transport_route13 = new Transport_route(transport_5_dao, route_dao_5, LocalDate.of(2024, 1, 1));
        Transport_route transport_route14 = new Transport_route(transport_5_dao, route_dao_5, LocalDate.of(2024, 1, 12));
        Transport_route transport_route15 = new Transport_route(transport_6_dao, route_dao_5, LocalDate.of(2024, 2, 11));
        Transport_route transport_route16 = new Transport_route(transport_7_dao, route_dao_1, LocalDate.of(2023, 1, 5));
        Transport_route transport_route17 = new Transport_route(transport_7_dao, route_dao_1, LocalDate.of(2023, 2, 5));
        Transport_route transport_route18 = new Transport_route(transport_7_dao, route_dao_1, LocalDate.of(2023, 2, 12));
        Transport_route transport_route19 = new Transport_route(transport_8_dao, route_dao_2, LocalDate.of(2024, 1, 5));
        Transport_route transport_route20 = new Transport_route(transport_8_dao, route_dao_3, LocalDate.of(2024, 2, 12));
        Transport_route transport_route21 = new Transport_route(transport_9_dao, route_dao_4, LocalDate.of(2024, 3, 7));
        Transport_route transport_route22 = new Transport_route(transport_10_dao, route_dao_4, LocalDate.of(2024, 11, 23));
        Transport_route transport_route23 = new Transport_route(transport_10_dao, route_dao_4, LocalDate.of(2024, 9, 12));
        Transport_route transport_route24 = new Transport_route(transport_10_dao, route_dao_1, LocalDate.of(2024, 8, 21));
        Transport_route transport_route25 = new Transport_route(transport_10_dao, route_dao_1, LocalDate.of(2024, 6, 6));

        trans_rD.saveTransportRoute(transport_route1);
        trans_rD.saveTransportRoute(transport_route2);
        trans_rD.saveTransportRoute(transport_route3);
        trans_rD.saveTransportRoute(transport_route4);
        trans_rD.saveTransportRoute(transport_route5);
        trans_rD.saveTransportRoute(transport_route6);
        trans_rD.saveTransportRoute(transport_route7);
        trans_rD.saveTransportRoute(transport_route8);
        trans_rD.saveTransportRoute(transport_route9);
        trans_rD.saveTransportRoute(transport_route10);
        trans_rD.saveTransportRoute(transport_route11);
        trans_rD.saveTransportRoute(transport_route12);
        trans_rD.saveTransportRoute(transport_route13);
        trans_rD.saveTransportRoute(transport_route14);
        trans_rD.saveTransportRoute(transport_route15);
        trans_rD.saveTransportRoute(transport_route16);
        trans_rD.saveTransportRoute(transport_route17);
        trans_rD.saveTransportRoute(transport_route18);
        trans_rD.saveTransportRoute(transport_route19);
        trans_rD.saveTransportRoute(transport_route20);
        trans_rD.saveTransportRoute(transport_route21);
        trans_rD.saveTransportRoute(transport_route22);
        trans_rD.saveTransportRoute(transport_route23);
        trans_rD.saveTransportRoute(transport_route24);
        trans_rD.saveTransportRoute(transport_route25);













        /*METODO PER IL CONTROLLO DEL ABBONAMENTO:
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
        System.out.println(trans_rD.allTotaleTimeTransportRoute(1, 1));*/


    }
}
