package com.akash.leetcode;
/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class BestBuySellStock121 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int response = maxProfit(prices);
        System.out.println(response);
        
    }
    /*
     * The idea is to keep track of the minimum price seen so far and the maximum profit that can be made.
     * For each price, we check if it's less than the minimum price seen so far. If it is, we update the minimum price.
     * If it's greater than the minimum price, we calculate the profit and update the maximum profit if necessary.
     * 
     * This approach ensures that we only traverse the array once, making it efficient.
     */
    /*
     * Time complexity - 0(n)
     * space complexity - 0(1)
     */
    public static int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){
            /* comparision min price */
            if(price < minPrice){
                minPrice = price;
            }else if( price - minPrice > maxProfit){
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
        
    }

}
