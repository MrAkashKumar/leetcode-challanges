package com.akash.basic;

import java.util.HashMap;
import java.util.Map;

public class Runner6 {

    public static void main(String[] args) {
        
        Map<KeyApp, String> map = new HashMap<>();
            map.put(new KeyApp(1), "A");
            map.put(new KeyApp(2), "B");
            map.put(new KeyApp(3), "C");

            System.out.println(map.size()); /* */

    }
    

    static class KeyApp {

        private int id;
        private String name;
    
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        KeyApp(int id) {
            this.id = id;
        }
    
        public int hashCode() {
            return 1;
        }
    }




    
    
}
