package com.codeforc.algorithm.sword.offer;

import sun.security.rsa.RSAUtil;

//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
//你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
//给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
//输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//f(i, j) = max{f(i - 1, j), f(i, j - 1)} + grid[i][j]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
public class DpMaxValue {

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.println("+++++++ i : " + i + " +++++++ j : " + j);

                dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i - 1][j - 1];
                int dpj = dp[j];
                System.out.println("dpj : " + dpj);
                int dpjd = dp[j - 1];
                System.out.println("dpj-1 : " + dpjd);
                int gridItem = grid[i - 1][j - 1];
                System.out.println("gridItem : " + gridItem);
                for(int x = 0 ; x < dp.length;x++) {
                    System.out.print(dp[x] + ",");
                }
                System.out.println();
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        DpMaxValue dpMaxValue = new DpMaxValue();
        int i = dpMaxValue.maxValue(grid);
        System.out.println(i);
    }
}