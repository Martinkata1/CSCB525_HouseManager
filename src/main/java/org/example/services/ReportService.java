package org.example.services;

import org.example.dao.*;
import org.example.entity.*;
import org.example.entity.Building;
import org.example.entity.Apartment;
import org.example.entity.Resident;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportService {

    private final EmployeeDao employeeDao = new EmployeeDao();
    private final BuildingDao buildingDao = new BuildingDao();
    private final ApartmentDao apartmentDao = new ApartmentDao();
    private final PaymentDao paymentDao = new PaymentDao();


    public void buildingsPerEmployee() {
        for (Employee e : employeeDao.findAll()) {
            System.out.println("Employee: " + e.getName());
            for (Building b : e.getBuildings()) {
                System.out.println("  - " + b.getAddress());
            }

        }
    }

    public void apartmentsInBuilding() {
        for (Building b : buildingDao.findAll()) {
            System.out.println("Building: " + b.getAddress());
            for (Apartment a : b.getApartments()) {
                System.out.println("  Apartment " + a.getNumber());
            }
        }
    }

    public void residentsInBuilding() {
        for (Building b : buildingDao.findAll()) {
            System.out.println("Building: " + b.getAddress());
            for (Apartment a : b.getApartments()) {
                for (Resident r : a.getResidents()) {
                    System.out.println("  " + r.getName());
                }
            }
        }
    }

    public void dueAmounts() {
        for (Apartment a : apartmentDao.findAll()) {
            double fee = a.getPayments().stream()
                    .mapToDouble(Payment::getAmount)
                    .sum();
            System.out.println("Apartment " + a.getNumber() + ": " + fee);
        }
    }

    public void paidAmounts() {
        for (Payment p : paymentDao.findAll()) {
            System.out.println(
                    p.getDate() + " | " +
                            p.getAmount() + " | " +
                            p.getCompany().getName()
            );
        }
    }
}
