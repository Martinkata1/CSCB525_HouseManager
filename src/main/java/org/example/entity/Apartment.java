package org.example.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "apartments")
public class Apartment {
    @Id @GeneratedValue
    private Long id;

    private int number;
    private double area;

    @ManyToOne
    private Building building;

    @OneToMany(mappedBy = "apartment")
    private List<Resident> residents;

    @OneToMany(mappedBy = "apartment")
    private List<Pet> pets;
    @OneToMany(mappedBy = "apartment")
    private List<Payment> payments;

    public Long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public List<Resident> getResidents() {
        return residents;
    }

    public List<Pet> getPets() {
        return pets;
    }
    public List<Payment> getPayments() {
        return payments;
    }

}
