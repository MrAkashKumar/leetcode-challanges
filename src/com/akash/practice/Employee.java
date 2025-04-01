package com.akash.practice;

public class Employee {

    private String name;
        private String dept;
        private String sal;

        public Employee(String name, String dept, String sal) {
            this.name = name;
            this.dept = dept;
            this.sal = sal;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getDept() {
            return dept;
        }
        public void setDept(String dept) {
            this.dept = dept;
        }
        public String getSal() {
            return sal;
        }
        public void setSal(String sal) {
            this.sal = sal;
        }
    

}
