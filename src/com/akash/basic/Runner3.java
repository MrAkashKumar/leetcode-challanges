package com.akash.basic;

public class Runner3 {

    public static void main(String[] args) {
        
        new Y().method(100);
        new Y().method(100.00);
    }

    static class X{
        void method(int a){
            System.out.println("ONE");
        }
     
        void method(double d){
            System.out.println("TWO");
        }
    }
     
    static class Y extends X{
        @Override
        void method(double d){
            System.out.println("THREE");
        }
    }
}
