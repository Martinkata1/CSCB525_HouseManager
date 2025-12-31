package org.example;

import org.example.entity.Company;
import org.example.services.*;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
//    }
//}

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static final CompanyService companyService = new CompanyService();
    private static final EmployeeService employeeService = new EmployeeService();
    private static final BuildingService buildingService = new BuildingService();
    private static final ApartmentService apartmentService = new ApartmentService();
    private static final ResidentService residentService = new ResidentService();
    private static final PetService petService = new PetService();
    private static final FeeService feeService = new FeeService();
    private static final PaymentService paymentService = new PaymentService();
    private static final ReportService reportService = new ReportService();


    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== ELECTRONIC HOUSE MANAGER ===");
            System.out.println("1. Companies");
            System.out.println("2. Employees");
            System.out.println("3. Buildings");
            System.out.println("4. Apartments AND Residents");
            System.out.println("5. Fees AND Payments");
            System.out.println("6. Reports");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> companiesMenu();
                case 2 -> employeesMenu();
                case 3 -> buildingsMenu();
                case 4 -> apartmentsMenu();
                case 5 -> feesMenu();
                case 6 -> reportsMenu();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
    private static void companiesMenu() {
        System.out.println("\n--- COMPANIES ---");
        System.out.println("1. Add company");
        System.out.println("2. List companies");
        System.out.println("3. Delete company");
        System.out.println("4. Sort companies by income");
        System.out.println("0. Back");

        int c = sc.nextInt(); sc.nextLine();

        switch (c) {
            case 1 -> {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Address: ");
                String address = sc.nextLine();
                companyService.createCompany(name, address);
            }
            case 2 -> companyService.listCompanies();
            case 3 -> {
                System.out.print("Company ID: ");
                companyService.deleteCompany(sc.nextLong());
            }
            case 4 -> companyService.listByIncome();
        }
    }

    private static void employeesMenu() {
        System.out.println("\n--- EMPLOYEES ---");
        System.out.println("1. Add employee");
        System.out.println("2. Fire employee");
        System.out.println("3. Sort by name");
        System.out.println("4. Sort by buildings count");
        System.out.println("0. Back");

        int c = sc.nextInt(); sc.nextLine();

        switch (c) {
            case 1 -> {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Company ID: ");
                employeeService.createEmployee(name, sc.nextLong());
            }
            case 2 -> {
                System.out.print("Employee ID: ");
                employeeService.fireEmployee(sc.nextLong());
            }
            case 3 -> employeeService.sortByName();
            case 4 -> employeeService.sortByBuildingsCount();
        }
    }

    private static void buildingsMenu() {
        System.out.println("\n--- BUILDINGS ---");
        System.out.println("1. Add building");
        System.out.println("2. Delete building");
        System.out.println("0. Back");

        int c = sc.nextInt(); sc.nextLine();

        switch (c) {
            case 1 -> {
                System.out.print("Address: ");
                String address = sc.nextLine();
                System.out.print("Floors: ");
                int floors = sc.nextInt();
                System.out.print("Total area: ");
                double area = sc.nextDouble();
                System.out.print("Company ID: ");
                long companyId = sc.nextLong();

                buildingService.createBuilding(address, floors, area, companyId);
            }
            case 2 -> {
                System.out.print("Building ID: ");
                buildingService.deleteBuilding(sc.nextLong());
            }
        }
    }


    private static void apartmentsMenu() {
        System.out.println("\n--- APARTMENTS AND RESIDENTS ---");
        System.out.println("1. Add apartment");
        System.out.println("2. Add resident");
        System.out.println("3. Add pet");
        System.out.println("4. List residents by age");
        System.out.println("0. Back");

        int c = sc.nextInt(); sc.nextLine();

        switch (c) {
            case 1 -> {
                System.out.print("Apartment number: ");
                int num = sc.nextInt();
                System.out.print("Area: ");
                double area = sc.nextDouble();
                System.out.print("Building ID: ");
                apartmentService.createApartment(num, area, sc.nextLong());
            }
            case 2 -> {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Age: ");
                int age = sc.nextInt();
                System.out.print("Uses elevator (true/false): ");
                boolean elevator = sc.nextBoolean();
                System.out.print("Apartment ID: ");
                residentService.createResident(name, age, elevator, sc.nextLong());
            }
            case 3 -> {
                System.out.print("Pet type: ");
                String type = sc.nextLine();
                System.out.print("Apartment ID: ");
                petService.createPet(type, sc.nextLong());
            }
            case 4 -> residentService.sortByAge();
        }
    }


    private static void feesMenu() {
        System.out.println("\n--- FEES AND PAYMENTS ---");
        System.out.println("1. Calculate apartment fee");
        System.out.println("2. Pay fee");
        System.out.println("0. Back");

        int c = sc.nextInt(); sc.nextLine();

        switch (c) {
            case 1 -> {
                System.out.print("Apartment ID: ");
                
                feeService.calculateFee(sc.nextLong());
            }
            case 2 -> {
                System.out.print("Apartment ID: ");
                paymentService.payAndSave(sc.nextLong());
            }
        }
    }

    private static void reportsMenu() {
        System.out.println("\n--- REPORTS ---");
        System.out.println("1. Buildings per employee");
        System.out.println("2. Apartments in building");
        System.out.println("3. Residents in building");
        System.out.println("4. Due amounts");
        System.out.println("5. Paid amounts");
        System.out.println("0. Back");

        int c = sc.nextInt(); sc.nextLine();

        switch (c) {
            case 1 -> reportService.buildingsPerEmployee();
            case 2 -> reportService.apartmentsInBuilding();
            case 3 -> reportService.residentsInBuilding();
            case 4 -> reportService.dueAmounts();
            case 5 -> reportService.paidAmounts();
        }
    }
}