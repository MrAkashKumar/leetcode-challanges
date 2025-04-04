import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int arr[] = {1, 2, 2, 3, 4, 4 };
        int length = arr.length;
        removeDuplicateSortedArray(arr, length);

        /*
         * i/p: {0000, 1011, 1001, 1000}
            o/p: {0000, 1000, 1001, 1011}
         */
        int [] num = {2, 3, -8, 7, -1, 2, 3};   
        maximumSubArray(num);

        /*
         * Given an array arr[], the task is to find the subarray that has the maximum sum and return its sum.
                    Input: arr[] = {2, 3, -8, 7, -1, 2, 3}

                    Output: 11
                    Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.
         * 
         */

    }

    private static void maximumSubArray(int[] arr){

        int current = arr[0];
        int max =  arr[0];
        for (int i = 0; i < arr.length; i++) {
            current = Math.max(arr[i], arr[i]+ current);

            max = Math.max(max, current);
        }
        System.out.println(max);

    }

    private static void removeDuplicateSortedArray(int[] arr, int length){
        Integer [] num = new Integer[length];
        Set<Integer> set = new LinkedHashSet<>();
        for (Integer n : arr) {
            set.add(n);
        }
        int i=0;
        for (Integer setValue : set) {
            num[i] = setValue;
            i++;
        }
        while (i < num.length) {
            num[i++] = null;
        }
        System.out.println(Arrays.toString(num));

    }



    

}
