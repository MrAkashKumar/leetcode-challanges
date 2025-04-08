package com.akash.basic.hashMap;

import java.util.HashMap;
import java.util.Map;

import com.akash.basic.hashMap.Runner1.MockApp;

public class Runner7{

    static class Student {
    
    private int id;

    public Student(){

    }

    public Student(int id, String name) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id; // Simple implementation for demonstration
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id;
    }

    }
    
    public static void main(String[] args) {
        HashMap<Student, String> studentMap = new HashMap<>();
        
        Student student1 = new Student(1, "John");
        studentMap.put(student1, "Student1");
        
        // When retrieving a value
        Student student2 = new Student(1, "Jane");
        String value = studentMap.get(student2);
        
        System.out.println(value); 
       
    }
    
}


