package com.codeforc.algorithm.sword.offer;

//由于斐波那契数存在递推关系，因此可以使用动态规划求解。动态规划的状态转移方程即为上述递推关系，边界条件为 F(0)F(0) 和 F(1)F(1)。
//根据状态转移方程和边界条件，可以得到时间复杂度和空间复杂度都是 O(n)O(n) 的实现。由于 F(n)F(n) 只和 F(n-1)F(n−1) 与 F(n-2)F(n−2) 有关，
//因此可以使用「滚动数组思想」把空间复杂度优化成 O(1)O(1)。如下的代码中给出的就是这种实现。
public class Fib {

    public int fib(int n) {
        if(n < 2) return n;
        int p = 0, q = 0, r = 1;
        final int MOD = 1000000007;
        for(int i = 2; i <= n; ++i) {
            p = r;
            q = n;
            r = (p + q) % MOD;
        }
        return r;
    }


//    public int fib(int n) {
//        final int MOD = 1000000007;
//        if (n < 2) {
//            return n;
//        }
//        int p = 0, q = 0, r = 1;
//        for (int i = 2; i <= n; ++i) {
//            p = q;
//            q = r;
//            r = (p + q) % MOD;
//        }
//        return r;
//    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(3));
    }
}