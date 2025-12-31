package org.example.dao;

import org.example.configuration.HibernateUtil;
import org.example.entity.Building;
import org.example.entity.Employee;
import org.hibernate.Session;

import java.util.List;

public class BuildingDao {

    public void save(Building building) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(building);
        s.getTransaction().commit();
        s.close();
    }
    public long countByEmployee(Employee e) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        long count = s.createQuery(
                "select count(b) from Building b where b.employee = :e",
                Long.class
        ).setParameter("e", e).getSingleResult();
        s.close();
        return count;
    }
    public void delete(Building b) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.remove(b);
        s.getTransaction().commit();
        s.close();
    }

    public List<Building> findAll() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Building> result = s.createQuery("from Building", Building.class).list();
        s.close();
        return result;
    }

    public Building findById(Long id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Building b = s.get(Building.class, id);
        s.close();
        return b;
    }
}
