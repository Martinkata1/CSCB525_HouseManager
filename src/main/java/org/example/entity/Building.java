package org.example.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "buildings")
public class Building {
    @Id @GeneratedValue
    private Long id;

    private String address;
    private int floors;
    private double totalArea;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Employee employee;

    @OneToMany(mappedBy = "building")
    private List<Apartment> apartments;

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }
}

