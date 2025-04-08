package com.akash.basic.hashMap;

import java.util.HashMap;
import java.util.Map;

import com.akash.basic.hashMap.Runner1.MockApp;

public class Runner2{

    static class Employee {
        String name;
        Employee(String name) {
            this.name = name;
        }
    
        public int hashCode() {
            System.out.println("Hascode");
            return 42;
        }
    }

    public static void main(String[] args) {
        Map<Employee, String> map = new HashMap<>();
        Employee e1 = new Employee("Amit");
        Employee e2 = new Employee("Amit");

        map.put(e1, "Developer");
        map.put(e2, "Manager"); // store 

        System.out.println(map.get(e1)); //Developer
        System.out.println(map.get(e2)); // manager
        System.out.println(map.size());
    }
    
}


