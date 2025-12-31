package org.example.services;

import org.example.dao.ApartmentDao;
import org.example.dao.ResidentDao;
import org.example.entity.Apartment;
import org.example.entity.Resident;

import java.util.Comparator;

public class ResidentService {

    private final ResidentDao residentDao = new ResidentDao();
    private final ApartmentDao apartmentDao = new ApartmentDao();

    public void createResident(String name, int age, boolean usesElevator, long apartmentId) {
        Apartment apartment = apartmentDao.findById(apartmentId);

        if (apartment == null) {
            System.out.println("Apartment not found!");
            return;
        }

        Resident r = new Resident();
        r.setName(name);
        r.setAge(age);
        r.setUsesElevator(usesElevator);
        r.setApartment(apartment);

        residentDao.save(r);
        System.out.println("Resident added.");
    }

    public void sortByAge() {
        residentDao.findAll().stream()
                .sorted(Comparator.comparingInt(Resident::getAge))
                .forEach(r ->
                        System.out.println(r.getName() + " | " + r.getAge())
                );
    }
}
