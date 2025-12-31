package org.example.services;

import org.example.dao.BuildingDao;
import org.example.dao.CompanyDao;
import org.example.dao.EmployeeDao;
import org.example.entity.Building;
import org.example.entity.Company;
import org.example.entity.Employee;

import java.util.Comparator;
import java.util.List;

public class BuildingService {

    private final BuildingDao buildingDao = new BuildingDao();
    private final EmployeeDao employeeDao = new EmployeeDao();
    private final CompanyDao companyDao = new CompanyDao();


    public void createBuilding(String address, int floors, double area, long companyId) {

        Company company = companyDao.findById(companyId);
        if (company == null) {
            System.out.println("Company not found");
            return;
        }

        List<Employee> employees = employeeDao.findAll();

        Employee assigned = employees.stream()
                .min(Comparator.comparingInt(e ->
                        e.getBuildings() == null ? 0 : e.getBuildings().size()
                ))
                .orElse(null);

        Building b = new Building();
        b.setAddress(address);
        b.setFloors(floors);
        b.setTotalArea(area);
        b.setCompany(company);
        b.setEmployee(assigned);

        buildingDao.save(b);
        System.out.println("Building added.");
    }

    public List<Building> getAllBuildings() {
        return buildingDao.findAll();
    }
    public void deleteBuilding(long id) {
        Building b = buildingDao.findById(id);
        if (b == null) {
            System.out.println("Building not found");
            return;
        }
        buildingDao.delete(b);
        System.out.println("Building deleted");
    }
    public void sortByBuildingsCount() {
        List<Employee> employees = employeeDao.findAll();

        employees.sort((a, b) ->
                Long.compare(
                        buildingDao.countByEmployee(b),
                        buildingDao.countByEmployee(a)
                )
        );

        employees.forEach(e ->
                System.out.println(
                        e.getName() + " -> " +
                                buildingDao.countByEmployee(e)
                )
        );
    }
}
