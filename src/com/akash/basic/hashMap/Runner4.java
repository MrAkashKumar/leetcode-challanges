package com.akash.basic.hashMap;

import java.util.HashMap;
import java.util.Map;

import com.akash.basic.hashMap.Runner1.MockApp;

public class Runner4{

    static class TestKey {
        int id;
        TestKey(int id) { this.id = id; }
    
        public boolean equals(Object o) {
            return true;
        }
    
        public int hashCode() {
            return id % 5;
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
    }
    
}


