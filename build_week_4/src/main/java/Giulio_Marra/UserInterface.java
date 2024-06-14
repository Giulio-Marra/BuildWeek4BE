package Giulio_Marra;

import Giulio_Marra.Dao.*;
import Giulio_Marra.entities.*;
import Giulio_Marra.enums.Periodicity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("build_week_4");
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        PersonDAO pd = new PersonDAO(em);
        TicketDAO td = new TicketDAO(em);
        CardDAO cd = new CardDAO(em);
        RouteDAO rd = new RouteDAO(em);
        SellerDAO sd = new SellerDAO(em);
        SubscriptionDAO sbd = new SubscriptionDAO(em);
        TransportDAO trd = new TransportDAO(em);
        Transport_routeDAO trrd = new Transport_routeDAO(em);





        while(true){
            System.out.println("Seleziona\n1 per acquistare un biglietto/abbonamento\n2 per controllare lo stato del tuo abbonamento\n3 per scegliere la tratta\n0 per uscire");
            String response = scanner.nextLine();
            if (response.equals("0")){
                break;
            }
            switch (response){
                case "1":
                    System.out.println("seleziona 1 per biglietto, 2 per abbonamento");
                    String response1 = scanner.nextLine();
                    switch (response1){
                        case "1":
                            sd.printAllSellers();
                            System.out.println("Inserisci l'id del punto vendita");
                            long seller_id = Long.parseLong(scanner.nextLine());
                            Seller seller = sd.getSeller(seller_id);
                            rd.printAllRoutes();
                            System.out.println("Inserisci l'id della tratta");
                            long route_id = Long.parseLong(scanner.nextLine());
                            Route route = rd.getRoute(route_id);
                            Ticket ticket = new Ticket(seller, route);
                            td.saveTicket(ticket);
                            System.out.println("Biglietto comprato!");
                            break;
                        case "2":
                            System.out.println("Inserisci l'id della tua tessera");
                            long card_id = Long.parseLong(scanner.nextLine());
                            if (cd.getCard(card_id) != null && !cd.isCardExpired(card_id)){
                               Card card =  cd.getCard(card_id);
                                sd.printAllSellers();
                                System.out.println("Inserisci l'id del punto vendita");
                                long seller_id2 = Long.parseLong(scanner.nextLine());
                                Seller seller2 = sd.getSeller(seller_id2);
                                System.out.println("Inserisci la periodicità dell'abbonamento (1 per settimanale, 2 per mensile)");
                                String resp = scanner.nextLine();
                                switch (resp){
                                    case "1":
                                        Periodicity periodicity = Periodicity.WEEKLY;
                                        Subscription subscription = new Subscription(periodicity, card, seller2);
                                        if(!sbd.subscriptionByCard(card)){
                                            sbd.saveSubscription(subscription);
                                            System.out.println("Abbonamento acquistato!");
                                        } else {
                                            System.out.println("Questa tessera ha già un abbonamento attivo.");
                                        }

                                        break;
                                    case "2":
                                        Periodicity periodicity2 = Periodicity.MONTHLY;
                                        Subscription subscription2 = new Subscription(periodicity2, card, seller2);
                                        if (!sbd.subscriptionByCard(card)){
                                            sbd.saveSubscription(subscription2);
                                            System.out.println("Abbonamento acquistato!");
                                        } else {
                                            System.out.println("Questa tessera ha già un abbonamento attivo.");
                                        }
                                        break;
                                }



                            }else{
                                System.out.println("Tessera non trovata o scaduta.");
                            }


                    }
                    break;

                case "2":
                    System.out.println("Inserisci l'id della tessera");
                    long id_tessera = Long.parseLong(scanner.nextLine());
                    sbd.getSubscriptionByCardID(id_tessera);
                    Subscription sub = sbd.getSubscription(id_tessera);
                    if (sbd.isSubscriptionValid(id_tessera) && !sbd.isSubscriptionExpired(sub)) {
                        System.out.println("Abbonamento valido");
                    } else {
                        System.out.println("Abbonamento scaduto, vuoi rinnovarlo ? 1 per si, 2 per no");
                        String resp = scanner.nextLine();
                        if (resp.equals("1")) {
                            System.out.println("Inserisci quanto vuoi estendere il tuo abbonamento (1 per settimanale, 2 per mensile)");
                            String resp2 = scanner.nextLine();
                            Subscription subscription = sbd.getSubscription(id_tessera);
                            switch (resp2) {
                                case "1":
                                    sbd.renewWeeklySubscription(subscription);
                                    System.out.println("Abbonamento rinnovato");
                                    break;
                                case "2":
                                    sbd.renewMonthlySubscription(subscription);
                                    System.out.println("Abbonamento rinnovato");
                                    break;
                            }
                        }
                        break;
                    }

                    break;
                case "3":
                    rd.printAllRoutes();
                    System.out.println("Inserisci l'id della tratta che vuoi percorrere");
                    long id_tratta = Long.parseLong(scanner.nextLine());
                    Route route = rd.getRoute(id_tratta);
                    trd.getTransportsByRouteID(id_tratta);
                    System.out.println("seleziona l'id del mezzo che vuoi prendere");
                    long id_mezzo = Long.parseLong(scanner.nextLine());
                    Transport transport = trd.getTransport(id_mezzo);
                    System.out.println("vuoi utilizzare un biglietto o l'abbonamento ? 1 per biglietto, 2 per abbonamento");
                    String respon = scanner.nextLine();
                    if (respon.equals("1")){
                        td.printTicketsByRouteID(id_tratta);
                        System.out.println("seleziona l'id del biglietto che vuoi timbrare");
                        long id_biglietto = Long.parseLong(scanner.nextLine());
                        Ticket ticket = td.getTicket(id_biglietto);
                        td.stampTicket(ticket, transport);
                        System.out.println("Biglietto timbrato, buon viaggio!");
                        Transport_route transroute = new Transport_route(transport, route, LocalDate.now());
                        trrd.saveTransportRoute(transroute);

                        break;
                    }else if (respon.equals("2")){
                        System.out.println("inserisci l'id della tessera");
                        long id_tessera2 = Long.parseLong(scanner.nextLine());
                        Subscription sub2 = sbd.returnSubscriptionByCardID(id_tessera2);
                         sbd.getSubscriptionByCardID(id_tessera2);
                         if(cd.isCardExpired(id_tessera2)){
                             System.out.println("Questa tessera è scaduta.");
                             break;
                         }else if (sbd.isSubscriptionValid(id_tessera2) && !sbd.isSubscriptionExpired(sub2)) {
                             System.out.println("Abbonamento valido, buon viaggio!");
                             Transport_route transroute = new Transport_route(transport, route, LocalDate.now());
                             trrd.saveTransportRoute(transroute);
                             break;
                        } else {
                            System.out.println("L'abbonamento è scaduto.");
                            break;

                        }

                    }


            }
        }
    }
}
