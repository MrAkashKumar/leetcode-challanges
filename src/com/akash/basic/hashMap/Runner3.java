package com.akash.basic.hashMap;

import java.util.HashMap;
import java.util.Map;

import com.akash.basic.hashMap.Runner1.MockApp;

public class Runner3{

    static class MyKey {
        int value;
        MyKey(int value) { this.value = value; }
    
        public boolean equals(Object o) {
            return true;
        }
    
        public int hashCode() {
            return 0;
        }
    }

    public static void main(String[] args) {
        Map<MyKey, String> map = new HashMap<>();
        map.put(new MyKey(1), "One");
        map.put(new MyKey(2), "Two");
        System.out.println(map.size()); // 1
    }
    
}


