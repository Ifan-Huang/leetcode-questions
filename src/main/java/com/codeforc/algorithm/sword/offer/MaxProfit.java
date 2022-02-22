package com.codeforc.algorithm.sword.offer;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(price, cost);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] nums = {5,3,1,2,6,10,2,39,20};
        int result = maxProfit.maxProfit(nums);
        System.out.println(result);
    }
}