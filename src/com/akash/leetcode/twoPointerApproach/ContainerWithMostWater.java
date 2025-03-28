package com.akash.leetcode.twoPointerApproach;
/*
 * https://leetcode.com/problems/container-with-most-water/description/
 * Topics - Array, Two-pointer
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,1};
        int maxAmountOfWater = maxAreaWater(height);
        System.out.println(maxAmountOfWater);
        int maxAreaOfWater = maxAreaViaBruteApproach(height);
        System.out.println(maxAreaOfWater);
    }

    /*
     * two pointer approach
     * time complexitity - o(n)
     * space complexity - o(1)
     * / depending on minimum height we will move points - we will chose minimum height
     * 
     * Reference - 
     * https://www.youtube.com/watch?v=ZHQg07n_tbg&ab_channel=Codebix
     * https://youtu.be/QzZ7nmouLTI
     */
    private static int maxAreaWater(int[] height){
        int left = 0; int right = height.length-1;
        int maxWaterArea = 0;
        while (left <= right) {
            /*
             *  find the maximum area of water in container 
             */
            int area = Math.min(height[left], height[right]) * (right -left);
            Math.max(maxWaterArea, area);
            /*
             * i will take minimum pwith the help between two left and right 
             * which one minimum then will move our pointer left or right 
             */
            if(height[left] < height[right]){
                left++;
            }else{
                right --;
            }
            
        }
        return maxWaterArea;
    }

    /*
     * brute approach technique
     * time complexity - o(square of n)
     * space complexity - o(1)
     */
    private static int maxAreaViaBruteApproach(int[] height){
        int length = height.length;
        int maxWaterArea = 0;
        for(int i = 0; i< length; i++){
            for(int j = i+1; j< length; j++){
                int area = Math.min(height[i], height[j]) * (j-i);
                maxWaterArea = Math.max(maxWaterArea, area); // update max Water Area
            }
        }
        return maxWaterArea;
    }

}
