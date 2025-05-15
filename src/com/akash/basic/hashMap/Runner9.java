package com.akash.basic.hashMap;

import java.util.HashMap;

public class Runner9 {

    public static void main(String[] args) {
        
        HashMap<Person, String> map = new HashMap<>();
        map.put(new Person("Akash"), "Kumar");
        map.put(new Person("Akash"), "Kum");
         map.put(new Person("Ravi"), "Kum");

        System.out.println("-----------------");
        System.out.println(map.size()); // 2
        System.out.println(map.get(new Person("Akash"))); //null

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
