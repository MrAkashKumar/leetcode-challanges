package com.akash.leetcode;

public class MaxProfitBestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7,1, 5, 3, 6, 4};
        int maxValue = maxProfit(prices);
        System.out.println(maxValue);
    }
        
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