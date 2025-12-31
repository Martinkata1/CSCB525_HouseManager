package org.example.dao;

import org.example.configuration.HibernateUtil;
import org.example.entity.Resident;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ResidentDao {

    public void save(Resident resident) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(resident);

        tx.commit();
        session.close();
    }

    public Resident findById(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Resident resident = session.get(Resident.class, id);
        session.close();
        return resident;
    }

    public List<Resident> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Resident> list =
                session.createQuery("from Resident", Resident.class).list();
        session.close();
        return list;
    }

    public void delete(Resident resident) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.remove(resident);

        tx.commit();
        session.close();
    }
}
