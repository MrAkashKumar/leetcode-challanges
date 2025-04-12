package com.akash.leetcode;
/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * Type - Array
 */
public class MaxProfitBestTimeToBuyAndSellStock121 {

    public static void main(String[] args) {
        int[] prices = {7,1, 5, 3, 6, 4};
        int maxValue = maxProfit(prices);
        System.out.println(maxValue);
    }
    /*
     * 1. We need to find the maximum profit we can make by buying and selling a stock.
     * 2. We can only buy and sell once.
     * 3. We need to find the best time to buy and sell the stock.
     * 4. We need to find the maximum profit we can make by buying and selling a stock.
     * 5. We can only buy and sell once.
     * 6. We need to find the best time to buy and sell the stock.
     */
    /* Time and space complexity is O(n) and O(1) */   
    private static int maxProfit(int[] prices) {
            
            int lsf = Integer.MAX_VALUE;
            int op = 0; /*  overall profit */ 
            int pist = 0; /* profit if sold today */ 
            
            for(int i = 0; i < prices.length; i++){
                if(prices[i] < lsf){  /* if we found new buy value which is more smaller then previous one */ 
                    lsf = prices[i]; /* update our least so far */ 
                }
                pist = prices[i] - lsf;  /* calculating profit if sold today by, Buy - sell */ 
                if(op < pist){ /* if pist is more then our previous overall profit */
                    op = pist;  /* update overall profit */ 
            }
        }
        return op;
            
    }
}