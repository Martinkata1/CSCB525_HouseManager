package org.example.dao;

import org.example.configuration.HibernateUtil;
import org.example.entity.Company;
import org.hibernate.Session;

import java.util.List;

public class CompanyDao {

    public void save(Company company) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(company);
        s.getTransaction().commit();
        s.close();
    }

    public List<Company> findAll() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Company> result = s.createQuery("from Company", Company.class).list();
        s.close();
        return result;
    }

    public Company findById(Long id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Company c = s.get(Company.class, id);
        s.close();
        return c;
    }

    public void delete(Company company) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(company);
        s.getTransaction().commit();
        s.close();
    }
}
