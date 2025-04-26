import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {        

        
    }


    /*
     * find the duplicate number - 287
     * Floyd’s Tortoise and Hare – Detect Cycle
     *  O(n) time and O(1) space
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
    
        // Step 1: Detect intersection point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
    
        // Step 2: Find entrance to the cycle (duplicate)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
    
        return slow;
    }


    /*
     *  binary search
     *  single non duplicate no - 287
     *  Time: O(log n)
     *  Space: O(1)
     */
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
    
        while (low < high) {
            int mid = low + (high - low) / 2;
    
            // Ensure mid is even for easier pair checking
            if (mid % 2 == 1) mid--;
    
            if (nums[mid] == nums[mid + 1]) {
                // Unique element is in the right half
                low = mid + 2;
            } else {
                // Unique element is in the left half (including mid)
                high = mid;
            }
        }
    
        return nums[low];
    }
    


    /*
     * https://leetcode.com/problems/squares-of-a-sorted-array/description/
     * https://leetcode.com/problems/course-schedule-ii/description/
     * 
     */

    private static void secondHightSal(){

        List<Long>  list = new ArrayList<>();
            
        Long salr= list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findAny().get();


    }

    
}
