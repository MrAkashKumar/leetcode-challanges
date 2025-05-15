package com.akash.basic;

public class Runner1 {

    static class A{
 
    }
     
    static class B extends A{
     
    }
     
    static class C extends B{
     
    }

    static void overloadedMethod(A a){
        System.out.println("ONE");
    }
     
    static void overloadedMethod(B b){
        System.out.println("TWO");
    }
     
    static void overloadedMethod(Object obj){
        System.out.println("THREE");
    }
   
    public static void main(String[] args){
        C c = new C();
        overloadedMethod(c);
        A a = new C();
        overloadedMethod(a);
        B b = new B();
        overloadedMethod(b);
        

    }
    
}