package Giulio_Marra.Dao;

import Giulio_Marra.entities.Seller;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class SellerDAO {
    private final EntityManager em;

    public SellerDAO(EntityManager em) {
        this.em = em;
    }

    public Seller getSeller(long id) {
        return em.find(Seller.class, id);
    }

    public void saveSeller(Seller seller) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(seller);
        transaction.commit();
        System.out.println("Il venditore: " + seller.getName() + " è stato aggiunto al database");
    }
}
