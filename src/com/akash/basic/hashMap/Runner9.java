package com.akash.basic.hashMap;

import java.util.HashMap;

public class Runner9 {

    public static void main(String[] args) {
        
        HashMap<Person, String> map = new HashMap<>();
        map.put(new Person("Akash"), "Kumar");
        map.put(new Person("Akash"), "Kum");

        System.out.println(map.size());

    }

    static class Person {
        private final String name;
    
        Person(String name) {
            this.name = name;
        }
    
        public boolean equals(Object o) {
            System.out.println(" equal method ");
            return o instanceof Person && ((Person) o).name.equals(this.name);
        }
    }



    
}
