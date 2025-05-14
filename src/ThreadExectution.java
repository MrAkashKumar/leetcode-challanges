import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ThreadExectution {

    public static void main(String[] args) {
       
            occuranceOfString("abc");

    }

    private static void occuranceOfString(String str){

         Map<Character, Long> occuranceOfString = str.chars().mapToObj(m -> (char) m).
         collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(occuranceOfString);

    }
    
}
