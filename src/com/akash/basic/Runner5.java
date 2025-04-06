package com.akash.basic;

import java.util.HashMap;
import java.util.Map;

import com.akash.basic.Runner1.MockApp;

public class Runner5{

    static class MyKey {
        int val;
        MyKey(int val) { this.val = val; }
    
        public int hashCode() {
            System.out.println("from hashcode "+val%3);
            return val % 3;

            // 0%3 ->0
            // 1%3 ->1
            // 2%3 -> 2
            // 3%3 ->0
            // 4%3 -> 1
            // 5%3 -> 2
            
        }
    
        public boolean equals(Object obj) {
            System.out.println("from equals "+(this.val == ((MyKey)obj).val));
            return this.val == ((MyKey)obj).val;
        }
    }
    
    public static void main(String[] args) {
        Map<MyKey, String> map = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            map.put(new MyKey(i), "val" + i);
        }
        System.out.println(map.size()); //4
    }
    
}


