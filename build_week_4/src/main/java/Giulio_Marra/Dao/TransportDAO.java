package Giulio_Marra.Dao;

import Giulio_Marra.entities.Maintenance;
import Giulio_Marra.entities.Transport;
import Giulio_Marra.enums.Transport_type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class TransportDAO {
    private final EntityManager em;
    public TransportDAO(EntityManager em){
        this.em = em;
    }
    public Transport getTransport(long id){
        return em.find(Transport.class,id);
    }


    public List<Transport> getTransportsInMaintenance() {
        TypedQuery<Transport> query = em.createQuery("SELECT m.transport FROM Maintenance m WHERE m.ending_date >= CURRENT_DATE", Transport.class);
        return query.getResultList();
    }

    public void saveTrans(Transport transport) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(transport);
        transaction.commit();
        System.out.println("L'utente " + transport.getTransport_type() + " è stato aggiunto correttamente al database");
    }
    public void saveMaintenence(Maintenance maintenence) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(maintenence);
        transaction.commit();
        System.out.println("Il mezzo " + maintenence.getTransport() + " è in manutenzione al database");
    }
    public void getDateOfMaintenance(long id) {
        TypedQuery<Object[]> query = em.createQuery(
                "SELECT " +
                        "t.id, " +
                        "t.name, " +
                        "t.transport_type, " +
                        "t.state, " +
                        "m.starting_date, " +
                        "m.ending_date " +
                        "FROM Transport t " +
                        "LEFT JOIN t.maintenance_list m " +
                        "WHERE t.id =:id " +
                        "ORDER BY t.id, m.starting_date",
                Object[].class);
        query.setParameter("id", id);
        List<Object[]> results = query.getResultList();

        for (Object[] result : results) {
            Long transportId = (Long) result[0];
            String transportName = (String) result[1];
            Transport_type transportType = (Transport_type) result[2];
            Boolean currentState = (Boolean) result[3];
            LocalDate maintenanceStartDate = (LocalDate) result[4];
            LocalDate maintenanceEndDate = (LocalDate) result[5];

            System.out.println("Transport ID: " + transportId);
            System.out.println("Transport Name: " + transportName);
            System.out.println("Transport Type: " + transportType);
            System.out.println("Current State: " + currentState);
            if (maintenanceStartDate != null && maintenanceEndDate != null) {
                System.out.println("Maintenance Start Date: " + maintenanceStartDate);
                System.out.println("Maintenance End Date: " + maintenanceEndDate);
            } else {
                System.out.println("No Maintenance");
            }
            System.out.println("---------------------------------------------------");
        }
    }
}
