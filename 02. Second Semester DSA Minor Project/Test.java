package SOMNATH_SHAW_2241019426;

import java.util.*;

public class Test {

    // Creating an Employee Database for Getting Data's
    public static Employee[] employeeDatabase(int n , Scanner sc) {

        Employee[] employeeDatabase = new Employee[n];
        for (int i=0 ; i<n ; i++) {
            System.out.println();
            System.out.println("EMPLOYEE " + (i+1) + " --> ");

            // Enter Full Name
            sc.nextLine();
            System.out.print("Enter Your Full Name : ");
            String name = sc.nextLine();

            // Enter your Employee Id
            System.out.print("Enter Employee Id : ");
            int empId = sc.nextInt();

            // Enter your Salary
            System.out.print("Enter Salary : ");
            double salary = sc.nextDouble();

            // Enter your Hire Date
            System.out.print("Enter Hire Date : ");
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            Date hireDate = new Date(day, month, year);

            // Enter your Job Position
            System.out.print("Enter Job Position : ");
            String jobPosition = sc.next();

            // Enter your Contact Number
            System.out.print("Enter Contact Number : ");
            String contactNumber = sc.next();

            // Enter your Address
            System.out.print("Enter Address (Street, City, State, PinCode) : ");
            String Street = sc.next();
            String City = sc.next();
            String State = sc.next();
            int PinCode = sc.nextInt();
            Address address = new Address(Street, City, State, PinCode);

            employeeDatabase[i] = new Employee(name, empId, salary, hireDate, jobPosition, contactNumber, address);
        }

        return employeeDatabase;
    }

    // Method for arranging the employee details in decreasing order of their salary ...
    public static void arrangeEmployeeBySalary(Employee[] e) {
        for (int i=0 ; i<e.length ; i++) {
            for (int j=0 ; j<e.length ; j++) {
                if (e[j].getSalary() < e[i].getSalary()) {
                    Employee temp = e[i];
                    e[i] = e[j];
                    e[j] = temp;
                }
            }
        }
    }

    // Method to display Employee Details by Job Position ...
    public static void getEmployeesByJobPosition(Employee[] e, String jp) {
        for (Employee employee : e) {
            if (employee.getJobPosition().equals(jp)) {
                System.out.println("Employee Details --> ");
                System.out.println(employee.getEmployee());
            }
        }
    }

    // Method to display Employee Details by their StartHireDate and EndingHireDate ...
    public static void getEmployeesByHireDate(Employee[] e, Date d1, Date d2) {
        for (Employee employee : e) {
            if (employee.getHireDate().compareTo(d1.getDate()) >= 0 && employee.getHireDate().compareTo(d2.getDate()) <= 0) {
                System.out.println("Employee Details --> ");
                System.out.println(employee.getEmployee());
            }
        }
    }

    // Method to Count the Number of Foreign Employees Present ...
    public static int foreignEmployeeCount(Employee[] e) {
        int c = 0;
        for (Employee employee : e) {
            if (!(employee.getContactNumber().startsWith("+91"))) {
                c++;
            }
        }
        return c;
    }

    // Method to display Employee Details whose Salary is in between Salary S1 to Salary S2 ...
    public static void getEmployeesBySalary(Employee[] e, double s1, double s2) {
        for (Employee employee : e) {
            if (employee.getSalary() >= s1 && employee.getSalary() <= s2) {
                System.out.println("Employee Details --> ");
                System.out.println(employee.getEmployee());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of Employees : ");
        int n = sc.nextInt();
        System.out.println();

        // Employee Database Creation ...
        System.out.println("Employee Database --> ");
        Employee[] e = employeeDatabase(n , sc);


        System.out.println();
        System.out.println("Sorting the Employee Database According to Salary in Decreasing Order --> ");
        arrangeEmployeeBySalary(e);


        System.out.println();
        System.out.println("For Displaying the Detail of Employee (of the Entered Job Position ) --> ");
        System.out.print("Enter Job Position : ");
        String jp = sc.next();
        getEmployeesByJobPosition(e, jp);


        System.out.println();
        System.out.println("For Displaying the Detail of the Employee Between the Following Dates --> ");
        System.out.print("Enter Starting Hire Date : ");
        int d1 = sc.nextInt();
        int m1 = sc.nextInt();
        int y1 = sc.nextInt();
        Date date1 = new Date(d1, m1, y1);
        System.out.print("Enter Ending Hire Date : ");
        int d2 = sc.nextInt();
        int m2 = sc.nextInt();
        int y2 = sc.nextInt();
        Date date2 = new Date(d2, m2, y2);
        getEmployeesByHireDate(e, date1, date2);


        System.out.println();
        System.out.println("Display the Foreign Employees --> ");
        System.out.println("The Number of Foreign Employees are : " + foreignEmployeeCount(e));


        System.out.println();
        System.out.println("Displaying the Employee Detail between the range of the following Salary --> ");
        System.out.print("Enter the salary value of S1 : ");
        double s1 = sc.nextDouble();
        System.out.print("Enter the salary value of s2 : ");
        double s2 = sc.nextDouble();
        getEmployeesBySalary(e, s1, s2);
    }
}


/*
                                        <-------- OUTPUT -------->

Enter the Number of Employees : 5

Employee Database -->

EMPLOYEE 1 -->
Enter Your Full Name : Somnath Shaw
Enter Employee Id : 9426
Enter Salary : 98442
Enter Hire Date : 09 04 2026
Enter Job Position : Manager
Enter Contact Number : +917649303244
Enter Address (Street, City, State, PinCode) : baharagora jsr jharkhand 822384

EMPLOYEE 2 -->
Enter Your Full Name : Debasish Patra
Enter Employee Id : 6266
Enter Salary : 89443
Enter Hire Date : 02 04 2023
Enter Job Position : sde
Enter Contact Number : +345695834576
Enter Address (Street, City, State, PinCode) : dimna jsr jharkhand 743354

EMPLOYEE 3 -->
Enter Your Full Name : Sunirmal Shaw
Enter Employee Id : 9427
Enter Salary : 86443
Enter Hire Date : 04 05 2036
Enter Job Position : sde
Enter Contact Number : +8453745653
Enter Address (Street, City, State, PinCode) : kdiga bgora jhardhand 745733

EMPLOYEE 4 -->
Enter Your Full Name : Bhasu Das
Enter Employee Id : 4045
Enter Salary : 97343
Enter Hire Date : 04 12 2026
Enter Job Position : Manager
Enter Contact Number : +8698643214
Enter Address (Street, City, State, PinCode) : mango jsr jharhand 442375

EMPLOYEE 5 -->
Enter Your Full Name : Nabin Kr Shaw
Enter Employee Id : 9424
Enter Salary : 93421
Enter Hire Date : 02 05 2025
Enter Job Position : SeniorSDE
Enter Contact Number : +916245834833
Enter Address (Street, City, State, PinCode) : dongra msole jharkhand 845384

Sorting the Employee Database According to Salary in Decreasing Order -->

For Displaying the Detail of Employee (of the Entered Job Position ) -->
Enter Job Position : Manager
Employee Details -->
Name : Somnath Shaw
Employee Id : 9426
Salary : 98442.0
Hire Date : 9-4-2026
Job Position : Manager
Contact Number : +917649303244
Address : baharagora , jsr , jharkhand , 822384
Employee Details -->
Name : Bhasu Das
Employee Id : 4045
Salary : 97343.0
Hire Date : 4-12-2026
Job Position : Manager
Contact Number : +8698643214
Address : mango , jsr , jharhand , 442375

For Displaying the Detail of the Employee Between the Following Dates -->
Enter Starting Hire Date : 01 01 2020
Enter Ending Hire Date : 30 12 2027
Employee Details -->
Name : Nabin Kr Shaw
Employee Id : 9424
Salary : 93421.0
Hire Date : 2-5-2025
Job Position : SeniorSDE
Contact Number : +916245834833
Address : dongra , msole , jharkhand , 845384
Employee Details -->
Name : Debasish Patra
Employee Id : 6266
Salary : 89443.0
Hire Date : 2-4-2023
Job Position : sde
Contact Number : +345695834576
Address : dimna , jsr , jharkhand , 743354

Display the Foreign Employees -->
The Number of Foreign Employees are : 3

Displaying the Employee Detail between the range of the following Salary -->
Enter the salary value of S1 : 70000
Enter the salary value of s2 : 100000
Employee Details -->
Name : Somnath Shaw
Employee Id : 9426
Salary : 98442.0
Hire Date : 9-4-2026
Job Position : Manager
Contact Number : +917649303244
Address : baharagora , jsr , jharkhand , 822384
Employee Details -->
Name : Bhasu Das
Employee Id : 4045
Salary : 97343.0
Hire Date : 4-12-2026
Job Position : Manager
Contact Number : +8698643214
Address : mango , jsr , jharhand , 442375
Employee Details -->
Name : Nabin Kr Shaw
Employee Id : 9424
Salary : 93421.0
Hire Date : 2-5-2025
Job Position : SeniorSDE
Contact Number : +916245834833
Address : dongra , msole , jharkhand , 845384
Employee Details -->
Name : Debasish Patra
Employee Id : 6266
Salary : 89443.0
Hire Date : 2-4-2023
Job Position : sde
Contact Number : +345695834576
Address : dimna , jsr , jharkhand , 743354
Employee Details -->
Name : Sunirmal Shaw
Employee Id : 9427
Salary : 86443.0
Hire Date : 4-5-2036
Job Position : sde
Contact Number : +8453745653
Address : kdiga , bgora , jhardhand , 745733

*/
