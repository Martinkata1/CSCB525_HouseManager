package org.example.services;

import org.example.dao.ApartmentDao;
import org.example.dao.PetDao;
import org.example.entity.Apartment;
import org.example.entity.Pet;

public class PetService {

    private final PetDao petDao = new PetDao();
    private final ApartmentDao apartmentDao = new ApartmentDao();

    public void createPet(String type, long apartmentId) {
        Apartment apartment = apartmentDao.findById(apartmentId);

        if (apartment == null) {
            System.out.println("Apartment not found!");
            return;
        }

        Pet pet = new Pet();
        pet.setType(type);
        pet.setApartment(apartment);

        petDao.save(pet);
        System.out.println("Pet added.");
    }
}
