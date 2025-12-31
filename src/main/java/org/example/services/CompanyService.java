package org.example.services;

import org.example.dao.CompanyDao;
import org.example.dao.PaymentDao;
import org.example.entity.Company;

import java.util.List;

public class CompanyService {

    private final CompanyDao companyDao = new CompanyDao();
    private final PaymentDao paymentDao = new PaymentDao();


    public void createCompany(String name, String address) {
        Company c = new Company();
        c.setName(name);
        c.setAddress(address);
        companyDao.save(c);
    }
    public void listCompanies() {
        companyDao.findAll().forEach(c ->
                System.out.println(c.getId() + " | " + c.getName() + " | " + c.getAddress())
        );
    }

    public List<Company> getAllCompanies() {
        return companyDao.findAll();
    }

    public void deleteCompany(Long id) {
        Company c = companyDao.findById(id);
        if (c != null) {
            companyDao.delete(c);
        }
    }
    private double getIncome(Company c) {
        return paymentDao.sumByCompany(c);
    }

    public void listByIncome() {
        List<Company> companies = companyDao.findAll();

        companies.sort((a, b) ->
                Double.compare(getIncome(b), getIncome(a))
        );

        companies.forEach(c ->
                System.out.println(c.getName() + " -> " + getIncome(c))
        );
    }
}
