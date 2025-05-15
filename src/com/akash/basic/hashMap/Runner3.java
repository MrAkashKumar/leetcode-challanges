package com.akash.basic.hashMap;

import java.util.HashMap;
import java.util.Map;

public class Runner3{

    static class MyKey {
        int value;
        MyKey(int value) { this.value = value; }
    
        public boolean equals(Object o) {
            System.out.println("Equal method");
            return true;
        }
    
        public int hashCode() {
            System.out.println("hasCode method");
            return 0;
        }
    }

    public static void main(String[] args) {
        Map<MyKey, String> map = new HashMap<>();
        System.out.println("----------------");
        map.put(new MyKey(1), "One");
        map.put(new MyKey(2), "Two"); //Two
        System.out.println(map.size()); // 1
        System.out.println(map.get(new MyKey(1)));
        System.out.println(map.get(new MyKey(2)));
    }
    
}


