package com.ex.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test3 {
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

        // Sort both lists by departmentId
        employees.sort(Comparator.comparingInt(Employee::getDepartmentId));
        departments.sort(Comparator.comparingInt(Department::getDepartmentId));

        // Calculate the sort-merge join
//        long start = System.currentTimeMillis();
        long start = System.nanoTime();
        List<String> sortMergeJoin = sortMergeJoin(employees, departments);
//        long end = System.currentTimeMillis();
        long end = System.nanoTime();
        System.out.println("end - start :" + (end - start));

        // Print the results
        for (String result : sortMergeJoin) {
            System.out.println(result);
        }
    }

    public static List<String> sortMergeJoin(List<Employee> employees, List<Department> departments) {
        List<String> results = new ArrayList<>();
        int i = 0, j = 0;

        while (i < employees.size() && j < departments.size()) {
            Employee emp = employees.get(i);
            Department dept = departments.get(j);

            if (emp.getDepartmentId() < dept.getDepartmentId()) {
                i++;
            } else if (emp.getDepartmentId() > dept.getDepartmentId()) {
                j++;
            } else {
                // Match found, add all matching department rows for this employee row
                while (j < departments.size() && emp.getDepartmentId() == departments.get(j).getDepartmentId()) {
                    String result = "EmployeeID: " + emp.getEmployeeId() +
                            ", EmployeeName: " + emp.getEmployeeName() +
                            ", EmployeeDeptID: " + emp.getDepartmentId() +
                            ", DepartmentID: " + departments.get(j).getDepartmentId() +
                            ", DepartmentName: " + departments.get(j).getDepartmentName();
                    results.add(result);
                    j++;
                }
                // Reset j to last matching position for next employee
                if (j > 0 && departments.get(j - 1).getDepartmentId() == emp.getDepartmentId()) {
                    j--;
                }
                i++;
            }
        }
        return results;
    }


}
