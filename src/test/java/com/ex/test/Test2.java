package com.ex.test;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
//    public static void main(String[] args) throws Exception {
//        String s1 = "1234";
//        String s2 = "1234";
//        System.out.println(s1 == s2);
//
//        BasicDataSourceFactory factory = new BasicDataSourceFactory();
//
//        Properties prop = new Properties();
//        prop.setProperty("driverClassName", "com.mysql.jdbc.Driver");
//
//        DataSource dataSource = factory.createDataSource(prop);
//    }


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

        // Calculate the nested loop join
//        long start = System.currentTimeMillis();
        long start = System.nanoTime();
        List<String> nestedLoopJoin = nestedLoopJoin(employees, departments);
//        long end = System.currentTimeMillis();
        long end = System.nanoTime();
        System.out.println("end - start :" + (end - start));
        // Print the results
        for (String result : nestedLoopJoin) {
            System.out.println(result);
        }
    }


    public static List<String> nestedLoopJoin(List<Employee> employees, List<Department> departments) {
        List<String> results = new ArrayList<>();
        for (Employee emp : employees) {
            for (Department dept : departments) {
                if (emp.getDepartmentId() == dept.getDepartmentId()) {
                    String result = "EmployeeID: " + emp.getEmployeeId() +
                            ", EmployeeName: " + emp.getEmployeeName() +
                            ", EmployeeDeptID: " + emp.getDepartmentId() +
                            ", DepartmentID: " + dept.getDepartmentId() +
                            ", DepartmentName: " + dept.getDepartmentName();
                    results.add(result);
                }
            }
        }
        return results;
    }

}
