package com.akash.basic.hashMap;

import java.util.HashMap;
import java.util.Map;

public class Runner2{

    static class Employee {
        String name;
        Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        /*
         * @Override
        public boolean equals(Object obj) {
            return true;
        }
        */
        @Override
        public int hashCode() {
            System.out.println("Hascode");
            return 42;
        }
    }

    public static void main(String[] args) {
        Map<Employee, String> map = new HashMap<>();
        Employee e1 = new Employee("Amit");
        Employee e2 = new Employee("Amit");
        System.out.println("--------------------");

        map.put(e1, "Developer");
        map.put(e2, "Manager"); // store 

        System.out.println("System equal method invoked");
        System.out.println(map.get(e1)); //Developer
        System.out.println(map.get(e2)); // manager
        System.out.println(map.size()); // 2
    }
    
}


