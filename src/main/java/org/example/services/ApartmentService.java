package org.example.services;

import org.example.dao.ApartmentDao;
import org.example.dao.BuildingDao;
import org.example.entity.Apartment;
import org.example.entity.Building;

public class ApartmentService {

    private final ApartmentDao apartmentDao = new ApartmentDao();
    private final BuildingDao buildingDao = new BuildingDao();

    public Apartment getById(long id) {
        return apartmentDao.findById(id);
    }

    public void createApartment(int number, double area, long buildingId) {
        Building building = buildingDao.findById(buildingId);

        if (building == null) {
            System.out.println("Building not found!");
            return;
        }

        Apartment apartment = new Apartment();
        apartment.setNumber(number);
        apartment.setArea(area);
        apartment.setBuilding(building);

        apartmentDao.save(apartment);
        System.out.println("Apartment added.");
    }
}
