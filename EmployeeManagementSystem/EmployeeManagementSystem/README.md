 Employee Management System

Student Information

- Full Name: Mohamed Alaa Ahmed Sayed Mohamed
- Student ID: 2300309

 Project Description:

A Java implementation of the supplied UML class diagram for an employee management system. It demonstrates abstraction, inheritance, encapsulation, polymorphism, enums, and department/employee relationships.

Classes:

- `Employee`: abstract base class containing the shared employee fields and abstract `calculateSalary()` method.
- `CommissionEmployee`: salary = base salary + sales amount × commission rate.
- `MonthlyEmployee`: salary = monthly salary + monthly salary × bonus percentage; also calculates additional vacation days for fully completed years of service.
- `HourlyEmployee`: pays up to 40 hours at the regular hourly rate and hours above 40 at the overtime rate.
- `Department`: manages its manager and employee list, and supports adding, removing, finding, printing employees, and calculating total payroll.
- `Gender`: enum containing `MALE` and `FEMALE`.

The UML does not specify an insurance deduction amount, so `hasHealthInsurance` is stored as an employee attribute but does not change the salary formula. The overtime rate is treated as the total pay rate for each overtime hour.

 Project Structure :

```text
EmployeeManagementSystem/
├── src/
│   ├── Main.java
│   ├── model/
│   │   ├── Employee.java
│   │   ├── CommissionEmployee.java
│   │   ├── MonthlyEmployee.java
│   │   ├── HourlyEmployee.java
│   │   ├── Department.java
│   │   └── Gender.java
│   └── test/
│       └── MainTest.java
└── README.md
```
 How to Run :

Requirements: JDK 8 or later.

From the project root, compile the Java files:

```bash
javac -d out src/Main.java src/model/*.java src/test/*.java
```

Run the demo:

```bash
java -cp out Main
```

Alternatively, open the folder in a Java IDE and run `Main.java`. The demo creates sample employees and exercises salary calculation and department operations.