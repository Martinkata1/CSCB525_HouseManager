package org.example.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    @OneToMany(mappedBy = "company")
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
