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
        TicketDao td= new TicketDao(em);


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
        em.getTransaction().begin();
        em.persist(distributor);
        em.persist(authorized_seller);
        em.getTransaction().commit();
        pd.saveSeller(distributor);
        pd.saveSeller(authorized_seller);

        //Rotta creata:
        Route route_1= new Route("Napoli","Roma",2.50);
        //Salvataggio Rotta
        //pd.saveRoute(route_1);

        //Mezzo di trasporto con rotta:
        Route routeCollegata=pd.getRoute(1);
        Transport transport_1=new Transport(transport_type.AUTOBUS,false,"Tomas",routeCollegata);
       // pd.saveTrans(transport_1);



        Person person_1= pd.getPerson(1);
        Card Card_2=pd.getCard(1);
        Seller seller_1=pd.getSeller(1);
       Card card_1=new Card(LocalDate.now().plusYears(1),LocalDate.now(),person_1);
       //pd.saveCard(card_1);
       Subscription subscription_1=new Subscription(periodicity.MONTHLY,LocalDate.now(),Card_2,seller_1);
       //pd.saveSubscription(subscription_1);

        Transport transport1=pd.getTransport(1);
        Ticket ticket_1=new Ticket(false,seller_1,person_1,transport1);
        pd.saveTicket(ticket_1);
    }
}
