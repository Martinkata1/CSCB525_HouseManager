package org.example.services;

import org.example.dao.BuildingDao;
import org.example.dao.CompanyDao;
import org.example.dao.EmployeeDao;
import org.example.entity.Company;
import org.example.entity.Employee;

import java.util.List;

public class EmployeeService {

    private final EmployeeDao employeeDao = new EmployeeDao();
    private final BuildingDao buildingDao = new BuildingDao();
    private final CompanyDao companyDao = new CompanyDao();



    public void createEmployee(String name, long companyId) {
        Company company = companyDao.findById(companyId);

        if (company == null) {
            System.out.println("Company not found");
            return;
        }

        Employee e = new Employee();
        e.setName(name);
        e.setCompany(company);

        employeeDao.save(e);
        System.out.println("Employee added.");
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }
    public void fireEmployee(long id) {
        Employee e = employeeDao.findById(id);
        if (e == null) {
            System.out.println("Employee not found");
            return;
        }
        employeeDao.delete(e);
        System.out.println("Employee fired");
    }


    public void sortByName() {
        employeeDao.findAll().stream()
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(e ->
                        System.out.println(e.getId() + " | " + e.getName())
                );
    }


    public Employee getEmployeeById(Long id) {
        return employeeDao.findById(id);
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
                        e.getName() + " | buildings: " +
                                buildingDao.countByEmployee(e)
                )
        );
    }
}
