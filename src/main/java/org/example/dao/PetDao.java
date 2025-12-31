package org.example.dao;

import org.example.configuration.HibernateUtil;
import org.example.entity.Pet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PetDao {

    public void save(Pet pet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(pet);

        tx.commit();
        session.close();
    }

    public Pet findById(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Pet pet = session.get(Pet.class, id);
        session.close();
        return pet;
    }

    public List<Pet> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Pet> list =
                session.createQuery("from Pet", Pet.class).list();
        session.close();
        return list;
    }

    public void delete(Pet pet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.remove(pet);

        tx.commit();
        session.close();
    }
}
