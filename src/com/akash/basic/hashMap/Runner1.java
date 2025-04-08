package com.akash.basic.hashMap;

import java.util.HashMap;
import java.util.Map;

public class Runner1{

    static class MockApp {

    int x, y;

    MockApp(int x, int y) {
         this.x = x; 
         this.y = y; 
    }

    public boolean equals(Object o) {
        if (this == o) 
        return true;
        if (o instanceof MockApp) {
            MockApp p = (MockApp) o;
            return this.x == p.x && this.y == p.y;
        }
        return false;
    }

    public int hashCode() {
        return 1;
    }
}

    public static void main(String[] args) {
        Map<MockApp, String> map = new HashMap<>();
        map.put(new MockApp(1, 2), "A");
        map.put(new MockApp(1, 2), "B"); // B
        System.out.println(map.size()); // 1
        System.out.println(map.entrySet());
    }
    
}


