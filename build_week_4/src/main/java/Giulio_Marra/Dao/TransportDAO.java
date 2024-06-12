package Giulio_Marra.Dao;

import Giulio_Marra.entities.Maintenance;
import Giulio_Marra.entities.Transport;
import Giulio_Marra.entities.transport_type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class TransportDAO {
    private final EntityManager em;
    public TransportDAO(EntityManager em) {
        this.em = em;
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
                        "WHERE t.id =:id " +  // Utilizzo della relazione definita nella classe Transport
                        "ORDER BY t.id, m.starting_date",
                Object[].class);
        query.setParameter("id", id);
        List<Object[]> results = query.getResultList();

        for (Object[] result : results) {
            Long transportId = (Long) result[0];
            String transportName = (String) result[1];
            transport_type transportType = (transport_type) result[2]; // Cast to enum type
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