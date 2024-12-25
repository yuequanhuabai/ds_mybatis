package com.ex.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test4 {

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

        // Calculate the hash join
        long start = System.nanoTime();
        List<String> hashJoinResults = hashJoin(employees, departments);
        long end = System.nanoTime();
        System.out.println("end - start :" + (end - start));
        // Print the results
        for (String result : hashJoinResults) {
            System.out.println(result);
        }
    }

    public static List<String> hashJoin(List<Employee> employees, List<Department> departments) {
        List<String> results = new ArrayList<>();
        Map<Integer, String> departmentMap = new HashMap<>();

        // Create a hash table for departments
        for (Department dept : departments) {
            departmentMap.put(dept.getDepartmentId(), dept.getDepartmentName());
        }

        // Iterate over employees and join with department data from the hash table
        for (Employee emp : employees) {
            String deptName = departmentMap.get(emp.getDepartmentId());
            if (deptName != null) {  // there is a matching department
                String result = "EmployeeID: " + emp.getEmployeeId() +
                        ", EmployeeName: " + emp.getEmployeeName() +
                        ", EmployeeDeptID: " + emp.getDepartmentId() +
                        ", DepartmentID: " + emp.getDepartmentId() +
                        ", DepartmentName: " + deptName;
                results.add(result);
            }
        }
        return results;
    }

}
