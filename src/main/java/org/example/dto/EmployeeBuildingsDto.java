package org.example.dto;

public class EmployeeBuildingsDto {
    private String employeeName;
    private long buildingCount;

    public EmployeeBuildingsDto(String employeeName, long buildingCount) {
        this.employeeName = employeeName;
        this.buildingCount = buildingCount;
    }
}

