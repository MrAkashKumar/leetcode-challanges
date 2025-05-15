package com.akash.basic.oops;

public class Runner1 {

    public static void main(String[] args) throws Exception{
        //Child obj3 = new Person();
        //obj3.display(); // error
        System.out.println("------------");
		Person p = new Child();
		p.display(); // child.Display() called}
    }

     static public class Person{

        public void display(){
            System.out.println("Person.Display() called");
        }
    }
    
    static class Child extends Person{

        public void display(){
            System.out.println("Child.Display() called");
        }
    }
    
    
}


