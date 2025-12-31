package org.example.services;

import org.example.dao.PaymentDao;
import org.example.entity.*;
import org.example.utils.FileUtil;

import java.time.LocalDate;

public class PaymentService {

    private PaymentDao paymentDao = new PaymentDao();

    private final ApartmentService apartmentService = new ApartmentService();
    private final FeeService feeService = new FeeService();

    public void payAndSave(long apartmentId) {

        Apartment a = apartmentService.getById(apartmentId);

        if (a == null) {
            System.out.println("Apartment not found");
            return;
        }

        double amount = feeService.calculateFee(apartmentId);

        Payment p = new Payment();
        p.setCompany(a.getBuilding().getCompany());
        p.setEmployee(a.getBuilding().getEmployee());
        p.setBuilding(a.getBuilding());
        p.setApartment(a);
        p.setAmount(amount);
        p.setDate(LocalDate.now());

        paymentDao.save(p);
        FileUtil.save(p);

        System.out.println("Payment saved.");
    }
    public double calculateFee(Apartment a) {

        double fee = 0;

        fee += a.getArea() * 1.0;

        for (Resident r : a.getResidents()) {
            if (r.getAge() > 7 && r.isUsesElevator()) {
                fee += 10;
            }
        }

        for (Pet p : a.getPets()) {
            fee += 5;
        }

        return fee;
    }
    private double getIncome(Company company) {
        return paymentDao.findAll().stream()
                .filter(p -> p.getCompany().getId() == company.getId())
                .mapToDouble(Payment::getAmount)
                .sum();
    }
}
