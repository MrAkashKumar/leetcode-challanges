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
