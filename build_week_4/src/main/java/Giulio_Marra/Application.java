package Giulio_Marra;

import Giulio_Marra.Dao.*;
import Giulio_Marra.entities.*;
import Giulio_Marra.enums.periodicity;
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
        TicketDao td= new TicketDao(em);
        CardDAO cd=new CardDAO(em);
        RouteDAO rd=new RouteDAO(em);
        SellerDAO sd=new SellerDAO(em);
        SubscriptionDAO sbd=new SubscriptionDAO(em);
        TransportDAO trd=new TransportDAO(em);


        //Creazione degli utenti:
        Person user_1=new Person("Carlo","Patalano");
        Person user_2=new Person("Davide","Prelati");
        Person user_3=new Person("Giulio","Marra");
        //Salvataggio Utenti:
        //pd.savePerson(user_1);
        //pd.savePerson(user_2);
        //pd.savePerson(user_3);

        //creazione Distrubutorì e negozio
        Seller  distributor= new Automatic_seller("Distributore automatico",true);
        Seller authorized_seller=new Seller("Negozio Autorizzato");

        //Salvataggio:

        //pd.saveSeller(distributor);
        //pd.saveSeller(authorized_seller);

        //Rotta creata Numero1:
        Route route_1= new Route("Napoli","Roma",2.50);
        //Salvataggio Rotta
        //pd.saveRoute(route_1);

        //Mezzo di trasporto con rotta:
        Route routeCollegata=rd.getRoute(1);
        Transport transport_1=new Transport(transport_type.AUTOBUS,false,"Tomas",routeCollegata);
        //pd.saveTrans(transport_1);





        Person person_1= pd.getPerson(1);
        Card Card_2=cd.getCard(1);
        Seller seller_1=sd.getSeller(1);
       Card card_1=new Card(LocalDate.now().plusYears(1),LocalDate.now(),person_1);
       //pd.saveCard(card_1);
       Subscription subscription_1=new Subscription(periodicity.MONTHLY,LocalDate.now(),Card_2,seller_1);
       //pd.saveSubscription(subscription_1);

        Transport transport1=trd.getTransport(1);
        Ticket ticket_1=new Ticket(false,seller_1,person_1,transport1);
        //pd.saveTicket(ticket_1);



        Ticket ticketFromDB=td.getTicket(1);
        //td.stampTicket(ticketFromDB);


        //METODO PER IL CONTROLLO DEL ABBONAMENTO:

        //Creazione Utenti
        Person user_4=new Person("Francesco","Cossu");
        Person user_5=new Person("Franco"," Franchi");
        //pd.savePerson(user_4);
        //pd.savePerson(user_5);

        Card card_3 = new Card(LocalDate.now().plusYears(1), LocalDate.now(), user_4);
        Card card_4 = new Card(LocalDate.now().minusMonths(1), LocalDate.now().minusMonths(1), user_5);
        //pd.saveCard(card_3);
        //pd.saveCard(card_4);




        Subscription subscription_3 = new Subscription(periodicity.MONTHLY, LocalDate.now(), card_3, distributor);
        Subscription subscription_4 = new Subscription(periodicity.MONTHLY, LocalDate.now().minusMonths(1), card_4, distributor);
        //pd.saveSubscription(subscription_3);
        //pd.saveSubscription(subscription_4);

        Route route_2= new Route("Napoli","Milano",6);
        Route route_3= new Route("Verona","Parma",3.4);
        Route route_4= new Route("Milano","Scilla",11.30);
        //pd.saveRoute(route_2);
        //pd.saveRoute(route_3);
        //pd.saveRoute(route_4);



        Route route2Collegata=rd.getRoute(2);
        Route route3Collegata=rd.getRoute(3);
        Route route4Collegata=rd.getRoute(4);

        Transport transport_2=new Transport(transport_type.TRAM,false,"5",route2Collegata);
        Transport transport_3=new Transport(transport_type.TRAM,false,"3",route3Collegata);
        Transport transport_4=new Transport(transport_type.AUTOBUS,false,"600",route4Collegata);


        //pd.saveTrans(transport_2);
        //pd.saveTrans(transport_3);
       // pd.saveTrans(transport_4);


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

    }
}
