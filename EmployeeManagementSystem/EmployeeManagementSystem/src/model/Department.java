package model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private int id;
    private String name;
    private Employee manager;
    private List<Employee> employees;

    public Department(int id, String name, Employee manager, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.employees = employees != null ? employees : new ArrayList<>();
    }

    public Department(int id, String name, Employee manager) {
        this(id, name, manager, new ArrayList<>());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        // Detach employees currently assigned to this department.
        for (Employee employee : this.employees) {
            if (employee != null && employee.getDepartment() == this) {
                employee.setDepartment(null);
            }
        }

        this.employees = new ArrayList<>();
        if (employees != null) {
            for (Employee employee : employees) {
                addEmployee(employee);
            }
        }
    }

    public void addEmployee(Employee employee) {
        if (employee == null) {
            return;
        }
        Employee existing = findEmployee(employee.getId());
        if (existing != null) {
            return;
        }

        // Keep the employee's department reference and department lists consistent.
        Department previousDepartment = employee.getDepartment();
        if (previousDepartment != null && previousDepartment != this) {
            previousDepartment.removeEmployee(employee.getId());
        }

        employees.add(employee);
        employee.setDepartment(this);
    }

    public void removeEmployee(int employeeId) {
        Employee employee = findEmployee(employeeId);
        if (employee != null) {
            employees.remove(employee);
            if (employee.getDepartment() == this) {
                employee.setDepartment(null);
            }
        }
    }

    public Employee findEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    public double calculateTotalPayroll() {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.calculateSalary();
        }
        return total;
    }

    public void printAllEmployees() {
        System.out.println("Employees in " + name + " Department:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager=" + (manager != null ? manager.getName() : "None") +
                ", employeesCount=" + employees.size() +
                '}';
    }
}
