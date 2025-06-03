import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {
    
    //collect of number
    //collection 

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,4,6,2,6,8,9);
        frequencyNumber(list);
    }


    private static void frequencyNumber(List<Integer> number){
        Map<Integer, Long> map = number.stream().filter(e-> e % 2==0).
        collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

    //single core - 
    //multiple core - performance wise good and it will not follow inseration order
//
// A extends B
 // B extends A 

  //Set<Stude
  //  => n+1 problem 


  static class Student{

    private Integer id;
    private String name;
    private String dept;

    // if id and depart are same it will duplicate otherwise new record

    

  }


  

    

}
