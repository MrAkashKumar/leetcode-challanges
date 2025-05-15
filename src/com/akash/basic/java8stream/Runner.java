package com.akash.basic.java8stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {

    static class Employee{
        private String name;
        private String department;
        private double salary;

        public Employee(){

        }

        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getDepartment() {
            return department;
        }
        public void setDepartment(String department) {
            this.department = department;
        }
        public double getSalary() {
            return salary;
        }
        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee [name=" + name + ", department=" + department + ", salary=" + salary + "]";
        }

        

    }

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(new Employee("Akash", "IT", 2000.0), 
        new Employee("Prakash", "MECH", 200.0), // Mech - list of employee object
        new Employee("Abhinav", "CSE", 4000.0),
        new Employee("Vicky", "CSE", 5000.0));

        findByDeptWiseEmployeeListSortedDescSal(employeeList);
    }

    private static void findByDeptWiseEmployeeListSortedDescSal(List<Employee> employeeList){

         Map<String, List<Employee>> employeeMap = employeeList.stream() 
            .collect(Collectors.groupingBy(Employee::getDepartment,
            Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .collect(Collectors.toList()))));

            employeeMap.forEach((dept, emps) -> {
                System.out.println(dept + ":");
                emps.forEach(e -> System.out.println("  " + e));
            });

            System.out.println(employeeMap);

    }
    
}
