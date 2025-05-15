package com.akash.basic.hashMap;

import java.util.HashMap;
import java.util.Map;

public class Runner4{

    static class TestKey {
        int id;
        TestKey(int id) { this.id = id; }
    
        public boolean equals(Object o) {
            System.out.println("equals method");
            return true;
        }
    
        public int hashCode() {
            System.out.println("has code method");
             int value = id % 5; // 10 % 5 = 
             System.out.println(value);
             return value;

        }
    }
    
    public static void main(String[] args) {
        TestKey k1 = new TestKey(10);
        TestKey k2 = new TestKey(15);
        TestKey k3 = new TestKey(25);

        Map<TestKey, String> map = new HashMap<>();
        map.put(k3, "ABC");
        map.put(k1, "GFJ");
        map.put(k2, "CDF");
        
        System.out.println(map.size());
        
        System.out.println(map.get(k1)); // CDF
        System.out.println(map.get(k2)); // some valuee
        System.out.println(map.get(k3)); // CDF
    }
    
}


