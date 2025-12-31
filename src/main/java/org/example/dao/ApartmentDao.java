package org.example.dao;

import org.example.configuration.HibernateUtil;
import org.example.entity.Apartment;
import org.hibernate.Session;

import java.util.List;

public class ApartmentDao {

    public void save(Apartment apartment) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(apartment);
        s.getTransaction().commit();
        s.close();
    }

    public List<Apartment> findAll() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Apartment> result = s.createQuery("from Apartment", Apartment.class).list();
        s.close();
        return result;
    }

    public Apartment findById(Long id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Apartment a = s.get(Apartment.class, id);
        s.close();
        return a;
    }
}
