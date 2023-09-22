/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author AreYouG
 */
public class TableManager {
    public static void createData(Long id, String firstname, String lastname, String email, String street, String city, String zipcode, String country){
        Customer cus = new Customer(id, firstname, lastname, email);
        Address adr = new Address(id, street, city, zipcode, country);
        adr.setCustomerFk(cus);
        cus.setAddressId(adr);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemoPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(adr);
            em.persist(cus);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static List<Customer> findAllCustomer(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemoPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Customer.findAll");
        List<Customer> list = (List<Customer>) query.getResultList();
        em.close();
        return list;
    }
    
    public static List<Address> findAddressByCity(String city){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemoPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Address.findByCity");
        query.setParameter("city", city);
        List<Address> list = (List<Address>) query.getResultList();
        em.close();
        return list;
    }

}
