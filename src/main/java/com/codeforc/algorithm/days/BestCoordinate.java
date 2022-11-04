package com.codeforc.algorithm.days;

/**
 * 给你一个数组 towers和一个整数 radius 。
 * 数组 towers 中包含一些网络信号塔，其中towers[i] = [xi, yi, qi]表示第i个网络信号塔的坐标是(xi, yi)且信号强度参数为qi。所有坐标都是在 X-Y 坐标系内的整数坐标。
 * 两个坐标之间的距离用 欧几里得距离计算。
 * 整数radius表示一个塔 能到达的 最远距离。如果一个坐标跟塔的距离在 radius以内，那么该塔的信号可以到达该坐标。在这个范围以外信号会很微弱，所以 radius以外的距离该塔是 不能到达的。
 * 如果第 i个塔能到达 (x, y)，那么该塔在此处的信号为⌊qi / (1 + d)⌋，其中d是塔跟此坐标的距离。一个坐标的 信号强度 是所有 能到达该坐标的塔的信号强度之和。
 * 请你返回数组 [cx, cy] ，表示 信号强度 最大的 整数 坐标点(cx, cy) 。如果有多个坐标网络信号一样大，请你返回字典序最小的 非负 坐标。
 * 注意：
 * 坐标(x1, y1)字典序比另一个坐标(x2, y2) 小，需满足以下条件之一：
 * 要么x1 < x2，
 * 要么x1 == x2 且y1 < y2。
 * ⌊val⌋表示小于等于val的最大整数（向下取整函数）。
 * 示例 2：
 * 输入：towers = [[23,11,21]], radius = 9
 * 输出：[23,11]
 * 解释：由于仅存在一座信号塔，所以塔的位置信号强度最大。
 * 示例 3：
 * 输入：towers = [[1,2,13],[2,1,7],[0,1,9]], radius = 2
 * 输出：[1,2]
 * 解释：坐标 (1, 2) 的信号强度最大。
 */
public class BestCoordinate {

    /**
     * 观察数据范围：无论是 towers 数组大小、坐标 (x, y)(x,y) 的值域大小，还是最远距离 k = radius，取值均不超过 5050。
     * 因此我们可以直接采用「模拟」的方式进行求解，而不会面临 TLE 或 MLE 的风险。
     * 具体的，我们建立一个大小为 110 \times 110110×110 的棋盘 g，用于记录每个坐标点的信号值，即 g[i][j] = xg[i][j]=x 代表坐标 (i, j)(i,j) 的信号值为 xx。
     * 其中 110110 的大小是利用了「任意坐标 (x, y)(x,y) 的取值范围不超过 5050」，同时「最远距离 kk 不超过 5050」并且「最终答案为非负坐标」而定。
     * 随后，我们可以枚举所有 towers[i] = (a, b, q)towers[i]=(a,b,q)，并检查以该塔为中心点，大小为 (k + k)^2(k+k)
     * 2
     *   的矩阵中的所有点（该塔所能贡献信号的所有坐标均落在矩阵中），枚举过程中使用变量 val 记录最大信号值，使用 x 和 y 记录答案坐标。
     */
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[][] g = new int[110][110];
        int x = 0, y = 0, val = 0;
        for (int[] t : towers) {
            int a = t[0], b = t[1], q = t[2];
            for (int i = Math.max(0, a - radius); i <= a + radius; i++) {
                for (int j = Math.max(0, b - radius); j <= b + radius; j++) {
                    double d = Math.sqrt((a - i) * (a - i) + (b - j) * (b - j));
                    if (d > radius) continue;
                    g[i][j] += Math.floor(q / (1 + d));
                    if (g[i][j] > val) {
                        x = i; y = j; val = g[i][j];
                    } else if (g[i][j] == val && (i < x || (i == x && j < y))) {
                        x = i; y = j;
                    }
                }
            }
        }
        return new int[]{x, y};
    }
}