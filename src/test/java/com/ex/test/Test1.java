package com.ex.test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {


    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", 101));
        employees.add(new Employee(2, "Jane Smith", 102));
        employees.add(new Employee(3, "Alice Johnson", 103));
        employees.add(new Employee(4, "Mike Brown", 101));

        List<Department> departments = new ArrayList<>();
        departments.add(new Department(101, "Human Resources"));
        departments.add(new Department(102, "Marketing"));
        departments.add(new Department(103, "Engineering"));

        // Calculate the cartesian product
        List<String> cartesianProduct = cartesianProduct(employees, departments);

        // Print the results
        for (String result : cartesianProduct) {
            System.out.println(result);
        }
    }


    public static List<String> cartesianProduct(List<Employee> employees, List<Department> departments) {
        List<String> results = new ArrayList<>();
        for (Employee emp : employees) {
            for (Department dept : departments) {
                String result = "EmployeeID: " + emp.getEmployeeId() +
                        ", EmployeeName: " + emp.getEmployeeName() +
                        ", EmployeeDeptID: " + emp.getDepartmentId() +
                        ", DepartmentID: " + dept.getDepartmentId() +
                        ", DepartmentName: " + dept.getDepartmentName();
                results.add(result);

            }
        }
        return results;
    }


}
