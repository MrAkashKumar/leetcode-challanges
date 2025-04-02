package com.akash.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Questions {

    
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9,12,3,11,13,19,6,8,2,16);

        /* find only even number with reverse order */
        List<Integer> responseList = findOnlyEvenNumberWithReverseOrder(list);
        System.out.println(responseList);

        /* find occurance of character in words */
        String str = "abcfksldodslsldkd";
        Map<Character, Long> map = findFrequencyOfWordsCharacter(str);
        /*use entryset with each loop to find getKey and getValue */
        System.out.println(map);

        /* find the group list of employee based on department */
        List<Employee> employeeList = Arrays.asList(new Employee("Akash", "MECH", "20000"),
                                new Employee("John", "ELEC", "25000"),
                                new Employee("Jane", "CSE", "22000"));
        Map<String, List<Employee>> deptEmployeeList = findDepartmentWiseEmployee(employeeList);
         /*use entryset with each loop to find getKey and getValue */
        System.out.println(deptEmployeeList);


                            

    }

    private static List<Integer> findOnlyEvenNumberWithReverseOrder(List<Integer> list){
        return list.stream().filter(b-> b%2==0).sorted((x,y)-> y-x).collect(Collectors.toList());
    }

    private static Map<Character, Long> findFrequencyOfWordsCharacter(String str){
        return str.chars().mapToObj(c-> (char) c ).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static Map<String, List<Employee>> findDepartmentWiseEmployee(List<Employee> employeesList){
        return employeesList.stream().collect(Collectors.groupingBy(Employee::getDept));
    }

    

}
