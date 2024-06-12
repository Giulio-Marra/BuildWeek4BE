package Giulio_Marra;

import Giulio_Marra.Dao.PersonDAO;
import Giulio_Marra.Dao.TicketDao;
import Giulio_Marra.entities.*;
import Giulio_Marra.enums.periodicity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.sql.Update;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("build_week_4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        PersonDAO pd = new PersonDAO(em);
        TicketDao td= new TicketDao(em);


        //Creazione degli utenti:
        Person user_1=new Person("Carlo","Patalano");
        Person user_2=new Person("Davide","Prelati");
        Person user_3=new Person("Giulio","Marra");
        Person user_4=new Person("Francesco","Cossu");
        Person user_5=new Person("Franco"," Franchi");
        //Salvataggio Utenti:
        //pd.savePerson(user_1);
        //pd.savePerson(user_2);
        //pd.savePerson(user_3);
        //pd.savePerson(user_4);
        //pd.savePerson(user_5);

        //creazione Distrubutorì e negozio
        Seller  distributor= new Automatic_seller("Distributore automatico",true);
        Seller authorized_seller=new Seller("Negozio Autorizzato");

        //Salvataggio:
        em.getTransaction().begin();
        //em.persist(distributor);
        //em.persist(authorized_seller);
        em.getTransaction().commit();
        //pd.saveSeller(distributor);
        //pd.saveSeller(authorized_seller);

        //Rotta creata:
        Route route_1= new Route("Roma termini","Roma tiburtina",0.35);
        Route route_2= new Route("Napoli","Milano",6);
        Route route_3= new Route("Verona","Parma",3.4);
        Route route_4= new Route("Milano","Scilla",11.30);
        //Salvataggio Rotta
        //pd.saveRoute(route_1);
        //pd.saveRoute(route_2);
        // pd.saveRoute(route_3);
        // pd.saveRoute(route_4);

        //Mezzo di trasporto con rotta:
        Route route1Collegata=pd.getRoute(1);
        Route route2Collegata=pd.getRoute(2);
        Route route3Collegata=pd.getRoute(3);
        Route route4Collegata=pd.getRoute(4);
        Transport transport_1=new Transport(transport_type.AUTOBUS,false,"Tomas",route1Collegata);
        Transport transport_2=new Transport(transport_type.TRAM,false,"5",route2Collegata);
        Transport transport_3=new Transport(transport_type.TRAM,false,"3",route3Collegata);
        Transport transport_4=new Transport(transport_type.AUTOBUS,false,"600",route4Collegata);

        //pd.saveTrans(transport_1);
        //pd.saveTrans(transport_2);
        //pd.saveTrans(transport_3);
        //pd.saveTrans(transport_4);



        Person person_1= pd.getPerson(1);
        Person person_2= pd.getPerson(2);
        Person person_3= pd.getPerson(3);
        Person person_4= pd.getPerson(4);
        Person person_5= pd.getPerson(5);

       Card card_1=new Card(LocalDate.now().plusYears(1),LocalDate.now(),person_1);
       Card card_2=new Card(LocalDate.now().plusYears(1),LocalDate.now(),person_2);
       Card card_3=new Card(LocalDate.now().plusYears(1),LocalDate.now(),person_3);
       Card card_4=new Card(LocalDate.now().plusYears(1),LocalDate.now(),person_4);
       Card card_5=new Card(LocalDate.now().plusYears(1),LocalDate.now(),person_5);
       //pd.saveCard(card_1);
        //pd.saveCard(card_2);
        //pd.saveCard(card_3);
        //pd.saveCard(card_4);
        //pd.saveCard(card_5);

        Card card1=pd.getCard(1);
        Card card2=pd.getCard(2);
        Card card3=pd.getCard(3);
        Card card4=pd.getCard(4);
        Card card5=pd.getCard(5);
        Seller seller_1=pd.getSeller(1);
        Seller seller_2=pd.getSeller(2);
       Subscription subscription_1=new Subscription(periodicity.MONTHLY,LocalDate.now(),card1,seller_1);
       Subscription subscription_2=new Subscription(periodicity.WEEKLY,LocalDate.now(),card2,seller_2);
       Subscription subscription_3=new Subscription(periodicity.MONTHLY,LocalDate.now(),card3,seller_2);
       Subscription subscription_4=new Subscription(periodicity.WEEKLY,LocalDate.now(),card4,seller_2);
       Subscription subscription_5=new Subscription(periodicity.MONTHLY,LocalDate.now(),card5,seller_1);
       //pd.saveSubscription(subscription_1);
        //pd.saveSubscription(subscription_2);
        //pd.saveSubscription(subscription_3);
        //pd.saveSubscription(subscription_4);
        //pd.saveSubscription(subscription_5);

        Seller seller1 = pd.getSeller(1);
        Seller seller2 = pd.getSeller(2);

        Transport transport1=pd.getTransport(1);
        Transport transport2=pd.getTransport(2);
        Transport transport3=pd.getTransport(3);
        Transport transport4=pd.getTransport(4);
        Ticket ticket_1=new Ticket(false, seller1, person_3, transport1);
        Ticket ticket_2=new Ticket(false, seller2, person_3, transport2);
        Ticket ticket_3=new Ticket(false, seller2, person_3, transport3);
        Ticket ticket_4=new Ticket(false, seller1, person_3, transport4);
        Ticket ticket_5=new Ticket(false, seller1, person_3, transport1);
        Ticket ticket_6=new Ticket(false, seller2, person_1, transport2);
        Ticket ticket_7=new Ticket(false, seller1, person_1, transport3);
        Ticket ticket_8=new Ticket(false, seller2, person_1, transport4);
        Ticket ticket_9=new Ticket(false, seller1, person_1, transport1);
        Ticket ticket_10=new Ticket(false, seller1, person_1, transport2);
        Ticket ticket_11=new Ticket(false, seller2, person_2, transport3);
        Ticket ticket_12=new Ticket(false, seller2, person_2, transport1);
        Ticket ticket_13=new Ticket(false, seller1, person_2, transport2);
        Ticket ticket_14=new Ticket(false, seller1, person_2, transport4);
        Ticket ticket_15=new Ticket(false, seller2, person_2, transport3);
        Ticket ticket_16=new Ticket(false, seller1, person_4, transport4);
        Ticket ticket_17=new Ticket(false, seller2, person_4, transport1);
        Ticket ticket_18=new Ticket(false, seller2, person_4, transport2);
        Ticket ticket_19=new Ticket(false, seller2, person_4, transport3);
        Ticket ticket_20=new Ticket(false, seller1, person_4, transport4);
        Ticket ticket_21=new Ticket(false, seller2, person_5, transport1);
        Ticket ticket_22=new Ticket(false, seller1, person_5, transport4);
        Ticket ticket_23=new Ticket(false, seller1, person_5, transport2);
        Ticket ticket_24=new Ticket(false, seller1, person_5, transport2);
        Ticket ticket_25=new Ticket(false, seller2, person_5, transport3);
        pd.saveTicket(ticket_1);
        pd.saveTicket(ticket_2);
        pd.saveTicket(ticket_3);
        pd.saveTicket(ticket_4);
        pd.saveTicket(ticket_5);
        pd.saveTicket(ticket_6);
        pd.saveTicket(ticket_7);
        pd.saveTicket(ticket_8);
        pd.saveTicket(ticket_9);
        pd.saveTicket(ticket_10);
        pd.saveTicket(ticket_11);
        pd.saveTicket(ticket_12);
        pd.saveTicket(ticket_13);
        pd.saveTicket(ticket_14);
        pd.saveTicket(ticket_15);
        pd.saveTicket(ticket_16);
        pd.saveTicket(ticket_17);
        pd.saveTicket(ticket_18);
        pd.saveTicket(ticket_19);
        pd.saveTicket(ticket_20);
        pd.saveTicket(ticket_21);
        pd.saveTicket(ticket_22);
        pd.saveTicket(ticket_23);
        pd.saveTicket(ticket_24);
        pd.saveTicket(ticket_25);



        Ticket ticketFromDB=pd.getTicket(1);
        //pd.stampTicket(ticketFromDB);

    }
}
