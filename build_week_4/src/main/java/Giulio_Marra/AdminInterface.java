package Giulio_Marra;

import Giulio_Marra.Dao.*;
import Giulio_Marra.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class AdminInterface {
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

        Scanner scanner = new Scanner(System.in);
        boolean continuaCiclo = true;

        do {
            System.out.println("Benvenuto Amministratore. Scegli un'opzione:");
            System.out.println("1. Calcola il numero di biglietti e abbonamenti venduti da un punto vendita.");
            System.out.println("2. Restituisci la lista dei mezzi in manutenzione.");
            System.out.println("3. Ottieni informazioni sul trasporto e sulla route associata.");
            System.out.println("4. Ottieni informazioni relative alle frequenza del mezzo scelto.");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Inserisci l'ID del punto vendita:");
                    int sellerId = scanner.nextInt();
                    Seller seller = sd.getSeller(sellerId);

                    if (seller != null) {
                        long numTickets = td.NumberOfTicketBySeller(seller);
                        long numSubscriptions = td.NumberOfSubscriptionBySeller(seller);
                        System.out.println("Numero di biglietti venduti dal punto vendita: " + numTickets);
                        System.out.println("Numero di abbonamenti venduti dal punto vendita: " + numSubscriptions);
                    } else {
                        System.out.println("Punto vendita non trovato.");
                    }
                    break;

                case 2:
                    List<Transport> transportsInMaintenance = trd.getTransportsInMaintenance();
                    if (transportsInMaintenance.isEmpty()) {
                        System.out.println("Nessun mezzo in manutenzione.");
                    } else {
                        System.out.println("Lista dei mezzi in manutenzione:");
                        for (Transport transport : transportsInMaintenance) {
                            System.out.println("ID: " + transport.getId() + ", Tipo: " + transport.getTransport_type() + ", Nome: " + transport.getName());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Inserisci l'ID del mezzo di trasporto:");
                    int transportId = scanner.nextInt();
                    Transport transport = trd.getTransport(transportId);

                    if (transport != null) {
                        List<Transport_route> transportRoutes = trans_rD.getTransportRoutesByTransport(transport);
                        if (transportRoutes.isEmpty()) {
                            System.out.println("Nessuna route trovata per il trasporto con ID " + transportId);
                        } else {
                            System.out.println("Informazioni sul trasporto e sulla route associata per ID " + transportId + ":");
                            System.out.println("ID del trasporto: " + transport.getId());
                            System.out.println("Tipo di trasporto: " + transport.getTransport_type());
                            System.out.println("Nome del trasporto: " + transport.getName());


                            for (Transport_route transportRoute : transportRoutes) {
                                Route route = transportRoute.getRoute();
                                System.out.println("ID Route: " + route.getId());
                                System.out.println("Starting Area: " + route.getStarting_area());
                                System.out.println("Terminal Area: " + route.getTerminal_area());
                                System.out.println("Average Travel Time: " + route.getAvg_travel_time() +  " " + "Ore");
                                System.out.println("-------------------------");
                            }
                        }
                    } else {
                        System.out.println("Trasporto non trovato con ID " + transportId);
                    }
                    break;
                case 4:
                    System.out.println("Inserisci l'ID del mezzo di trasporto:");
                    int transportIdFreq = scanner.nextInt();
                    Transport transportFreq = trd.getTransport(transportIdFreq);

                    if (transportFreq != null) {
                        List<Transport_route> transportRoutesFreq = trans_rD.getTransportRoutesByTransport(transportFreq);
                        if (transportRoutesFreq.isEmpty()) {
                            System.out.println("Nessuna route trovata per il trasporto con ID " + transportIdFreq);
                        } else {
                            System.out.println("Frequenza del bus per il trasporto con ID " + transportIdFreq + ":");
                            for (Transport_route transportRoute : transportRoutesFreq) {
                                Route route = transportRoute.getRoute();
                                System.out.println("ID Route: " + route.getId());
                                System.out.println("Frequenza: " + transportRoute.getFrequency() + " volte al giorno");
                                System.out.println("-------------------------");
                            }
                        }
                    } else {
                        System.out.println("Trasporto non trovato con ID " + transportIdFreq);
                    }
                    break;

                default:
                    System.out.println("Opzione non valida.");
                    break;
            }


            System.out.println("Vuoi continuare? (si/no)");
            String risposta = scanner.next();
            continuaCiclo = risposta.equalsIgnoreCase("si");

        } while (continuaCiclo);

        em.close();
        emf.close();
        scanner.close();
    }
}