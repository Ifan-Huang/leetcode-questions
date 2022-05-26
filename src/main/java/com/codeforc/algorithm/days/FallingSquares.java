package com.codeforc.algorithm.days;

import java.util.ArrayList;
import java.util.List;

/**
 * 在无限长的数轴（即 x 轴）上，我们根据给定的顺序放置对应的正方形方块。
 * 第 i 个掉落的方块（positions[i] = (left, side_length)）是正方形，其中left 表示该方块最左边的点位置(positions[i][0])，
 * side_length 表示该方块的边长(positions[i][1])。
 * 每个方块的底部边缘平行于数轴（即 x 轴），并且从一个比目前所有的落地方块更高的高度掉落而下。在上一个方块结束掉落，并保持静止后，才开始掉落新方块。
 * 方块的底边具有非常大的粘性，并将保持固定在它们所接触的任何长度表面上（无论是数轴还是其他方块）。邻接掉落的边不会过早地粘合在一起，因为只有底边才具有粘性。
 * 返回一个堆叠高度列表ans 。每一个堆叠高度ans[i]表示在通过positions[0], positions[1], ..., positions[i]表示的方块掉落结束后，
 * 目前所有已经落稳的方块堆叠的最高高度。
 */
public class FallingSquares {

    /**
     * positions[left][side_length]
     * 需要用一个数组记录正方形的x坐标的右边界点。然后再判断下一个正方形落点是否和记录的点重合，如果重合则需要再原基础上递增高度，
     * 如果不重合则重新计算。
     *
     */
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ans = new ArrayList<>();

        int leftIndex = 0;
        int lengthIndex = 1;
        int tempH = 0;
        int tempR = 0;
        for (int[] position : positions) {
            int l = position[leftIndex];
            int length = position[lengthIndex];
            int r = l + length;

            //判断是否是重叠的,重叠递增、并且tempH和tempR递增。
            if (l < tempR) {
                ans.add(length + tempH);
                tempH += length;
            } else {
                //不重叠，将tempR tempH置新
                ans.add(Math.max(length, tempH));
                tempH = length;
            }
            tempR = r;
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] positions = {{1, 2}, {2, 3}, {6, 1}};
//        int[][] positions = {{100, 100}, {200, 100}};
        int[][] positions = {{6, 1}, {9, 2}, {2, 4}};
        FallingSquares fallingSquares = new FallingSquares();
        List<Integer> integers = fallingSquares.fallingSquares(positions);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
