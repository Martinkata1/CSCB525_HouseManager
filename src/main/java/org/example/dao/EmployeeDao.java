package org.example.dao;

import org.example.configuration.HibernateUtil;
import org.example.entity.Employee;
import org.hibernate.Session;

import java.util.List;

public class EmployeeDao {

    public void save(Employee employee) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(employee);
        s.getTransaction().commit();
        s.close();
    }

    public List<Employee> findAll() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Employee> result = s.createQuery("from Employee", Employee.class).list();
        s.close();
        return result;
    }

    public Employee findById(Long id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Employee e = s.get(Employee.class, id);
        s.close();
        return e;
    }

    public void delete(Employee employee) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(employee);
        s.getTransaction().commit();
        s.close();
    }
}
