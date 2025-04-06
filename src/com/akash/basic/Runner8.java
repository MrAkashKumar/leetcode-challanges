package com.akash.basic;

import java.util.HashMap;
import java.util.Map;

public class Runner8 {
    

    public static void main(String[] args) {
        
        Map<Emp, String> map = new HashMap<>();
        map.put(new Emp(10), "X");
        map.put(new Emp(20), "Y");
        map.put(new Emp(10), "Z");
    }

    static class Emp {

        int id;
        Emp(int id) { this.id = id; }
    
        public int hashCode() {
            System.out.println("hashCode called");
            return id % 10;
        }
    
        public boolean equals(Object o) {
            System.out.println("equals called");
            return o instanceof Emp && ((Emp)o).id == this.id;
        }
    }




    
}
