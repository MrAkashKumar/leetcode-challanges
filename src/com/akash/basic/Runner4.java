package com.akash.basic;

public class Runner4 {

    public static void main(String[] args) {

        ConcateAndSum concateAndSum = new ConcateAndSum();
        System.out.println(concateAndSum.add(10, 10));
        System.out.println(concateAndSum.add("10", 10));
        System.out.println(concateAndSum.add(10, 20, "30"));
        System.out.println(concateAndSum.add("10", 20, "30"));
        System.out.println(concateAndSum.add("10", 20, 30));
        
    }

    public static class ConcateAndSum {
        
        int add(int a, int b){
            return a + b;
        }

        String add(int a, int b, String c){
            return a+b+c;
        }

        String add(String a, int b){
            return a+b;
        }

        String add(String a, int b, String c){
            return a+b+c;
        }

        String add(String a, int b, int c){
            return a+b+c;
        }
    }

}
