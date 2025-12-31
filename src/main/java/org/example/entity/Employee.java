package org.example.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "employee")
    private List<Building> buildings;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}
