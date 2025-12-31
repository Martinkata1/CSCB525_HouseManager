package org.example.services;

import org.example.dao.ApartmentDao;
import org.example.entity.Apartment;
import org.example.entity.Resident;

public class FeeService {
    private final ApartmentDao apartmentDao = new ApartmentDao();


    public double calculateFee(long apartmentId) {
        Apartment a = apartmentDao.findById(apartmentId);

        if (a == null) {
            System.out.println("Apartment not found");
            return 0;
        }

        double fee = 0;

        fee += a.getArea() * 1.5;


        for (Resident r : a.getResidents()) {
            if (r.getAge() > 7 && r.isUsesElevator()) {
                fee += 10;
            }
        }

        fee += a.getPets().size() * 5;

        System.out.println("Monthly fee: " + fee);
        return fee;
    }
}
