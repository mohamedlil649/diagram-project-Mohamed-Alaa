package test;

import model.*;

import java.time.LocalDate;

public class MainTest {
    public static void main(String[] args) {


        MonthlyEmployee manager = new MonthlyEmployee(
                1,
                "Ahmed Hassan",
                Gender.MALE,
                LocalDate.of(2021, 1, 10),
                15000,
                21,
                0.10,
                true
        );

        HourlyEmployee hourlyEmployee = new HourlyEmployee(
                2,
                "Omar Ali",
                Gender.MALE,
                LocalDate.of(2024, 5, 15),
                150,
                45,
                225
        );

        CommissionEmployee commissionEmployee = new CommissionEmployee(
                3,
                "Mariam Mohamed",
                Gender.FEMALE,
                LocalDate.of(2023, 9, 1),
                10000,
                0.05,
                50000
        );

        MonthlyEmployee monthlyEmployee = new MonthlyEmployee(
                4,
                "Sara Adel",
                Gender.FEMALE,
                LocalDate.of(2022, 3, 20),
                12000,
                21,
                0.05,
                true
        );


        Department department = new Department(
                101,
                "Information Technology",
                manager
        );


        department.addEmployee(manager);
        department.addEmployee(hourlyEmployee);
        department.addEmployee(commissionEmployee);
        department.addEmployee(monthlyEmployee);

        System.out.println("========== EMPLOYEE MANAGEMENT SYSTEM ==========");
        System.out.println();


        System.out.println(department);
        System.out.println();


        department.printAllEmployees();
        System.out.println();


        System.out.println("Manager Salary: " + manager.calculateSalary());
        System.out.println("Hourly Employee Salary: " + hourlyEmployee.calculateSalary());
        System.out.println("Commission Employee Salary: " + commissionEmployee.calculateSalary());
        System.out.println("Monthly Employee Salary: " + monthlyEmployee.calculateSalary());
        System.out.println();


        System.out.println("Commission Employee Commission: "
                + commissionEmployee.calculateCommission());
        System.out.println();


        System.out.println("Manager Additional Vacation Days: "
                + manager.calculateAdditionalVacation());
        System.out.println();


        Employee found = department.findEmployee(3);
        System.out.println("Find Employee with ID 3:");
        System.out.println(found);
        System.out.println();


        System.out.println("Total Department Payroll: "
                + department.calculateTotalPayroll());
        System.out.println();

        // Remove employee
        department.removeEmployee(4);
        System.out.println("After removing employee with ID 4:");
        department.printAllEmployees();
        System.out.println();

        System.out.println("Total Payroll After Removal: "
                + department.calculateTotalPayroll());
    }
}
