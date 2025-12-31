package org.example.dao;

import org.example.configuration.HibernateUtil;
import org.example.entity.Company;
import org.example.entity.Payment;
import org.hibernate.Session;

import java.util.List;

public class PaymentDao {

    public void save(Payment payment) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(payment);
        s.getTransaction().commit();
        s.close();
    }

    public List<Payment> findAll() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Payment> list = s.createQuery("from Payment", Payment.class).list();
        s.close();
        return list;
    }
    public double sumByCompany(Company c) {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Double sum = s.createQuery(
                "select sum(p.amount) from Payment p where p.company = :c",
                Double.class
        ).setParameter("c", c).uniqueResult();

        s.close();
        return sum == null ? 0 : sum;
    }
}
