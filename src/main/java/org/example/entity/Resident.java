package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "residents")
public class Resident {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private int age;
    private boolean usesElevator;

    @ManyToOne
    private Apartment apartment;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isUsesElevator() {
        return usesElevator;
    }

    public void setUsesElevator(boolean usesElevator) {
        this.usesElevator = usesElevator;
    }

    public String getName() {
        return name;
    }

    public Apartment getApartment() {
        return apartment;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

}
